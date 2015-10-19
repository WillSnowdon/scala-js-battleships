package battleships.geometry

/**
 * @author willsnowdon
 */
case class Point(x: Int, y: Int){
  def + (p: Point) = Point(x + p.x, y + p.y)
  def / (d: Int) = Point(x / d, y / d)
  def - (that: Point) = Point(x - that.x, y - that.y)
  def x (that: Point): Int = x * that.y - that.x * y;
  
  def addX(v: Int) = Point(x + v, y)
  def addY(v: Int) = Point(x, y + v)
  def == (that: Point): Boolean = x == that.x && y == that.y
}
