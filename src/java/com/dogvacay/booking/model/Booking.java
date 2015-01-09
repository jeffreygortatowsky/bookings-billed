/*
 * This software is the confidential and proprietary information of
 * dogvacay.com and may not be used, reproduced, modified, distributed,
 * publicly displayed or otherwise disclosed without the express written
 * consent of dogvacay.com.
 *
 * This software is a work of authorship by dogvacay.com and protected by
 * the copyright laws of the United States and foreign jurisdictions.
 *
 * Copyright 2013 dogvacay.com, Inc. All rights reserved.
 *
 */
package com.dogvacay.booking.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a partially mutable record from "dogvacay.reservations" table.
 * 
 * @author jtafralian
 */
@Data
@EqualsAndHashCode(exclude = {"pets", "reviews"})
@Entity
@Table(name = "reservations")
public class Booking 
	implements Serializable {

	private static final long serialVersionUID = -7597330243064288198L;

	@Id
    @GeneratedValue
    private Integer id;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="booking")
    private Set<BookingDate> serviceDates;

    @Column(name="booking_request_id")
    private Integer bookingRequestId;

    @Column(columnDefinition = "decimal", name = "charge_amount")
    private Float chargeAmount;
	
	@Column(name = "created_at")
	private Date created;

    @Column(columnDefinition = "tinyint", name = "decline_reason")
    private Integer declinedReason;

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="id.booking")
    @OrderBy(clause = "reservation_date ASC")
    private Set<ReservationDogCount> dogCounts; 
	
	@Column(name = "end_at")
	private Date end;
	
	@Column(name = "guest")
	private Integer guest;

    @Column(columnDefinition = "decimal", name = "guest_fees")
    private Float guestFees;

	@Column(name = "host")
	private Integer host;

    @Column(columnDefinition = "decimal", name = "host_fees")
    private Float hostFees;

    @Column(columnDefinition = "decimal", name = "host_amount")
    private Float hostPayoutAmount;

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="thread_id")
    private MessageThread messageThread;

	@Column(name = "payment_gateway_method_id")
	private Integer paymentInfoId; //TODO NEED FROM TRAPS
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 200)
    @JoinColumn(name = "reservation_id")
    private Set<Review> reviews;
	
	@Column(name = "payment_profile_id")
	private String paymentProfileId = StringUtils.EMPTY; //Yes, this is a non-null field that we always insert empty string into

    @Column(name="dogs")
    private Integer petCount;

    @ElementCollection(targetClass=Pet.class)
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
	@JoinTable(name = "reservation_pets", 
	                  joinColumns = {@JoinColumn(name = "reservation_id") }, 
	                  inverseJoinColumns = {@JoinColumn(name = "pet_id") })
    private Set<Pet> pets;

    @Column(columnDefinition = "enum", name = "service")
    private String serviceType;
	
    @Column(name = "source")
    private String source;
    
	@Column(name = "start_at")
	private Date start;

    @Column(columnDefinition = "enum", name = "status", nullable = false)
    private String status;

    @Column(columnDefinition = "decimal", name = "subtotal_amount")
    private Float subtotalAmount;

	@Column(name = "type")
	private String type;
	
	@Column(name = "updated_at")
	private Date updated;
	
	public void addServiceDate(BookingDate serviceDate)  {
	    if(serviceDates == null)
	        serviceDates = new HashSet<>();
	        
	    serviceDates.add(serviceDate);    
	}

    public void addReservationDogCount(ReservationDogCount dogCount)  {
        if(dogCounts == null)
            dogCounts = new HashSet<>();
            
        dogCounts.add(dogCount);    
    }
    
    public void addReservationPet(Pet pet)  {
        if(pets == null)
            pets = new HashSet<>();
            
        pets.add(pet);    
    }
    
   public static class Builder  {
        
	    private Integer id;
	    private Integer bookingRequestId;
		private Float chargeAmount;
		private Date created;
	    private Set<ReservationDogCount> dogCounts; 
		private Date end;
		private Integer guest;
	    private Float guestFees;
		private Integer host;
	    private Float hostFees;
	    private Float hostPayoutAmount;
	    private MessageThread messageThread;
		private Integer paymentInfoId;
	    private Integer petCount;
	    private Set<Pet> pets;
	    private Set<BookingDate> serviceDates;
		private String serviceType;
	    private String source;
		private Date start;
		private String status;
		private Float subtotalAmount;
		private String type;
		private Date updated;
        
        public Builder id(Integer id)  {
            this.id = id;
            return this;
        }

       public Builder bookingRequestId(Integer bookingRequestId)  {
            this.bookingRequestId = bookingRequestId;
            return this;
        }
        
       public Builder chargeAmount(Float chargeAmount)  {
           this.chargeAmount = chargeAmount;
           return this;
       }
       
      public Builder created(Date created)  {
           this.created = created;
           return this;
       }
      
      public Builder dogCounts(Set<ReservationDogCount> dogCounts)  {
          this.dogCounts = dogCounts;
          return this;
      }
      public Builder end(Date end)  {
          this.end = end;
          return this;
      }
        
      public Builder guest(Integer guest)  {
            this.guest = guest;
            return this;
        }
        
      public Builder guestFees(Float guestFees)  {
          this.guestFees = guestFees;
          return this;
      }
      
      public Builder host(Integer host)  {
          this.host = host;
          return this;
      }
 
      public Builder hostFees(Float hostFees)  {
          this.hostFees = hostFees;
          return this;
      }
      
      public Builder hostPayoutAmount(Float hostPayoutAmount)  {
          this.hostPayoutAmount = hostPayoutAmount;
          return this;
      }
 
      public Builder messageThread(MessageThread messageThread)  {
          this.messageThread = messageThread;
          return this;
      }
      
      public Builder paymentInfoId(Integer paymentInfoId)  {
          this.paymentInfoId = paymentInfoId;
          return this;
      }
 
      public Builder petCount(Integer petCount)  {
            this.petCount = petCount;
            return this;
      }
           
      public Builder pets(Set<Pet> pets)  {
          this.pets = pets;
          return this;
      }
      
      public Builder serviceDates(Set<BookingDate> serviceDates)  {
          this.serviceDates = serviceDates;
          return this;
      }
        
      public Builder serviceType(String serviceType)  {
            this.serviceType = serviceType;
            return this;
      }
        
      public Builder source(String source)  {
          this.source = source;
          return this;    
      }

      public Builder start(Date start)  {
          this.start = start;
          return this;    
      }

      public Builder status(String status)  {
          this.status = status;
          return this;    
      }

      public Builder subtotalAmount(Float subtotalAmount)  {
          this.subtotalAmount = subtotalAmount;
          return this;    
      }

      public Builder type(String type)  {
          this.type = type;
          return this;    
      }
      
      public Builder updated(Date updated)  {
          this.updated = updated;
          return this;
      }
                
      public Booking build()  {
        	Booking entity = new Booking();
          	entity.setBookingRequestId(bookingRequestId);
          	entity.setChargeAmount(chargeAmount);
          	entity.setCreated(created);
          	entity.setDogCounts(dogCounts);
          	entity.setEnd(end);
          	entity.setGuest(guest);
          	entity.setGuestFees(guestFees);
          	entity.setHost(host);
          	entity.setHostFees(hostFees);
          	entity.setHostPayoutAmount(hostPayoutAmount);
          	entity.setId(id);
          	entity.setMessageThread(messageThread);
          	entity.setPaymentInfoId(paymentInfoId);
          	entity.setPetCount(petCount);
          	entity.setPets(pets);
          	entity.setServiceDates(serviceDates);
          	entity.setServiceType(serviceType);
          	entity.setSource(source);
          	entity.setStart(start);
          	entity.setStatus(status);
          	entity.setSubtotalAmount(subtotalAmount);
          	entity.setType(type);
          	entity.setUpdated(updated);
              
          	return entity;
      }
    }
	
}
