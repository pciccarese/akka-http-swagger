package com.perkinelmer.signals.dataset

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import io.swagger.annotations.ApiModel
import io.swagger.util.Json

import scala.concurrent.Future

/**
  * Created by paolociccarese on 11/21/16.
  */
@ApiModel("Dataset")
class DatasetService  {

  def getDataset(descriptorId: String): Dataset = {
    return Dataset("x.1", "x", "mock dataset")
  }

}
