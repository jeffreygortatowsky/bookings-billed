package com.dogvacay.booking.model

class Pet {

    static constraints = {
    }
    static mapping = {
        table 'pets'
        version false
        user column: 'id_user',  insertable: false, updateable: false

    }

    DVUser user;
    int id;
}
