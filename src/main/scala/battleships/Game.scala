package battleships
import battleships.geometry.Point
import battleships.Ship._
import battleships.Ships._
import rx._

/**
 * @author willsnowdon
 */
case class Game(gridSize: Int, ships: List[String]) {
  var sList: List[Ship] = Ships(ships, gridSize)
  private val shots: Var[Map[String, Point]] = Var(Map())
  println(sList)
  def shotExists(x: Int, y: Int):Boolean =
    shots().get(x.toString + y.toString).isDefined 
   
  def addShot(x: Int, y: Int): Unit = {
    val s = shots()
    val k: String = x.toString + y.toString
    if (!s.get(k).isDefined) {
      val p = Point(x, y)
      sList = adjustShipHealth(p)
      shots() = shots() ++ Map(k -> p)
    }
  }
  
  def shipsDestroyed = sList.count(_.isDestroyed) 
  
  def over = shipsDestroyed == sList.length
  
  def adjustShipHealth(p: Point): List[Ship] = 
    sList.map(s => 
      if (s clash p) s decrementHealth
      else s
    )
    
  def shotCount = shots().size
  
  def hit(p: Point): Boolean = 
    if (sList.exists { s => s clash p }) true
    else false
    
  def hitCount:Int = shots().filter(p => hit(p._2)).size
   
}
  
  
