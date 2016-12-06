package com.perkinelmer.signals.dataset

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.perkinelmer.signals.dataset.actors.{GetDatasetActor, SaveDatasetActor}
import com.perkinelmer.signals.dataset.model.Dataset
import io.swagger.annotations.ApiModel
import io.swagger.util.Json

import scala.concurrent.Future

/**
  * Created by paolociccarese on 11/21/16.
  */
@ApiModel("Dataset")
class DatasetService  {

  def saveDataset(descriptorId: String): Dataset = {
    val system = ActorSystem("SignalsCluster")
    val helloActor = system.actorOf(Props[SaveDatasetActor])

    val dataset = Dataset("x.1", "x", "mock dataset")
    helloActor ! dataset
    return dataset
  }

  def getDataset(descriptorId: String): String = {
    val system = ActorSystem("SignalsCluster")
    val helloActor = system.actorOf(Props[GetDatasetActor])

    helloActor ! descriptorId
    "hello"
  }
}
