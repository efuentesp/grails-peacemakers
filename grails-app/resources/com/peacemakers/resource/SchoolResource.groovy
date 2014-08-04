package com.peacemakers.resource

import static org.grails.jaxrs.response.Responses.*

import org.grails.jaxrs.provider.DomainObjectNotFoundException

import com.peacemakers.domain.School

import javax.ws.rs.GET
import javax.ws.rs.PUT
import javax.ws.rs.DELETE
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SchoolResource {

  def schoolResourceService
  def id

  @GET
  Response read() {
  	def schools = schoolResourceService.read()
    ok schools
  }

  @PUT
  Response update(School dto) {
    dto.id = id
    ok schoolResourceService.update(dto)
  }

  @DELETE
  void delete() {
    schoolResourceService.delete(id)
  }

}