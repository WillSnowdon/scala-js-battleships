package battleships
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.{document, html}
import scala.scalajs.js
import battleships.views.{
   BattleshipsGrid,
   GameInfo
}


@JSExport
object BattleshipsExample {

  @JSExport
  def main(container: html.Div): Unit = {
    val game = Game(10, List(
        "destroyer",
        "battleship"
      ))

    document.getElementById("battleships").appendChild(
        BattleshipsGrid(game).view.render
    )
    
    document.getElementById("gameInfo").appendChild(
        GameInfo(game).view.render
    )

  }
}
