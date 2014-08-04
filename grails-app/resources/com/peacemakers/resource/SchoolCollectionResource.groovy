package com.peacemakers.resource

import static org.grails.jaxrs.response.Responses.*

import com.peacemakers.domain.School

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType

@Path('/api/schools')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SchoolCollectionResource {

	def schoolResourceService

	@GET
  Response readAll() {
  	def schools = schoolResourceService.readAll()
    ok schools
  }

  @Path('/{id}')
  SchoolResource getResource(@PathParam('id') Long id) {
    new SchoolResource(schoolResourceService: schoolResourceService, id: id)
  }

  @POST
  Response create(School dto) {
    created schoolResourceService.create(dto)
  }
}