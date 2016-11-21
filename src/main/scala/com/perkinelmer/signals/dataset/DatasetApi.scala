package com.perkinelmer.signals.dataset

import javax.ws.rs.Path

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import io.swagger.annotations._

@Path("/dataset")
@Api(value = "/dataset")
trait DatasetApi {

	lazy val datasetService: DatasetService = new DatasetService;

	def datasetsRoutes: Route = pathPrefix("dataset") {
		getDataset
	}

	@ApiOperation(value = "Get dataset", nickname = "getDataset", httpMethod = "GET", response = classOf[String], produces = "application/json, text/plain")
	@ApiImplicitParams(Array(
		new ApiImplicitParam(name = "descriptorId", required = false, dataType = "string", paramType = "path", value = "Identifier of dataset that needs to be fetched"),
		new ApiImplicitParam(name = "format", required = false, dataType = "string", paramType = "query", value = "Format of response")
	))
	@ApiResponses(Array(
		new ApiResponse(code = 200, message = "Return dataset", response = classOf[String]),
		new ApiResponse(code = 400, message = "Invalid descriptorId supplied"),
		new ApiResponse(code = 404, message = "Dataset not found"),
		new ApiResponse(code = 500, message = "Internal error")
	))
	def getDataset = get {
		pathEnd {
			parameters("descriptorId".as[String].?, "format".as[String].?) { (descriptorId, format) =>
				complete {
					datasetService.getDataset(descriptorId.getOrElse(""), format.getOrElse(""));
				}
			}
		} ~
		path( Segment ) { petId =>
			parameters("descriptorId".as[String].?, "format".as[String].?) { (descriptorId, format) =>
				complete {
					datasetService.getDataset(petId, format.getOrElse(""));
				}
			}
		}
	}
}