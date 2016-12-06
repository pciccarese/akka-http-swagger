package com.perkinelmer.signals.dataset

import com.perkinelmer.signals.dataset.model.Dataset
import spray.json.DefaultJsonProtocol

object DatasetJsonProtocol extends DefaultJsonProtocol {
  implicit val datasetFormat = jsonFormat3(Dataset)
}