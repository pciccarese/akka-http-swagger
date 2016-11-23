package com.perkinelmer.signals.mongodb

import com.mongodb.casbah.MongoClient

object MongoFactory {
  private val SERVER = "localhost"
  private val PORT   = 27017
  private val DATABASE = "signals"
  private val COLLECTION = "entities"
  val connection = MongoClient(SERVER)
  val collection = connection(DATABASE)(COLLECTION)
}