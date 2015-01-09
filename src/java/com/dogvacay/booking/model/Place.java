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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

import lombok.Getter;

/**
 * Entity representing records from the "dogvacay.places" table.
 * 
 * @author jtafralian
 */
@Entity
@Immutable
@Table(name = "places")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="com.dogvacay.booking.model.Place")
public class Place implements Serializable {

	private static final long serialVersionUID = -3806216301056941948L;

	@Id
    @GeneratedValue
    @Column(name="id_user")
    @Getter
    private Integer userId;
   
	@Column(name = "city", nullable = false)
    @Getter
    private String city;

	@Column(name = "country", nullable = false)
    @Getter
    private String country;

	@Column(name = "description", nullable = false)
    @Getter
	private String description;
	
	@Column(name = "lat", nullable = false)
    @Getter
	private Double latitude;

	@Column(name = "lng", nullable = false)
    @Getter
	private Double longitude;
	
	@Column(name = "state", nullable = false)
    @Getter
    private String state;
	
	@Column(name = "title", nullable = false)
    @Getter
    private String title;

	@Column(name = "zip", nullable = false)
    @Getter
    private String zipcode;


	@Override public boolean equals(Object obj) {
		boolean equals = obj instanceof Place;
		
		if (equals) {
			Place other = (Place) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.city, other.city);
			builder.append(this.country, other.country);
			builder.append(this.description, other.description);
			builder.append(this.latitude, other.latitude);
			builder.append(this.longitude, other.longitude);
			builder.append(this.state, other.state);
			builder.append(this.title, other.title);
			builder.append(this.userId, other.userId);
			builder.append(this.zipcode, other.zipcode);
			equals = builder.isEquals();
		}
		
		return equals;
	}

	@Override public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.city);
		builder.append(this.country);
		builder.append(this.description);
		builder.append(this.latitude);
		builder.append(this.longitude);
		builder.append(this.state);
		builder.append(this.title);
		builder.append(this.userId);
		builder.append(this.zipcode);
		return builder.toHashCode();
	}

	@Override public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("city", this.city);
		builder.append("country", this.country);
		builder.append("description", this.description);
		builder.append("latitude", this.latitude);
		builder.append("longitude", this.longitude);
		builder.append("state", this.state);
		builder.append("title", this.title);
		builder.append("userId", this.userId);
		builder.append("zipcode", this.zipcode);
		return builder.toString();
	}
   
}