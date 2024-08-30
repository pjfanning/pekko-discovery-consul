import xerial.sbt.Sonatype.sonatypeLegacy

organization := "com.github.pjfanning"
name := "pekko-discovery-consul"

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / crossScalaVersions := Seq("2.12.19", "2.13.14", "3.3.3")

javacOptions += "--release 11"

val pekkoVersion = "1.0.3"

update / checksums := Nil

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
  "org.apache.pekko" %% "pekko-discovery" % pekkoVersion,
  "org.kiwiproject" % "consul-client" % "0.6.0",
  "com.typesafe" % "config" % "1.4.3" % Test,
  "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
  "org.apache.pekko" %% "pekko-slf4j" % pekkoVersion % Test,
  "org.testcontainers" % "consul" % "1.20.1" % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "ch.qos.logback" % "logback-classic" % "1.3.14" % Test
)

AddMetaInfLicenseFiles.settings

ThisBuild / sonatypeCredentialHost := sonatypeLegacy

publishMavenStyle := true

publishTo := sonatypePublishToBundle.value

Test / publishArtifact := false

homepage := Some(url("https://github.com/pjfanning/pekko-discovery-consul"))

licenses := Seq("The Apache Software License, Version 2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/pjfanning/pekko-discovery-consul"),
    "scm:git@github.com:pjfanning/pekko-discovery-consul.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "pjfanning",
    name = "PJ Fanning",
    email = "",
    url = url("https://github.com/pjfanning")
  ),
  Developer(
    id = "pekko-management-contributors",
    name = "Apache Pekko Management Contributors",
    email = "dev@pekko.apache.org",
    url = url("https://github.com/apache/pekko-management/graphs/contributors")
  )
)
