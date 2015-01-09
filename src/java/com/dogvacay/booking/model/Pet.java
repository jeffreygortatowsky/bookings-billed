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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.Immutable;

/**
 * Entity representing records from the "dogvacay.pets" table.
 * 
 * @author jtafralian
 */
@Data
@Entity
@Immutable
@Table(name = "pets")
public class Pet 
		implements Serializable {

	private static final long serialVersionUID = -7767890403857703472L;

	@Id
    @GeneratedValue
    private Integer id;
    
    @Column(name="id_user", nullable = false)
    private Integer userId;
   
	@Column(name = "pet_name", nullable = false)
    private String name;
	
	@Column(name="breed", nullable = false)
	private String breed;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "updated_at")
	private Date updated; 

   
}