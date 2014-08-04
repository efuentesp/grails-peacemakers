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

  def create(School dto) {
    dto.save()
  }

  def update(School dto) {
    def obj = School.get(dto.id)
    if (!obj) {
      throw new DomainObjectNotFoundException(School.class, dto.id)
    }
    obj.properties = dto.properties
    obj
  }

  void delete(id) {
    def obj = School.get(id)
    if (obj) {
      obj.delete()
    }
  }

}