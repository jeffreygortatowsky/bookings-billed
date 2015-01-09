package bookings.billed

import com.dogvacay.booking.model.Booking
import com.dogvacay.booking.model.DVUser
import com.dogvacay.booking.model.User

class BookingsBilledController {

    def index() {
        log.debug(DVUser.findById(130))
    }
}
