import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.scalactest",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "ScalacTestAssignment",
    libraryDependencies += scalaTest % Test,
    javacOptions ++= Seq(
      "-Xmx2G",
      "-XX:+UseConcMarkSweepGC",
      "-XX:+CMSClassUnloadingEnabled"
    )
  )
