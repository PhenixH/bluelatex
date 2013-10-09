/*
 * This file is part of the \BlueLaTeX project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gnieh.blue
package http
package impl
package paper

import com.typesafe.config.Config

import tiscaf._

import gnieh.sohva.UserInfo

import scala.io.Source

/** Gives access to the synchronized resource list for the given paper.
 *
 *  @author Lucas Satabin
 */
class SynchronizedResourcesLet(paperId: String, config: Config) extends RoleLet(paperId, config) {

  def roleAct(user: UserInfo, role: PaperRole)(implicit talk: HTalk): Unit = role match {
    case Author =>
      // only authors may get the list of synchronized resources
      import FileProcessing._
      val files = configuration.paperDir(paperId).filter(_.extension.matches(synchronizedExt)).map(_.getName)
      talk.writeJson(files)
    case _ =>
      talk.writeJson(ErrorResponse("no_sufficient_rights", "Only authors may see the list of synchronized resources"))
        .setStatus(HStatus.Forbidden)
  }

}

