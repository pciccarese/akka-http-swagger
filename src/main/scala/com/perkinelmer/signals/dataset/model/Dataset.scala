package com.perkinelmer.signals.dataset.model

import io.swagger.annotations._

import scala.annotation.meta.field

final case class Dataset(
     @(ApiModelProperty @field) (position=1, value="id") id: String,
     @(ApiModelProperty @field) (position=2, value="datasetId") datasetId: String,
     @(ApiModelProperty @field) (position=3, value="name") name: String) {
}

