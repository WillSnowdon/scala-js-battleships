package battleships
import util.Random
/**
 * @author willsnowdon
 */

abstract class Direction

case class East() extends Direction
case class West() extends Direction
case class South() extends Direction
case class North() extends Direction

object Direction {
  val r = new Random
  
  def random(): Direction = r.nextInt(4) match {
    case 0 => East()
    case 1 => West()
    case 2 => South()
    case 3 => North()
  }
 
}