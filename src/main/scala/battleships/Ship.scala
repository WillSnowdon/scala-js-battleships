package battleships
import battleships.geometry._
import battleships.geometry.Point

/**
 * @author willsnowdon
 */
abstract class Ship(val location: Point, val direction: Direction, shipHealth: Int = -1) {
  
  def length: Int
  def move(p: Point): Ship = Ship(this, location + p, direction, health)
  
  private def initHealth: Int = 
    if (shipHealth < 0 || shipHealth > length)
      length
    else shipHealth
  
  lazy val health = initHealth
  
  def isDestroyed = health == 0
  
  def incrementHealth = Ship(this, location, direction, health + 1)
  def decrementHealth = Ship(this, location, direction, health - 1)
    
  def end(): Point = {
    val e = length - 1
    direction match {
      case East() => location addX -e
      case West() => location addX e
      case North() => location addY e
      case South() => location addY - e
    }
  }
  
  def clash(that: Ship): Boolean = LineSegment(location, end) boxIntersects LineSegment(that.location, that.end)
  def clash(p: Point): Boolean = LineSegment(location, end) boxIntersects LineSegment(p, p)
}
 
object Ship {
  def apply(s: String, p: Point, d: Direction): Ship = s match {
    case "destroyer" => Destroyer(p, d, -1)
    case "battleship" => Battleship(p, d, -1)
    case _ => AircraftCarrier(p, d, -1)
  }
  
  protected def apply(s: Ship, p: Point, d: Direction, h: Int): Ship = s match {
    case s: Destroyer => Destroyer(p, d, h)
    case s: Battleship => Battleship(p, d, h)
    case _ => AircraftCarrier(p, d, h)
  }
  
  case class Destroyer(l: Point, d: Direction, h: Int) extends Ship(l, d, h) {
    def length = 3
  }
  
  case class Battleship(l: Point, d: Direction, h:Int) extends Ship(l, d, h) {
    def length = 4
  }
  
  case class AircraftCarrier(l: Point, d: Direction, h: Int) extends Ship(l, d, h) {
    def length = 5
  }
  
}

