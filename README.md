# Example Scala.js application

This is a pretty barebone example of an application written in
[Scala.js](http://www.scala-js.org/). In particular, it links
in libraries that are indispensible in being productive working with Scala.js.

## Battleships

The app is a very basic one sided game of Battleships using `scalatags` lib with reactive views.  No styling has been applied so
it's not the nicest looking example but this is because for me it's only purpose was as a way to experiment with `Scala.js`.

## Get started

To get started, run `sbt ~fastOptJS` in this example project. This should
download dependencies and prepare the relevant javascript files. If you open
`localhost:12345/target/scala-2.11/classes/index-dev.html` in your browser. You can then
edit the application and see the updates be sent live to the browser
without needing to refresh the page.

## The optimized version

Run `sbt fullOptJS` and open up `index-opt.html` for an optimized (~200kb) version
of the final application, useful for final publication.
