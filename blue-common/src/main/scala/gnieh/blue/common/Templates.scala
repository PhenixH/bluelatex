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
package common

import gnieh.mustache.MustacheProcessor

/** Give access to the templating system, and allows people to layout
 *  templates located in the configured directory
 *
 *  @author Lucas Satabin
 */
trait Templates {

  /** The template engine */
  val engine: MustacheProcessor

  /** Layouts the given template with the given parameters */
  def layout(name: String, params: (String, Any)*): String

}
