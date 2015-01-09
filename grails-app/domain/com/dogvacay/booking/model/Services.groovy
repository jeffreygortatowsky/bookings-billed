package com.dogvacay.booking.model

import org.springframework.util.StringUtils

class Services {
    static mapping = {
        table 'services'
        version false
    }

    static constraints = {
    }

    DVUser user
    int id
    String boarding
    String sitting
    String walking
    String training
    String checkups
    String taxiService
    String bathing
    String care
    String grooming
    BigDecimal sittingRate
    BigDecimal walkingRate
    BigDecimal trainingRate
    BigDecimal taxiRate
    BigDecimal bathingRate
    BigDecimal checkupsRate
    BigDecimal groomingRateMax
    BigDecimal careRate


    def hostProvidedServicesAndFeesMap() {
        def map = [:]
        if(!StringUtils.isEmpty(walking) && walking.equals("1"))
            map["walking"] = walkingRate
        if(!StringUtils.isEmpty(sitting) && sitting.equals("1"))
            map["sitting"] = sittingRate
        if(!StringUtils.isEmpty(training) && training.equals("1"))
            map["training"] = trainingRate
        if(!StringUtils.isEmpty(taxiService) && taxiService.equals("1"))
            map["taxi"] = taxiRate
        if(!StringUtils.isEmpty(bathing) && bathing.equals("1"))
            map["bathing"] = bathingRate
        if(!StringUtils.isEmpty(checkups) && checkups.equals("1"))
            map["checkups"] = checkupsRate
        if(!StringUtils.isEmpty(care) && care.equals("1"))
            map["care"] = careRate
        if(!StringUtils.isEmpty(grooming) && grooming.equals("1"))
            map["grooming"] = groomingRateMax
        if(!StringUtils.isEmpty(boarding) && boarding.equals("1"))
            map["boarding"] = 0.0 // nithglyrate is elsewhere
        map
    }
}
