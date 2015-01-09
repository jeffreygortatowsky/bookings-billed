package com.dogvacay.booking.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class BookingDate {

    static mapping = {
        table 'reservation_service_dates'
        version false
        booking column: 'reservation_id',  insertable: false, updateable: false
    }

    static constraints = {
        start nullable: false
        end nullable: false
        service nullable: false
        rate nullable: false
    }

    Integer id;
    Booking booking;
    Date start;
    Date end;
    String service;
    BigDecimal rate;
}
