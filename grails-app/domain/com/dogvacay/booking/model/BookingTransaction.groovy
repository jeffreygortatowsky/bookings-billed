package com.dogvacay.booking.model

import groovy.transform.ToString

@ToString
class BookingTransaction {
    static mapping = {
        version false
        table 'reservation_transaction'
        booking column: 'reservation_id'
        description sqlType: 'text'
        notes sqlType: 'text'
        isOnetime sqlType: 'bit'
        isDeleted sqlType: 'bit'
        isArchived sqlType: 'bit'
    }

    static constraints = {
        paymentProfileId nullable: true
        result nullable: true
        responseText nullable: true
        authCode nullable: true
        transactionId nullable: true
        parentTransactionId nullable: true
        description nullable: true
        amountPaidout nullable: true
        transactionFees nullable: true
        notes nullable: true
    }

    Integer id
    Booking booking
    String paymentProfileId
    String transactionType
    String result
    String responseText
    String authCode
    String transactionId
    String parentTransactionId
    String description
    BigDecimal amountBilled
    BigDecimal amountPaidout
    BigDecimal transactionFees
    String notes
    String source
    Boolean isOnetime
    Date createdOn
    Boolean isDeleted
    Boolean isArchived
    static fetchMode = [booking : 'eager']
}
