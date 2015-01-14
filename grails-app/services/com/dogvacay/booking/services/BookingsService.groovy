package com.dogvacay.booking.services

import com.dogvacay.booking.model.Booking
import grails.transaction.Transactional

@Transactional
class BookingsService {
    List<Booking> getBookingsByView(Integer id, String service, String status) {
        List<Booking> list
        service = service.toLowerCase().equals("boarding") ? null : service
        log.debug("Finding by id (${id}) service (${service}), status (${status})")
        list = Booking.findAllByIdAndServiceAndStatus(id, service, status)
        log.debug("Log ${list.size()}\n${list}")
        return list
    }
}
