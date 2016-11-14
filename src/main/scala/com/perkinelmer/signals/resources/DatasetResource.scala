package com.perkinelmer.signals.resources

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

import io.swagger.annotations._	

import javax.ws.rs.Path

import com.perkinelmer.signals.services.DatasetService

@Path("/datasets")  // @Path annotation required for Swagger
@Api(value = "/datasets", description = "Operations about datasets")
trait DatasetResource {

	val datasetService: DatasetService = new DatasetService();

	def datasetsRoutes: Route = pathPrefix("datasets") {
		getDatasetInfo
	}

	@ApiOperation(value = "Get dataset info", nickname = "getDatasetInfo", httpMethod = "GET",
    	response = classOf[String], produces = "text/plain")
  	@ApiResponses(Array(
  		new ApiResponse(code = 200, message = "Return Info", response = classOf[String]),
    	new ApiResponse(code = 500, message = "Internal error")
  	))
	def getDatasetInfo = get {
		  complete {
	          		datasetService.getInfo();
	        
	    }
	}
}