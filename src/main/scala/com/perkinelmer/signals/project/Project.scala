package com.perkinelmer.signals.project

import spray.json.{DefaultJsonProtocol, DeserializationException, JsObject, JsString, JsValue, RootJsonFormat}

case class Project(id: String, projectId: String, name: String)

object ProjectJsonProtocol extends DefaultJsonProtocol {
  //   unnecessary format
  //  final case class Users(users: Seq[User])
  //  implicit def toUsers(users: Seq[User]): Users = Users(users)
  //  implicit val usersFormat: RootJsonFormat[Users] = jsonFormat1(Users.apply)

  // below jsonFormat behave as not expected
  //  implicit val userIdFormat = jsonFormat(ID.apply[User] _, "value")
  //  implicit val nameFormat = jsonFormat(Name.apply _, "value")
  //  implicit val emailFormat = jsonFormat(Email.apply _, "value")
  //  implicit val userFormat = jsonFormat(User.apply, "id", "name", "email")
  //  implicit val userIdFormat = jsonFormat1(ID.apply[User])
  //  implicit val nameFormat = jsonFormat1(Name.apply)
  //  implicit val emailFormat = jsonFormat1(Email.apply)
  //  implicit val userFormat = jsonFormat3(User.apply)

  implicit val projectFormat: RootJsonFormat[Project] = new RootJsonFormat[Project] {
    override def read(json: JsValue): Project =
      json.asJsObject.getFields("id", "projectId", "name") match {
        case Seq(JsString(id), JsString(projectId), JsString(name)) =>
          Project(id, projectId, name)
        case _ => throw new DeserializationException("User")
      }

    override def write(project: Project): JsValue = JsObject(
      "id" -> JsString(project.id),
      "name" -> JsString(project.projectId),
      "email" -> JsString(project.name)
    )
  }
}
