package com.dogvacay.booking.model

class BookingRequest {

    static mapping = {
        version(false)
        booking column: 'parent_booking_request_id'
    }
    static constraints = {
    }
    int id
    Booking booking
}
