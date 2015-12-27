package org.portalapps.webapp.dto.sec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEC_SYSTEM", catalog = "SEC")
public class SecSystem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SYSTEM_ID", unique = true, nullable = false, length = 20)
	private String systemId;
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	@Column(name = "DESCRIPTION", unique = false, length = 200)
	private String description;

	public SecSystem() {
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SecSystem [systemId=" + systemId + ", name=" + name + ", description=" + description + "]";
	}

	
}
