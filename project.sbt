//: ----------------------------------------------------------------------------
//: Copyright (C) 2017 Verizon.  All Rights Reserved.
//:
//:   Licensed under the Apache License, Version 2.0 (the "License");
//:   you may not use this file except in compliance with the License.
//:   You may obtain a copy of the License at
//:
//:       http://www.apache.org/licenses/LICENSE-2.0
//:
//:   Unless required by applicable law or agreed to in writing, software
//:   distributed under the License is distributed on an "AS IS" BASIS,
//:   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//:   See the License for the specific language governing permissions and
//:   limitations under the License.
//:
//: ----------------------------------------------------------------------------

organization in Global := "io.getnelson.nelson"

scalaVersion in Global := "2.11.11"

lazy val nelson = project.in(file(".")).aggregate(docs, core, http)

lazy val core = project

lazy val http = project.dependsOn(core % "test->test;compile->compile")

lazy val docs = project

enablePlugins(DisablePublishingPlugin)

addCommandAlias("ci", ";test;coverageReport;coverageAggregate;tut;unidoc")
