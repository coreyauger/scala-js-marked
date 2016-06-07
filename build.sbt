
import sbt.Keys._

//sonatypeSettings

lazy val root = project.in(file(".")).enablePlugins(ScalaJSPlugin).settings(
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  resolvers += "NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/",
  publishTo := Some("NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/")
  //  publishMavenStyle :=  true
)

lazy val demo = (project in file("demo"))
  .settings(demoSettings:_*)
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(root)


lazy val demoSettings = Seq(
  name := s"marked-demo",
  scalaVersion := "2.11.6",
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.0"
  )
)

name := "Type-safe and Scala-friendly library over marked.js (A full-featured markdown parser and compiler, written in JavaScript. Built for speed)"

normalizedName := "scala-js-marked"

version := "0.0.2-SNAPSHOT"

organization := "io.surfkit"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.4", "2.11.7")


libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

jsDependencies in Test += RuntimeDOM

homepage := Some(url("http://www.surfkit.io/"))

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

scmInfo := Some(ScmInfo(
    url("https://github.com/coreyauger/scala-js-marked"),
    "scm:git:git@github.com/coreyauger/scala-js-marked.git",
    Some("scm:git:git@github.com:coreyauger/scala-js-marked.git")))

publishMavenStyle := true


pomExtra := (
  <developers>
    <developer>
      <id>coreyauger</id>
      <name>Corey Auger</name>
      <url>https://github.com/coreyauger/</url>
    </developer>
  </developers>
)

pomIncludeRepository := { _ => false }
