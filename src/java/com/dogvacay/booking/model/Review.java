package com.dogvacay.booking.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

	private static final long serialVersionUID = -6529050024797053059L;

	@Id
    @GeneratedValue
    @Getter
    private Integer id;
	
	@Column(name = "host_id")
	@Getter
	@Setter
	private Integer hostId;
	
	@Column(name = "reservation_id")
	@Getter
	@Setter
	private Integer bookingId;
	
	@Column(name = "reviewer_id")
	@Getter
	@Setter
	private Integer reviewerId;
	
	@Column(name = "created_at")
	@Getter
	@Setter
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Getter
	@Setter
	private Date updatedAt;
	
	@Column(name = "rating")
	@Getter
	@Setter
	private Integer rating;

	@Column(columnDefinition = "text", name = "ratings")
	@Getter
	@Setter
	private String ratings;

	@Column(columnDefinition = "text", name = "body")
	@Getter
	@Setter
	private String publicReview;

	@Column(columnDefinition = "text", name = "private")
	@Getter
	@Setter
	private String privateReview;

	@Column(columnDefinition = "text", name = "curated")
	@Getter
	@Setter
	private String curated = "";
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = obj instanceof Review;
		
		if (equals) {
			Review other = (Review) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.hostId, other.hostId);
			builder.append(this.bookingId, other.bookingId);
			builder.append(this.reviewerId, other.reviewerId);
			builder.append(this.createdAt, other.createdAt);
			builder.append(this.updatedAt, other.updatedAt);
			builder.append(this.rating, other.rating);
			builder.append(this.ratings, other.ratings);
			builder.append(this.publicReview, other.publicReview);
			builder.append(this.privateReview, other.privateReview);
			builder.append(this.curated, other.curated);
			equals = builder.isEquals();
		}
		
		return equals;
	}

	@Override 
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.hostId);
		builder.append(this.bookingId);
		builder.append(this.reviewerId);
		builder.append(this.createdAt);
		builder.append(this.updatedAt);
		builder.append(this.rating);
		builder.append(this.ratings);
		builder.append(this.publicReview);
		builder.append(this.privateReview);
		builder.append(this.curated);
		return builder.toHashCode();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("hostId", this.hostId);
		builder.append("bookingId", this.bookingId);
		builder.append("reviewerId", this.reviewerId);
		builder.append("createdAt", this.createdAt);
		builder.append("updatedAt", this.updatedAt);
		builder.append("rating", this.rating);
		builder.append("ratings", this.ratings);
		builder.append("publicReview", this.publicReview);
		builder.append("privateReview", this.privateReview);
		builder.append("curated", this.curated);
		return builder.toString();
	}
}
