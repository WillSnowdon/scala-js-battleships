package battleships.views
import rx._
import scalatags.JsDom.all._
import battleships.Game
import battleships.geometry.Point
import battleships.framework.all._

/**
 * @author willsnowdon
 */
case class BattleshipsGrid(game: Game) {
  
  def getShot(x: Int, y: Int) =
    if (!game.shotExists(x, y)) ""
    else if (game.hit(Point(x, y))) "Hit"
    else "Miss"
  
  def view = 
    div(
      Rx {
        if (game over) 
          h2("Game Over!")
        else 
          table(
            for {
              y <- 0 until game.gridSize
            } yield tr(
              for (x <- 0 until game.gridSize)
                yield td(
                  getShot(x, y),
                  onclick := {
                    () => game.addShot(x, y)
                  }    
                )
            )
          )
      }    
    )
}