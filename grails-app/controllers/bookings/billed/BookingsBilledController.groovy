package bookings.billed

import com.dogvacay.booking.utils.BookingConversionUtils
import com.dogvacay.booking.utils.ServiceUtils
import grails.converters.JSON
import org.apache.commons.lang.math.NumberUtils

class BookingsBilledController {
def bookingsService
    def index() {

    }

    def bookings() {
        def valid = validate(params)
        if(valid["error"]) {
            render "Error ${valid['msg']}"
            return
        }

        Integer anId = NumberUtils.toInt(params.id, 0)
        String service = params?.service
        String status = params.status
        log.debug("Getting data for bookings view ${status}")

        List results = bookingsService.getBookingsByView(anId, service, status)
        log.debug("Got back ${results.size()} results for id (${params.id}) service (${service}) status (${status})")
        results = BookingConversionUtils.covertBookingsToBookingsTransactionView(results)
        log.debug("Converted output is ${results}")
        JSON.use('deep')
        response.contentType = "application/json"
        render results as JSON
    }

    def validate(def params) {
        boolean error = false
        List<String> msg = []

        if (!params.id || !NumberUtils.isDigits(params.id)) {
            error = true;
            msg << "Missing or invalid ID"
        }

        if(!ServiceUtils.isValidService(params?.service)) {
            error = true
            msg << "Service ${params.service} is not recognized"
        }

        if (!params.status) {
            error = true;
            msg << "Missing param status"
        }

        return ["error": error, "msg": msg.join("\n")]
    }
}
