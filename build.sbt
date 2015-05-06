import SonatypeKeys._

sonatypeSettings

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Scala.js facade for bootstrap-datepicker"

normalizedName := "bootstrap-datepicker-facade"

version := "0.1"

organization := "org.querki"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.4", "2.11.5")

libraryDependencies ++= Seq(
  "org.querki" %%% "querki-jsext" % "0.2",
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "org.querki" %%% "jquery-facade" % "0.4"
)

jsDependencies += "org.webjars" % "bootstrap" % "3.3.4" / "bootstrap.min.js" dependsOn "jquery.min.js"

jsDependencies += "org.webjars" % "bootstrap-datepicker" % "1.4.0" / "bootstrap-datepicker.min.js" dependsOn "bootstrap.min.js"

jsDependencies in Test += RuntimeDOM

homepage := Some(url("http://www.querki.net/"))

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

scmInfo := Some(ScmInfo(
    url("https://github.com/jducoeur/bootstrap-datepicker-scalajs"),
    "scm:git:git@github.com:jducoeur/bootstrap-datepicker-scalajs.git",
    Some("scm:git:git@github.com:jducoeur/bootstrap-datepicker-scalajs.git")))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <developers>
    <developer>
      <id>jducoeur</id>
      <name>Mark Waks</name>
      <url>https://github.com/jducoeur/</url>
    </developer>
  </developers>
)

pomIncludeRepository := { _ => false }
