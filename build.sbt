ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.xrm"
ThisBuild / scalaVersion := "3.3.5"

lazy val global = project
  .in(file("."))
  .settings(
    name := "vidhls"
  )
  .aggregate(
    api,
    rest,
    impl
  )

lazy val api = project
  .settings(
    name := "api",
    libraryDependencies ++= commonDependencies
  )

lazy val impl = project
  .settings(
    name := "impl",
    libraryDependencies ++= commonDependencies
  )
  .dependsOn(
    api
  )


lazy val rest = project
  .settings(
    name := "rest",
    libraryDependencies ++= commonDependencies
  )
  .dependsOn(
    api,
    impl
  )

//Dependencies

val http4sVersion = "0.23.30"
val sfl4jVersion = "2.0.17"
val logbackVersion = "1.5.18"
val catseffectVersion = "3.6.1"
//Maybe add Circe for JSON

//libraryDependencies ++= Seq(
//  "org.http4s" %% "http4s-ember-server" % http4sVersion,
//  "org.http4s" %% "http4s-dsl" % http4sVersion,
//  "org.typelevel" %% "cats-effect" % catseffectVersion,
//  "org.slf4j" % "slf4j-api" % sfl4jVersion,
//  "ch.qos.logback" % "logback-classic" % logbackVersion
//)

lazy val commonDependencies = Seq(
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.typelevel" %% "cats-effect" % catseffectVersion,
  "org.slf4j" % "slf4j-api" % sfl4jVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion
)
