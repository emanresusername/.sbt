libraryDependencies += "com.lihaoyi" % "ammonite" % "0.8.+" % "test" cross CrossVersion.full

initialCommands in (Test, console) := """ammonite.Main().run()"""

// https://issues.scala-lang.org/browse/SI-3623?focusedCommentId=76104&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-76104
target <<= baseDirectory { file("/tmp/sbt/") / _.toString }
