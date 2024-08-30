/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt.Keys._
import sbt._

/**
 * Copies LICENSE and NOTICE files into jar META-INF dir
 */
object AddMetaInfLicenseFiles {

  private val baseDir = LocalRootProject / baseDirectory
  private val standardLicenseFile = Def.task[File](baseDir.value / "LICENSE")
  private val noticeFile = Def.task[File](baseDir.value / "NOTICE")

  val settings: Seq[Setting[_]] = inConfig(Compile)(
    Seq(
      resourceGenerators += copyFileToMetaInf(resourceManaged, standardLicenseFile, "LICENSE"),
      resourceGenerators += copyFileToMetaInf(resourceManaged, noticeFile, "NOTICE")))

  private def copyFileToMetaInf(dir: SettingKey[File], fromFile: Def.Initialize[Task[File]],
                                fileName: String) = Def.task[Seq[File]] {
    val toFile = resourceManaged.value / "META-INF" / fileName
    IO.copyFile(fromFile.value, toFile)
    Seq(toFile)
  }

}
