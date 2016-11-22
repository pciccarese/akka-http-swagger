package com.perkinelmer.signals.project

import java.util.{Calendar, Date}

import spray.json.{DefaultJsonProtocol, DeserializationException, JsObject, JsString, JsValue, RootJsonFormat}

class Project(idc: String, projectIdc: String, namec: String) {
  var id: String = idc;
  var projectId: String = projectIdc;
  var name: String = namec;

  var createdOn : Date = Calendar.getInstance().getTime()
}

object ProjectJsonProtocol extends DefaultJsonProtocol {

  implicit val projectFormat: RootJsonFormat[Project] = new RootJsonFormat[Project] {
    override def read(json: JsValue): Project =
      json.asJsObject.getFields("id", "projectId", "name") match {
        case Seq(JsString(id), JsString(projectId), JsString(name)) =>
          new Project(id, projectId, name)
        case _ => throw new DeserializationException("User")
      }

    override def write(project: Project): JsValue = JsObject(
      "id" -> JsString(project.id),
      "name" -> JsString(project.projectId),
      "email" -> JsString(project.name),
      "createdOn" -> JsString(project.createdOn.toString)
    )
  }
}
