package com.perkinelmer.signals.project

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

trait ProjectApi {

	lazy val projectService: ProjectService = new ProjectService;

	def projectsRoutes: Route = pathPrefix("project") {
		pathEnd {
			get {
				complete {
					projectService.getInfo();
				}
			}
		}
	}
}