sbtPlugin := true

name := "sbt-ctags"

organization := "net.ceedubs"

description := "An SBT plugin to generate ctags for a project (including its dependencies)"

homepage := Some(url("https://github.com/ceedubs/sbt-ctags"))

startYear := Some(2014)

licenses := Seq(
  ("GPLv3", url("http://www.gnu.org/licenses/gpl-3.0.txt"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/ceedubs/sbt-ctags"),
    "scm:git:https://github.com/ceedubs/sbt-ctags.git",
    Some("scm:git:git@github.com:ceedubs/sbt-ctags.git")
  )
)

scalaVersion := "2.12.5"

sbtVersion in Global := "1.0.3"

crossSbtVersions := Vector("0.13.17", "1.1.0")

scalaCompilerBridgeSource := {
  val sv = appConfiguration.value.provider.id.version
  ("org.scala-sbt" % "compiler-interface" % sv % "component").sources
}

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8"
)

/* publishing */
publishMavenStyle := true

useGpg := true

// see https://github.com/sbt/sbt-pgp/issues/126
pgpSecretRing := pgpPublicRing.value

publishTo := {
  val v = version.value
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>ceedubs</id>
      <name>Cody Allen</name>
      <email>ceedubs@gmail.com</email>
    </developer>
  </developers>
)
