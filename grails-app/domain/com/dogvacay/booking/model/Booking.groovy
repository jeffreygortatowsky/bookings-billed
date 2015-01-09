package com.dogvacay.booking.model

import groovy.transform.ToString

@ToString
class Booking {
    static constraints = {
    }

    static mapping = {
        table 'reservations'
        version false
        host column: 'host'
        guest column: 'guest'
        meet1At column: 'meet1_at'
        meet2At column: 'meet2_at'
        notes type: 'text'
        declineReason sqlType: 'tinyint'
        bookingRequest column: 'booking_request_id'
        service sqlType:'enum'
        status sqlType:'enum'
    }

    DVUser host
    DVUser guest
    int id
    Date createdAt
    Date updatedAt
    String type
    String service
    int dogs
    Date startAt
    Date endAt
    Date meet1At
    Date meet2At
    BigDecimal subtotalAmount
    BigDecimal chargeAmount
    BigDecimal hostAmount
    BigDecimal guestFees
    BigDecimal hostFees
    String status
    String notes
    String source
    int declineReason
    String cancelledBy
    Date cancelledOn
    static hasOne = [bookingRequest: BookingRequest]


}
