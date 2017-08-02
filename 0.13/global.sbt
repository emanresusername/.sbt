// https://issues.scala-lang.org/browse/SI-3623?focusedCommentId=76104&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-76104
target <<= baseDirectory { file("/tmp/sbt/") / _.toString }

libraryDependencies += "com.lihaoyi" % "ammonite" % "1.0.1" % "test" cross CrossVersion.full

sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main().run() }""")
  Seq(file)
}.taskValue

// TODO: notsure if coursier related or not https://stackoverflow.com/a/42211230
resolvers += "JBoss" at "https://repository.jboss.org/"
