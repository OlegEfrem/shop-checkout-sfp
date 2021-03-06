organization := "com.oef"

name := "shop-checkout-simple"

version := "1.0"

scalaVersion := "2.12.10"

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.3",
  "org.scalatest" %% "scalatest" % "3.0.3" % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.5" % Test
)

// run scalastyle at compile time
lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

// code coverage configuration
coverageEnabled := true

coverageHighlighting := true

coverageMinimum := 100

coverageFailOnMinimum := true

parallelExecution in Test := true