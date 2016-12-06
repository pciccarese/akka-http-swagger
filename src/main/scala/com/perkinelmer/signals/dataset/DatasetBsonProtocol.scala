package com.perkinelmer.signals.dataset

import com.mongodb.casbah.Imports._
import com.perkinelmer.signals.dataset.model.Dataset
import com.perkinelmer.signals.mongodb.MongoFactory

object DatasetBsonProtocol {
  /**
    * Convert a Dataset object into a BSON format that MongoDb can store.
    */
  def buildMongoDbObject(dataset: Dataset): MongoDBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "id" -> dataset.id
    builder += "datasetId" -> dataset.datasetId
    builder += "name" -> dataset.name
    builder.result
  }

  def saveDataset(dataset: Dataset) {
    val mongoObj = buildMongoDbObject(dataset)
    MongoFactory.collection.save(mongoObj)
  }

  def getDataset(id: String): Any = {
    val mongoColl = MongoFactory.collection
    val q = MongoDBObject("id" -> id)
    val dataset = mongoColl.findOne(q)
    return dataset
  }
}