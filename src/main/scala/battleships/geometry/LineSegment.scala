package battleships.geometry
/**
 * @author willsnowdon
 */
case class LineSegment(start: Point, end: Point) {
    
  def boxIntersects(that: LineSegment): Boolean = Box(this) intersects Box(that)
    
  private def pointCross(p: Point): Int = {
    val a = LineSegment(Point(0, 0), Point(end.x - start.x, end.y - start.y))
    val b = Point(p.x - start.x, p.y - start.y)
    a.end x b
  }  
  
  def pointOnLine(p: Point): Boolean = pointCross(p).abs < LineSegment.epsilon
  
  private def touchOrCross(that: LineSegment): Boolean = {
    def rightOfLine(p: Point): Boolean = pointCross(p) < 0
    
    ( pointOnLine(that.start) ||
      pointOnLine(that.end) ||
      (rightOfLine(that.start) != rightOfLine(that.end)))
  }
  
  def intersects(that: LineSegment) = (
    boxIntersects(that) && touchOrCross(that) && that.touchOrCross(this)
  )
}

object LineSegment {
  def epsilon = 0.000001
}
