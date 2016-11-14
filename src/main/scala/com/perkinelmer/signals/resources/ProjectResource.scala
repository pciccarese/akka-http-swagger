package com.perkinelmer.signals.resources

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

import com.perkinelmer.signals.services.ProjectService

trait ProjectResource {

	val projectService: ProjectService = new ProjectService();

	def projectsRoutes: Route = pathPrefix("projects") {
		pathEnd {
	        get {
	          	complete {
	            	projectService.getInfo();
	          	}
	        }
	    }
	}
}