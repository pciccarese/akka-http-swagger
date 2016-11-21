package com.perkinelmer.signals.dataset

import java.util.Calendar

import io.swagger.annotations._
import spray.json.DefaultJsonProtocol

import scala.annotation.meta.field

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val personFormat = jsonFormat3(Dataset)
}

case class Dataset(
     @(ApiModelProperty @field) (position=1, value="id") id: String,
     @(ApiModelProperty @field) (position=2, value="datasetId") datasetId: String,
     @(ApiModelProperty @field) (position=3, value="name") name: String) {

  var status = "created";
  var createdOn = Calendar.getInstance().getTime();
  var updatedOn = Calendar.getInstance().getTime();

  var attributes:Map[String, AnyVal] = Map();

  def setAttribute(): Unit = {

  }
}
