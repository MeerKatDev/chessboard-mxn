package org.scalactest.chessboard

import math.{ sqrt, pow, abs }

object Consts {  
  val ROOT_OF_FIVE = 2.23
  val ABOVE_ROOT_OF_TWO = 1.5
}

trait Piece {
  val c: Coord
  def threatens(c: Coord): Boolean
}

case class Coord(x: Int, y: Int) {
  def distanceFrom(c: Coord) = sqrt(pow(x - c.x, 2) + pow(y - c.y, 2))
  def inLineWith(c: Coord) = c.x == x || c.y == y
  def inDiagonalWith(c:Coord) = abs(c.x - x) == abs(c.y - y)
}

case class Rook(val c: Coord) extends Piece {
  override def toString = "R"
  def threatens(b: Coord) = c.inLineWith(b)
}

case class Bishop(val c: Coord) extends Piece {
  override def toString = "B"
  def threatens(b: Coord) = c.inDiagonalWith(b)
}

case class Queen(val c: Coord) extends Piece {
  override def toString = "Q"
  def threatens(b: Coord) = c.inDiagonalWith(b) || c.inLineWith(b)
}

case class King(val c: Coord) extends Piece {
  override def toString = "Ki"
  def threatens(b: Coord) = c.distanceFrom(b) < Consts.ABOVE_ROOT_OF_TWO
}

case class Knight(val c: Coord) extends Piece {
  override def toString = "Kn"
  def threatens(b: Coord) = abs( c.distanceFrom(b) - Consts.ROOT_OF_FIVE ) < 0.01
}