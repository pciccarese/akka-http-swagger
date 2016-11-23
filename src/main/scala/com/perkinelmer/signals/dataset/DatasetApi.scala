package com.perkinelmer.signals.dataset

import javax.ws.rs.Path

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import io.swagger.annotations._
import spray.json.DefaultJsonProtocol._

@Path("/dataset")
@Api(value = "/dataset")
trait DatasetApi extends SprayJsonSupport {

	lazy val datasetService: DatasetService = new DatasetService;

	def datasetsRoutes: Route = pathPrefix("dataset") {
		getDataset ~ postDataset ~ deleteDataset
	}


  import com.perkinelmer.signals.dataset.DatasetJsonProtocol._

	@ApiOperation(value = "Get dataset", nickname = "getDataset", httpMethod = "GET", response = classOf[Dataset], produces = "application/json")
	@ApiImplicitParams(Array(
		new ApiImplicitParam(name = "id", required = false, dataType = "string", paramType = "path", value = "Identifier of dataset that needs to be fetched"),
		new ApiImplicitParam(name = "format", required = false, dataType = "string", paramType = "query", value = "Format of response")
	))
	@ApiResponses(Array(
		new ApiResponse(code = 200, message = "Return dataset", response = classOf[Dataset]),
		new ApiResponse(code = 400, message = "Invalid id supplied"),
		new ApiResponse(code = 404, message = "Dataset not found"),
		new ApiResponse(code = 500, message = "Internal error")
	))
	def getDataset = get {
		pathEnd {
			parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
				complete {
					datasetService.getDataset(id.getOrElse(""));
				}
			}
		} ~
		path( Segment ) { descriptorId =>
			parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
				complete {
					datasetService.getDataset(descriptorId);
				}
			}
		}
	}

	@ApiOperation(value = "Post dataset", nickname = "postDataset", httpMethod = "POST", response = classOf[Dataset], produces = "application/json")
	@ApiImplicitParams(Array(
		new ApiImplicitParam(name = "id", required = false, dataType = "string", paramType = "path", value = "Identifier of dataset that needs to be fetched"),
		new ApiImplicitParam(name = "format", required = false, dataType = "string", paramType = "query", value = "Format of response")
	))
	@ApiResponses(Array(
		new ApiResponse(code = 200, message = "Return dataset", response = classOf[Dataset]),
		new ApiResponse(code = 400, message = "Invalid id supplied"),
		new ApiResponse(code = 404, message = "Dataset not found"),
		new ApiResponse(code = 500, message = "Internal error")
	))
	def postDataset = post {
		pathEnd {
			parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
				complete {
					datasetService.getDataset(id.getOrElse(""));
				}
			}
		} ~
			path( Segment ) { descriptorId =>
				parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
					complete {
						datasetService.getDataset(descriptorId);
					}
				}
			}
	}

	@ApiOperation(value = "Delete dataset", nickname = "deleteDataset", httpMethod = "DELETE", response = classOf[Dataset], produces = "application/json")
	@ApiImplicitParams(Array(
		new ApiImplicitParam(name = "id", required = true, dataType = "string", paramType = "path", value = "Identifier of dataset that needs to be fetched"),
		new ApiImplicitParam(name = "format", required = false, dataType = "string", paramType = "query", value = "Format of response")
	))
	@ApiResponses(Array(
		new ApiResponse(code = 200, message = "Return deleted dataset", response = classOf[Dataset]),
		new ApiResponse(code = 400, message = "Invalid id supplied"),
		new ApiResponse(code = 404, message = "Dataset not found"),
		new ApiResponse(code = 500, message = "Internal error")
	))
	def deleteDataset = delete {
			path( Segment ) { descriptorId =>
				parameters("id".as[String].?, "format".as[String].?) { (id, format) =>
					complete {
						datasetService.getDataset(descriptorId);
					}
				}
			}
	}
}