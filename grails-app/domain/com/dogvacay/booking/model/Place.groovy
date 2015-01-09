package com.dogvacay.booking.model


import groovy.transform.ToString;

import java.util.Date;
import groovy.transform.ToString

@ToString
class Place {
	public static final String HAS_CAT = "cat"
	public static final String HAS_RODENT = "rodent"
	public static final String HAS_BIRD = "bird"

	static constraints = {
	}

	static mapping = {
		table 'places'
		version false
		fullAddress type: 'text'
		description type: 'text'
		additionalInstructions type: 'text'
		nearby type: 'text'
		sleepPlace type: 'text'
		toys type: 'text'
		availability type: 'text'
		otherPets type: 'text'
		calendarOther type: 'text'
		houseRulesOther type: 'text'
		host column: 'id_user'
		hasCats nullable: true
		hasRabbitsRodents nullable: true
		hasBirdsReptiles nullable: true
	}

	static hasOne = [placeTerms:PlaceTerms]

	DVUser host
	int id
	String fullAddress
	String city
	String state
	String additionalInstructions
	String title
	String description
	String propertyType
	//String bedrooms
	String yard
	String nearby
	String dogCareExperience
	String petResponsible
	String sleepPlace
	String toys
	String ll
	double lat
	double lng
	String availability
	int completeness
	String cDetails
	String approved
	Date almostApprovedAt
	String zip
	String country
	boolean proHost
	String specialty1
	String specialty2
	String specialty3
	Date created
	boolean reminded
	Date modified
	String otherPets
	String calendar
	String calendarOther
	String houseRule
	String houseRulesOther
	String kids
	String lastMinuteOkay
	int dogCount
	Boolean conversionRateOverride
	Boolean repeatRateOverride
	Boolean hasCats
	Boolean hasRabbitsRodents
	Boolean hasBirdsReptiles

	def getProblematicHostPets() {
		def set = [] as Set<String>
				hasCats ? set.add(HAS_CAT) : ""
		hasBirdsReptiles ? set.add(HAS_BIRD)  : ""
		hasRabbitsRodents ? set.add(HAS_RODENT) : ""
		set
	}
}
