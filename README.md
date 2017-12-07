# Chess problem - test assignment 

## Known bugs:
 - it double counts equal pieces
 - 

## Usage

> $ sbt console

> scala> import org.scalactest.chessboard._ 

> scala> val game = new Game(6,6, List('King, 'King, 'Queen, 'Queen, 'Bishop, 'Bishop, 'Knight))

> scala> game.searchSolutions
> It took 14.70351665 seconds
> There have been calculated 190016 non-unique boards
> res0: Set[game.Chessboard] = ....

> scala> game.printFirstOnes(res0.toList, 8)

> ... boards