import xerial.sbt.Sonatype.sonatypeLegacy

organization := "com.github.pjfanning"
name := "pekko-discovery-consul"

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / crossScalaVersions := Seq("2.12.19", "2.13.14", "3.3.3")

ThisBuild / version := "1.0.0-SNAPSHOT"

javacOptions += "--release 11"

val pekkoVersion = "1.0.3"

update / checksums := Nil

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
  "org.apache.pekko" %% "pekko-discovery" % pekkoVersion,
  "com.typesafe" % "config" % "1.4.3",
  "org.kiwiproject" % "consul-client" % "0.6.0",
  "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
  "org.apache.pekko" %% "pekko-slf4j" % pekkoVersion % Test,
  "org.testcontainers" % "consul" % "1.20.1" % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "ch.qos.logback" % "logback-classic" % "1.3.14" % Test
)

ThisBuild / sonatypeCredentialHost := sonatypeLegacy

publishMavenStyle := true

publishTo := sonatypePublishToBundle.value

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

homepage := Some(url("https://github.com/pjfanning/pekko-discovery-consul"))

licenses := Seq("The Apache Software License, Version 2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

pomExtra := (
  <developers>
    <developer>
      <id>pjfanning</id>
      <name>PJ Fanning</name>
      <url>https://github.com/pjfanning</url>
    </developer>
    <developer>
      <id>pekko-management-contributors</id>
      <name>Apache Pekko Management Contributors</name>
      <url>https://github.com/apache/pekko-management/graphs/contributors</url>
      <email>dev@pekko.apache.org</email>
    </developer>
  </developers>
)

