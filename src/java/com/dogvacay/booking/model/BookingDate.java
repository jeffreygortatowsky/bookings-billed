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


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Entity representing records from the "dogvacay.pets" table.
 * 
 * @author jtafralian
 */
@Data
@EqualsAndHashCode(exclude = {"booking"})
@ToString(exclude = {"booking"})
@Entity
@Table(name = "reservation_service_dates")
public class BookingDate 
        implements Serializable {
    
    private static final long serialVersionUID = 2300921611603898431L;

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="reservation_id", nullable = false)
    private Booking booking;

    @Column(name = "start", nullable = false)
    private Date start;
    
    @Column(name="end", nullable = false)
    private Date end;
    
    @Column(name = "service", nullable = false)
    private String service;
    
    @Column(name = "rate")
    private float rate; 
    
    public static class Builder  {
        
        private Integer id;
        private Booking booking;
        private Date end;
        private float rate;
        private String service;
        private Date start;
        
        public Builder id(Integer id)  {
            this.id = id;
            return this;
        }

        public Builder booking(Booking booking)  {
            this.booking = booking;
            return this;
        }
               
        public Builder end(Date end)  {
            this.end = end;
            return this;
        }
        
        public Builder rate(float rate)  {
            this.rate = rate;
            return this;
        }
        
        public Builder service(String service)  {
            this.service = service;
            return this;
        }
        
        public Builder start(Date start)  {
            this.start = start;
            return this;
        }
        
        public BookingDate build()  {
        	BookingDate entity = new BookingDate();
        	entity.setBooking(booking);
        	entity.setEnd(end);
        	entity.setId(id);
        	entity.setRate(rate);;
        	entity.setService(service);
        	entity.setStart(start);
            
            return entity;
        }
        
    }
   
}