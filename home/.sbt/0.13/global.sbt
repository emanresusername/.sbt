libraryDependencies ++= {
    // caused problems loading sbt 0.13 projects
    // possibly plugin related? https://github.com/sbt/sbt/issues/3006#issuecomment-355199121
    if (Set("2.10").contains(scalaBinaryVersion.value)) {
      Nil
    } else {
      Seq(
        "com.lihaoyi" % "ammonite" % "1.0.5" % "test" cross CrossVersion.full
      )
    }
  }

sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main.main(args) }""")
  Seq(file)
}.taskValue

cancelable in Global := true
