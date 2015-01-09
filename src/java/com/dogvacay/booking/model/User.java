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


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Represents all the relevant "user" data when dealing with users who are Hosts.  
 *
 * This entity maps to 'dogvacay.users', with one-to-one relationships (joins) to 
 * places and one-to-many relationship with reservations. 
 * 
 * 
 * @author jtafralian
 */
@Entity
@Getter
@EqualsAndHashCode
@ToString
@Immutable
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="com.dogvacay.booking.model.User")
public class User implements Serializable {

	private static final long serialVersionUID = -3469609487246091835L;

	@Id
    @GeneratedValue
    private Integer id;
   
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "email", nullable = false)
	private String email;
	
	// yes, this is misspelled in the database
	@Column(name = "intrested_in")
    private String interestedIn;

	@Column(name = "last_name")
    private String lastName;

	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_user", unique=true)
	private Place place;
	
    @OneToMany
    @JoinColumn(name="guest", insertable=false, updatable=false, referencedColumnName="id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Booking> reservations;
	
}