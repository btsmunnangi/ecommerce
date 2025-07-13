package com.payment.audit;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@Document(collection = "audit_log")
public class AuditLog {
	@Id
	private String id;
	private String action;
	private LocalDateTime timestamp;
	private String user;
	private String description;
	
	public AuditLog() {}
	
	public AuditLog(String id, String action, LocalDateTime timestamp, String user, String description) {
		super();
		this.id = id;
		this.action = action;
		this.timestamp = timestamp;
		this.user = user;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(action, description, id, timestamp, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditLog other = (AuditLog) obj;
		return Objects.equals(action, other.action) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", action=" + action + ", timestamp=" + timestamp + ", user=" + user
				+ ", description=" + description + "]";
	}
}
