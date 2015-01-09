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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.OrderBy;

/**
 * Represents a partially mutable record in the dogvacay.threads table.
 * 
 * @author jtafralian
 */
@EqualsAndHashCode
@ToString
@Getter
@Entity
@Table(name = "threads")
public class MessageThread 
	implements Serializable {

	private static final long serialVersionUID = -507178153157726074L;

	@Id
    @GeneratedValue
    private Integer id;
   
	@Column(name = "created", nullable = false)
	private Date created;
	
	@Column(name = "modified")
	private Date modified;

	@Column(name = "details")
    @Setter
	private String details;

	@Column(name = "from_id", nullable = false)
	private Integer fromUserId;

	@Column(name = "history")
    @Setter
	private String history;
	
	@Column(name = "last_text")
    @Setter
	private String lastText;
	
    @Getter
    @Setter
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="thread_id")
    @OrderBy(clause = "created DESC") // latest messages first (this will be an 'ORDER BY' in the DB query)
   private List<Message> messages;

	@Column(name = "resource_id")
    @Setter
	private Integer resourceId;
    
	@Column(name = "resource_type")
    @Setter
	private String resourceType;
    
	@Column(name = "to_id", nullable = false)
	private Integer toUserId;
	
	public MessageThread()  {}
	
	public MessageThread(Integer toUserId, Integer fromUserId)  {
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		Date now = new Date();
		this.created = now;
		this.modified = now;
	}
	
	
	public void addMessage(Message message)  {
		if(messages == null)
			messages = new ArrayList<>();
		
		// put message as first (as it's most recent)
	    messages.add(0, message);
	}
	
}