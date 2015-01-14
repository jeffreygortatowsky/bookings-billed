package com.dogvacay.booking.model

import groovy.transform.ToString

@ToString
class DVUser {
    static mapping = {
        table 'users'
        version false
        active type: 'boolean'
        permissions type: 'text'
        userNotes lazy: false
        preferences column: 'user_id'
        profile column: 'id_user'
        recommended scale:5, class: BigDecimal
        hostPayout sqlType: 'decimal'
        recommendedResponsive  sqlType:'tinyint'
    }

    static constraints = {
    }
    int id
    String firstName
    String lastName
    String intrestedIn
    Boolean active
    String email
    Date created
    Date lastLogin
    String password
    String permissions
    Boolean showInSearchResults
    BigDecimal recommended
    BigDecimal hostPayout
    Integer recommendedResponsive
    static hasOne = [place:com.dogvacay.booking.model.Place, services:Services]
//    static hasMany = [userNotes:UserNote, preferences:Preference, pets:Pet]
}
