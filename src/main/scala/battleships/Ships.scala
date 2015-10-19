package battleships
import battleships.geometry._
import util.Random

/**
 * @author willsnowdon
 */
object Ships {
   private def getAdjustment(s: Ship): Point = s.direction match {
      case South() => Point(s.location.x, s.location.y + s.length)
      case East() => Point(s.location.x + s.length, s.location.y)
      case _ => s.location
   }
    
    def apply(s: List[String], gridSize: Int): List[Ship] = {
      val r = new Random
      def getPoint(s: Ship, x: Int, y: Int): Point = s.direction match {
        case East() => Point(x + s.length, y)
        case South() => Point(x, y + s.length)
        case _ => Point(x, y)
      }
      
      def placeUnique(s: Ship, l: List[Ship]): Ship = {
        val range = gridSize - s.length
        val ship = s move getPoint(s, r nextInt range, r nextInt range)
        if (l.exists { s => s clash ship })
          placeUnique(ship, l)
        else
          ship
      }
      
      def generate(s: List[String], l: List[Ship] = List()): List[Ship] = 
        if (s.isEmpty)
          l
        else {
          val ship = placeUnique(Ship(s.head, Point(0, 0), Direction random), l)
          generate(s.tail, l ::: List(ship))
        }
          
      generate(s)
    }
}