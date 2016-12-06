package com.perkinelmer.signals.dataset.actors

import akka.actor.Actor
import com.perkinelmer.signals.dataset.DatasetBsonProtocol
import com.perkinelmer.signals.dataset.model.Dataset

class SaveDatasetActor extends Actor {

  def receive = {
    case dataset: Dataset =>
      println("hello back at you")
      var p = DatasetBsonProtocol
      p.saveDataset(dataset)
    case _       => println("huh?")
  }
}
