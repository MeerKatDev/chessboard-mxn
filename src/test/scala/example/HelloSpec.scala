package org.scalactest.chessboard

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {

  "The Rook" should "threaten only in line" in {    
    assert( Rook( Coord(2,2) ).threatens( Coord(3,3) ) == false )
    assert( Rook( Coord(2,2) ).threatens( Coord(2,3) ) == true )
  }
  
  "The King" should "threaten only nearby pieces" in {    
    assert( King( Coord(2,2) ).threatens( Coord(3,3) ) == true )
    assert( King( Coord(2,2) ).threatens( Coord(2,3) ) == true )
    assert( King( Coord(2,2) ).threatens( Coord(1,2) ) == true )
    assert( King( Coord(2,2) ).threatens( Coord(4,4) ) == false )
  }
  
  "The Bishop" should "threaten only in diagonals" in {    
    assert( Bishop( Coord(2,2) ).threatens( Coord(3,3) ) == true )
    assert( Bishop( Coord(2,3) ).threatens( Coord(3,2) ) == true )
    assert( Bishop( Coord(2,2) ).threatens( Coord(2,3) ) == false )
  }
  
  "The Queen" should "threaten both in diagonals and in lines" in {  
    assert( Queen( Coord(2,2) ).threatens( Coord(3,3) ) == true )
    assert( Queen( Coord(2,2) ).threatens( Coord(2,3) ) == true )    
    assert( Queen( Coord(2,3) ).threatens( Coord(3,2) ) == true )
    
    assert( Queen( Coord(2,2) ).threatens( Coord(3,3) ) == true )
    assert( Queen( Coord(2,2) ).threatens( Coord(2,3) ) == true )
    
    assert( Queen( Coord(2,2) ).threatens( Coord(3,4) ) == false )
    assert( Queen( Coord(2,2) ).threatens( Coord(1,5) ) == false )
  }
    
}
