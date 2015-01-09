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

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Represents a mutable record in the dogvacay.messages table
 * 
 * @author jtafralian
 */
@Entity
@Table(name = "messages")
public class Message
	implements Serializable {

	private static final long serialVersionUID = -4149361146209564930L;

	
	@Id
    @GeneratedValue
    @Getter
    private Integer id;
   
	@Getter
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="thread_id")
    @Setter
    private MessageThread thread;
	
	@Column(name = "body_text")
    @Getter
    @Setter
	private String body;

	@Column(name = "created", nullable = false)
    @Getter
    @Setter
	private Date created;

	@Column(name = "details")
    @Getter
    @Setter
	private String details;

	@Column(name = "deleted_for",  nullable = false) // this field is non-null but not used.
	private Integer deletedFor = 0;

	
	@Column(name = "from_user", nullable = false)
    @Getter
    @Setter
	private Integer fromUserId;

	@Column(name = "history")
    @Getter
    @Setter
	private String history;

	@Column(name = "id_listing",  nullable = false) // this field is non-null but not used.
	private Integer idListing = 0;
	
	@Column(name = "replied") // this field is non-null but not used.
	private Integer replied = 127; // field has distinct values: 0,1,127

	@Column(name = "result",  nullable = false) // this field is non-null but not used.
	private String result = StringUtils.EMPTY;

	@Column(name = "source")
    @Getter
    @Setter
	private String source;

	@Column(name = "tag",  nullable = false) // this field is non-null but not used.
	private String tag = StringUtils.EMPTY;
	
	@Column(name = "id_user", nullable = false)
    @Getter
    @Setter
	private Integer toUserId;
	
	@Override
    public boolean equals(Object obj) {
		boolean equals = obj instanceof Message;
		
		if (equals) {
			Message other = (Message) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.id, other.id);
			builder.append(this.body, other.body);
			builder.append(this.details, other.details);
			builder.append(this.history, other.history);
			builder.append(this.fromUserId, other.fromUserId);
			builder.append(this.replied, other.replied);
			builder.append(this.source, other.source);
			builder.append(this.toUserId, other.toUserId);
			equals = builder.isEquals();
		}
		
		return equals;
	}

	@Override public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.id);
		builder.append(this.body);
		builder.append(this.created);
		builder.append(this.details);
		builder.append(this.history);
		builder.append(this.fromUserId);
		builder.append(this.replied);
		builder.append(this.source);
		builder.append(this.toUserId);
		return builder.toHashCode();
	}

	@Override public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("id", this.id);
		builder.append("body", this.body);
		builder.append("created", this.created);
		builder.append("details", this.details);
		builder.append("history", this.history);
		builder.append("fromUserId", this.fromUserId);
		builder.append("replied", this.replied);
		builder.append("source", this.source);
		builder.append("toUserId", this.toUserId);
		return builder.toString();
	}
}