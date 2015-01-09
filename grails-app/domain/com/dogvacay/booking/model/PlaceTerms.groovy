package com.dogvacay.booking.model

import groovy.transform.ToString

@ToString
class PlaceTerms {

    static constraints = {
    }

    static mapping = {
        version false
        place column: 'id_place',  insertable: false, updateable: false
    }

    Place place
    int id
    int idPlace
    BigDecimal nigthlyRates
    String cancellationPolicy
    int idUser
}
