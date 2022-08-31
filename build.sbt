// Set default project scala version (used by sbt session)
scalaVersion := Versions.scala

// Set root project settings
lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.github.veysiertekin",
      scalaVersion := Versions.scala
    )
  ),
  name := "shopping-basket",
  libraryDependencies += "org.scalatest" %% "scalatest" % Versions.scalatest % Test
)
