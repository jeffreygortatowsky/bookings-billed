package com.dogvacay.booking.utils

import com.dogvacay.booking.model.Booking
import com.dogvacay.booking.model.BookingTransaction
import com.dogvacay.booking.model.DVUser
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

/**
 * Created by jeffreygortatowsky on 1/13/15.
 */
class BookingConversionUtils {
    static Logger log = Logger.getLogger(BookingConversionUtils.class)
    static Set<String> guestBookingTransactionTypes = ["refund", "capture", "authorize"] as Set
    static Set<String> hostBookingTransactionTypes = ["payout"] as Set

    static List<Map<String, String>> covertBookingsToBookingsTransactionView(List<Booking> bookings) {
        List list = bookings.collect { booking ->
            Map<String, String> map = [:]
            map["id"] = booking.id
            map["type"] = booking.type
            map["startAt"] = booking.startAt
            map["endAt"] = booking.endAt
            map["status"] = booking.status
            map["service"] = booking.service
            map["subtotalAmount"] = booking.subtotalAmount
            map["guest"] = convertUserToMap(booking.guest)
            map["guestPayment"] = booking?.guestFees ?: 0
            String[] statusAndNote = getTransactionStatus(booking, guestBookingTransactionTypes)
            map["guestPaymentStatus"] = statusAndNote[0]
            map["guestNotes"] = statusAndNote[1]
            map["host"] = convertUserToMap(booking.host)
            statusAndNote = getTransactionStatus(booking, hostBookingTransactionTypes)
            map["hostPaymentStatus"] = statusAndNote[0]
            map["hostNotes"] = statusAndNote[1]
            map["hostPercentage"] = booking.host.hostPayout
            map["hostPaid"] = booking.hostFees ?: 0
            log.debug("Converted booking ${booking.id} to map ${map}")
            return map
        }
        log.debug("Returning a list with ${list.size()} entries")
        return list
    }

    static String[] getTransactionStatus(Booking booking, Set<String> validTransactionTypes) {
        String result = ""
        String note = ""

        log.debug("Started with a list of ${booking.bookingTransactions.size()} entries")
        if (booking?.bookingTransactions && booking.bookingTransactions.size() > 0) {
            Set bks = booking.bookingTransactions.findAll { bookingTransaction ->
                validTransactionTypes.contains(bookingTransaction.transactionType)
            }

            log.debug("After filtering the size of the list is ${bks.size()} entries")
            List bookingTransactionsList = sortBookingTransactions(bks)
            BookingTransaction bookingTransaction = bookingTransactionsList.get(0)
            result = "${StringUtils.capitalize(bookingTransaction.transactionType)} - ${StringUtils.capitalize(bookingTransaction.result)}"
            note = bookingTransaction.notes
        }
        return [result, note]
    }

    static List<BookingTransaction> sortBookingTransactions(Set<BookingTransaction> bookingTransactionSet) {
        List<BookingTransaction> result = bookingTransactionSet.sort { b1, b2 ->
            b1.id < b2.id ? 1 : -1
        }
        result.each { log.debug("Sorted results ${it.id} - ${it.createdOn}") }
        return result
    }

    static Map<String, String> convertUserToMap(DVUser user) {
        Map<String, String> map = [:]
        map["id"] = user.id
        map["firstName"] = StringUtils.capitalize(user.firstName)
        map["lastName"] = StringUtils.capitalize(user.lastName)
        return map
    }
}
