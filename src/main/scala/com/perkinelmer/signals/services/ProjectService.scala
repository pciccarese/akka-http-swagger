package com.perkinelmer.signals.services

import scala.concurrent.{ExecutionContext, Future}

class ProjectService() {

	def getInfo(): String = {
    	return "Hello project";
  	}
}