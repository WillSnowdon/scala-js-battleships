package battleships.geometry

/**
 * @author willsnowdon
 */

case class Box(left: Int, right: Int, top: Int, bottom: Int) {
  
  def intersects(that: Box) = 
    !(   that.left > right
      || that.right < left
      || that.bottom > top
      || that.top < bottom
    )
}

object Box {
  def apply(l: LineSegment): Box = {
    def gs(i: Int, j: Int) =
      if (i < j) 
        (i, j)
      else 
        (j, i)
    val (left, right) = gs(l.start.x, l.end.x)
    val (bottom, top) = gs(l.start.y, l.end.y)
    Box(left, right, top, bottom)  
  }
}
