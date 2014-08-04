package com.peacemakers.service

import org.grails.jaxrs.provider.DomainObjectNotFoundException

import com.peacemakers.domain.School

class SchoolResourceService {

	def readAll() {
		School.findAll()
	}

  def read(id) {
    def obj = School.get(id)
    if (!obj) {
      throw new DomainObjectNotFoundException(School.class, id)
    }
    obj
  }

}