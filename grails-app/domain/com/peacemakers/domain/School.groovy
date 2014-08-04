package com.peacemakers.domain

class School {

	String name

	static constraints = {
		name {blank: false}
	}
}
