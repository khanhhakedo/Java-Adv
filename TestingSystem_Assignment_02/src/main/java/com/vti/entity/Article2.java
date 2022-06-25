package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Article2`")
public class Article2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArticlePk id;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@CreationTimestamp
	private  Date updatedDate;

	public Article2() {
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public ArticlePk getId() {
		return id;
	}

	public void setId(ArticlePk id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + "]";
	}

	@Embeddable
	public static class ArticlePk implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "Article_id1")
		private short orderId;

		@Column(name = "Article_id2")
		private short productId;

		public ArticlePk() {
		}

		public short getOrderId() {
			return orderId;
		}

		public void setOrderId(short orderId) {
			this.orderId = orderId;
		}

		public short getProductId() {
			return productId;
		}

		public void setProductId(short productId) {
			this.productId = productId;
		}
	}

}
