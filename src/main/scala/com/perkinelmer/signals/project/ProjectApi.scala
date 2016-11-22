package com.perkinelmer.signals.project

import javax.ws.rs.Path

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import io.swagger.annotations.{ApiResponse, _}

@Path("/project")
@Api(value = "/project")
trait ProjectApi extends SprayJsonSupport {

	lazy val projectService: ProjectService = new ProjectService;

	def projectsRoutes: Route = pathPrefix("project") {
		getProject
	}

	import com.perkinelmer.signals.project.ProjectJsonProtocol._

	@ApiOperation(value = "Get project", nickname = "getProject", httpMethod = "GET", response = classOf[Project], produces = "application/json, text/plain")
	@ApiImplicitParams(Array(
		new ApiImplicitParam(name = "id", required = false, dataType = "string", paramType = "path", value = "Identifier of project that needs to be fetched"),
		new ApiImplicitParam(name = "format", required = false, dataType = "string", paramType = "query", value = "Format of response")
	))
	@ApiResponses(Array(
		new ApiResponse(code = 200, message = "Return project", response = classOf[Project]),
		new ApiResponse(code = 400, message = "Invalid id supplied"),
		new ApiResponse(code = 404, message = "Project not found"),
		new ApiResponse(code = 500, message = "Internal error")
	))
	def getProject = get {
		pathEnd {
			parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
				complete {
					projectService.getProject(id.getOrElse(""));
				}
			}
		} ~
			path( Segment ) { descriptorId =>
				parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
					complete {
						projectService.getProject(descriptorId);
					}
				}
			}
	}
}