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
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entity representing a record from "dogvacay.reservation_transaction" table.
 * 
 * @author jtafralian
 */
@Entity
@Table(name = "reservation_transaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="com.dogvacay.traps.transaction.model.ReservationTransaction")
public class ReservationTransaction 
	implements Serializable {

	private static final long serialVersionUID = -4764019839238247019L;

	@Id
    @GeneratedValue
	@Column(name = "id", nullable = false)
    private Integer id;

	@Column(name = "amount_billed", nullable = false)
	private Float amountBilled;	

	@Column(name = "amount_paidout")
	private Float amountPaidout;	
	
	@Column(name="created_on", nullable = false)
    private Timestamp createdAt;
	
	// TODO need Integer boolean type
	@Column(name = "is_deleted", nullable = false)
	private Integer deleted;

	@Column(name = "description")
	private String description;
	
	@Column(name = "parent_transaction_id")
	private String parentTransactionId;
	
	@Column(name = "payment_profile_id")
	private String paymentProfileId;

	@Column(name = "reservation_id", nullable = false)
	private Integer reservationId;

	@Column(name = "response_text")
	private String responseText;

	@Column(name = "result")
	private String result;

	@Column(name = "source", nullable = false)
	private String source;

	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "transaction_type", nullable = false)
	private String transactionType;


	public Float getAmountBilled() {
		return amountBilled;
	}

	public Float getAmountPaidout() {
		return amountPaidout;
	}

	public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getDeleted() {
		return deleted;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public String getPaymentProfileId() {
		return paymentProfileId;
	}
	
	public String getParentTransactionId() {
		return parentTransactionId;
	}

	public String getResponseText() {
		return responseText;
	}

	public String getResult() {
		return result;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public String getSource() {
		return source;
	}

	public String getTransactionId() {
		return transactionId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setAmountBilled(Float amountBilled) {
		this.amountBilled = amountBilled;
	}

	public void setAmountPaidout(Float amountPaidout) {
		this.amountPaidout = amountPaidout;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setParentTransactionId(String parentTransactionId) {
		this.parentTransactionId = parentTransactionId;
	}

	public void setPaymentProfileId(String paymentProfileId) {
		this.paymentProfileId = paymentProfileId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override 
	public boolean equals(Object obj) {
		boolean equals = obj instanceof ReservationTransaction;
		
		if (equals) {
			ReservationTransaction other = (ReservationTransaction) obj;
			EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.amountBilled, other.amountBilled);
            builder.append(this.amountPaidout, other.amountPaidout);
            builder.append(this.createdAt, other.createdAt);
			builder.append(this.deleted, other.deleted);
			builder.append(this.description, other.description);
			builder.append(this.id, other.id);
			builder.append(this.paymentProfileId, other.paymentProfileId);
			builder.append(this.reservationId, other.reservationId);
			builder.append(this.responseText, other.responseText);
			builder.append(this.result, other.result);
			builder.append(this.source, other.source);
			builder.append(this.transactionType, other.transactionType);
			equals = builder.isEquals();
		}
		
		return equals;
	}

	@Override 
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.amountBilled);
        builder.append(this.amountPaidout);
        builder.append(this.createdAt);
        builder.append(this.deleted);
        builder.append(this.description);
		builder.append(this.id);
		builder.append(this.paymentProfileId);
		builder.append(this.reservationId);
		builder.append(this.responseText);
		builder.append(this.result);
		builder.append(this.source);
		builder.append(this.transactionType);
		return builder.toHashCode();
	}

	@Override 
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("amountBilled", this.amountBilled);
        builder.append("amountPaidout", this.amountPaidout);
        builder.append("createdAt", this.createdAt);
		builder.append("deleted", this.deleted);
		builder.append("description", this.description);
		builder.append("id", this.id);
		builder.append("paymentProfileId", this.paymentProfileId);
		builder.append("reservationId", this.reservationId);
		builder.append("responseText", this.responseText);
		builder.append("result", this.result);
		builder.append("source", this.source);
		builder.append("transactionType", this.transactionType);
		return builder.toString();
	}
   
}
