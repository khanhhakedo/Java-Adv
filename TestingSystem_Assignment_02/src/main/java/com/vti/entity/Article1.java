package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Article1")
public class Article1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	@Column(name = "`status`", nullable = false)
	@Convert(converter = ArticleStatusConverter1.class)
	private Status status;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@CreationTimestamp
	private  Date updatedDate;

	public Article1() {
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", status=" + status + "]";
	}

	public enum Status {
		OPEN("O"), REVIEW("REV"), APPROVED("A"), REJECTED("REJ");

		private String status;

		private Status(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public static Status toEnum(String sqlStatus) {
			for (Status item : Status.values()) {
				if (item.getStatus().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}
}
