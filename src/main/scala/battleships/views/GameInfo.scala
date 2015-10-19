package battleships.views
import rx._
import scalatags.JsDom.all._
import battleships.Game
import battleships.framework.all._

/**
 * @author willsnowdon
 */
case class GameInfo(game: Game) {
  
  def getPerc(n: Int, d: Int) = 
    if (d == 0) 0
    else (n.toFloat / d.toFloat) * 100
    
  def liDisplay(shots: Int) =
    if (shots == 0) "none"
    else ""
  
  def view = div(
    h4("Stats"),
    Rx {
      val shots = game.shotCount
      val hits = game.hitCount
      val hitPerc = getPerc(hits, shots)
      val missPerc = 100 - hitPerc
      ul(
        li(
          span("Shots: " + shots)
        ),
        li(
          span("Hits: " + hits)    
        ),
        li(
          span(s"Ships Destroyed: ${game.shipsDestroyed}")
        ),
        li(
          span("Misses: " + (shots - hits))    
        ),
        li(display:=liDisplay(shots))(
          span(f"Hit Perc: $hitPerc%2.2f%%")    
        ),
        li(display:=liDisplay(shots))(
          span(f"Miss Perc: $missPerc%2.2f%%")    
        )
      )
      
    }    
  )
  
}