/*
* This software is the confidential and proprietary information of
* dogvacay.com and may not be used, reproduced, modified, distributed,
* publicly displayed or otherwise disclosed without the express written
* consent of dogvacay.com.
*
* This software is a work of authorship by dogvacay.com and protected by
* the copyright laws of the United States and foreign jurisdictions.
*
* Copyright 2014 dogvacay.com, Inc. All rights reserved.
*
*/
package com.dogvacay.booking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
* A composite PK used by ReservationDogCount
*
* @author jtafralian
*/
@Data
@EqualsAndHashCode(exclude = {"booking"})
@ToString(exclude = {"booking"})
@Embeddable
public class ReservationDogCountId 
        implements Serializable {

    private static final long serialVersionUID = -4535971883722954972L;

    @Column(name = "dog_count", nullable = false)
    private Integer dogCount;

    @Column(columnDefinition = "int", name = "reservation_date", nullable = false)
    private Long reservationDate;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="reservation_id", nullable = false)
    private Booking booking;

    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    public static class Builder  {
        
        private Booking booking;
        private Integer dogCount;
        private Long reservationDate;
        private Integer userId;
        
        public Builder booking(Booking booking)  {
            this.booking = booking;
            return this;
        }

        public Builder dogCount(Integer dogCount)  {
            this.dogCount = dogCount;
            return this;
        }
               
        public Builder reservationDate(Long reservationDate)  {
            this.reservationDate = reservationDate;
            return this;
        }
        
        public Builder userId(Integer userId)  {
            this.userId = userId;
            return this;
        }
        
        public ReservationDogCountId build()  {
        	ReservationDogCountId entity = new ReservationDogCountId();
        	entity.setBooking(booking);
        	entity.setDogCount(dogCount);
        	entity.setReservationDate(reservationDate);
        	entity.setUserId(userId);
            
            return entity;
        }
        
    }
}
