package org.scalactest.chessboard

class Game(boardWidth: Int, boardHeight: Int, pieces: List[Symbol]) {
  type Chessboard = List[Piece]
  type Solutions = Set[Chessboard]
  
  def playPieces(pcs: List[Symbol]): Solutions = pcs match {
    case Nil => Set(List())
    case hd :: tail => for {
      pieces <- playPieces(tail)
      r <- 0 until boardHeight
      c <- 0 until boardWidth
      newPiece = symbolToPiece(hd, Coord(r, c))
      if (isQuiet(newPiece, pieces))
    } yield (newPiece :: pieces)
  }
  
  def searchSolutions: Set[Chessboard] = {
    val t0 = System.nanoTime()
    val boards = playPieces(pieces)
    val t1 = System.nanoTime()
    println("It took " + (t1 - t0)/1000000000.0 + " seconds")  
    println("There have been calculated " + boards.size + " non-unique boards")  
    boards
  }
  
  def printChessboard(cb: Chessboard) = {
    for (y <- 0 until boardHeight) {
      for (x <- 0 until boardWidth) {
        cb.find(p => p.c.x == x && p.c.y == y) match {
          case Some(x) => print(s"$x ")
          case None => print(". ")
        }
      }; println
    }; println
  }
  
  def printFirstOnes(l: List[Chessboard], qty: Int = 3) {
    l.take(qty).foreach{ cb => printChessboard(cb) }
  }
  
  private def isQuiet(piece: Piece, rest: Chessboard) = 
    rest forall { p => !piece.threatens(p.c) && !p.threatens(piece.c) }
  
  private def symbolToPiece(p: Symbol, c: Coord): Piece =
    Map('Bishop -> Bishop(c), 
      'King -> King(c), 
      'Knight -> Knight(c), 
      'Queen -> Queen(c), 
      'Rook -> Rook(c))(p)
}


/* Usage: 
  val game = new Game(7,7, List('King,'King, 'Queen, 'Queen, 'Bishop, 'Bishop, 'Knight))
*/