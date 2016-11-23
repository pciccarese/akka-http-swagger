package com.perkinelmer.signals.dataset

import spray.json.DefaultJsonProtocol

object DatasetJsonProtocol extends DefaultJsonProtocol {
  implicit val datasetFormat = jsonFormat3(Dataset)
}