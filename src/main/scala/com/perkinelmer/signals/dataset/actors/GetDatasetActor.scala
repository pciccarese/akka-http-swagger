package com.perkinelmer.signals.dataset.actors

import akka.actor.Actor
import com.perkinelmer.signals.dataset.DatasetBsonProtocol

/**
  * Created by paolociccarese on 11/29/16.
  */
class GetDatasetActor extends Actor {

  def receive = {
    case id: String =>
      println("hello back at you")
      var p = DatasetBsonProtocol
      println("DATASET: " + p.getDataset("x.1"))
    case _       => println("huh?")
  }
}
