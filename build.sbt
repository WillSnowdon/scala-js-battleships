import com.lihaoyi.workbench.Plugin._

enablePlugins(ScalaJSPlugin)

workbenchSettings

name := "Battleships"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.lihaoyi" %%% "scalatags" % "0.5.2",
  "com.lihaoyi" %%% "scalarx" % "0.2.8",
  "com.github.japgolly.scalajs-react" %%% "core" % "0.9.2",
  "com.github.japgolly.scalajs-react" %%% "extra" % "0.9.2"
)

jsDependencies ++= Seq(
  "org.webjars" % "react" % "0.12.2" / "react-with-addons.js" commonJSName "React"
)

skip in packageJSDependencies := false

bootSnippet := "battleships.BattleshipsExample().main(document.getElementById('canvas'));"

crossTarget in (Compile, packageJSDependencies) := file("js")

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

