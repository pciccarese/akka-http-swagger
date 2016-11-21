package com.perkinelmer.signals.dataset

import java.util.Calendar

class Dataset(var descriptorId: String, var datasetId: String, var name: String) {

  var status = "created";
  var createdOn = Calendar.getInstance().getTime();
  var updatedOn = Calendar.getInstance().getTime();

  var attributes:Map[String, AnyVal] = Map();

  def setAttribute(): Unit = {

  }
}
