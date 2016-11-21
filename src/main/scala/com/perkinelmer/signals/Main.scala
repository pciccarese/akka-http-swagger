package com.perkinelmer.signals

import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.perkinelmer.signals.dataset.DatasetApi
import com.perkinelmer.signals.project.ProjectApi
import com.perkinelmer.signals.swagger.SwaggerDocService

object API extends Resources with CorsSupport {
    def main(args: Array[String]) {
    	  implicit val actorSystem = ActorSystem()
        implicit val actorMaterializer = ActorMaterializer();

        val routes: Route = datasetsRoutes ~ projectsRoutes ~ 
          corsHandler(new SwaggerDocService(actorSystem).routes) ~ 
          get {
            pathPrefix("swagger") { pathEndOrSingleSlash {
                getFromResource("swagger-ui/index.html")
              }
            } ~
            getFromResourceDirectory("swagger-ui")
          };

        Http().bindAndHandle(routes,"localhost",8080)

        println("server started at 8080")
    }
}

trait Resources extends DatasetApi with ProjectApi