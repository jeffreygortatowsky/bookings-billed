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

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

/**
* Entity corresponding to the "dogvacay.reservation_dog_counts" table.
* Uses a composite PK, which is a composite of all attributes.
*
* @author jtafralian
*/
@Data
@Entity
@Immutable
@Table(name = "reservation_dog_counts")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="com.dogvacay.search.reservation.model.ReservationDogCount")
public class ReservationDogCount 
        implements Serializable {

    private static final long serialVersionUID = -1423604333409973570L;
    
    @EmbeddedId
    private ReservationDogCountId id;
    
    public ReservationDogCount()  {}
    public ReservationDogCount(ReservationDogCountId id)  {
        this.id = id;
    }
    

}