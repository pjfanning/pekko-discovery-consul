organization := "com.github.pjfanning"
name := "pekko-discovery-consul"

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / crossScalaVersions := Seq("2.12.19", "2.13.14", "3.3.3")

scalacOptions += "-target:jvm-11"

val pekkoVersion = "1.0.3"

update / checksums := Nil

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
  "org.apache.pekko" %% "pekko-discovery" % pekkoVersion,
  "com.typesafe" % "config" % "1.4.3",
  "com.orbitz.consul" % "consul-client" % "1.5.3",
  "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
  "org.apache.pekko" %% "pekko-slf4j" % pekkoVersion % Test,
  "org.testcontainers" % "consul" % "1.20.1" % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "ch.qos.logback" % "logback-classic" % "1.3.14" % Test
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

homepage := Some(url("https://github.com/pjfanning/pekko-discovery-consul"))

licenses := Seq("The Apache Software License, Version 2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

// releasePublishArtifactsAction := PgpKeys.publishSigned.value

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

