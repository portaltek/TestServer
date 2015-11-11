package org.portalapps.webapp.dto.sec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEC_ROL", catalog = "SEC")
public class SecRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "ROL_ID", unique = true, nullable = false, length = 100)
	private String rolId;
	@Column(name = "ROL_NAME", unique = false, nullable = false, length = 100)
	private String rolName;
	
	public SecRol() {
	}
	public SecRol(String rolId, String rolName) {
		this.rolId = rolId;
		this.rolName = rolName;
	}
	public String getRolId() {
		return rolId;
	}
	public void setRolId(String rolId) {
		this.rolId = rolId;
	}
	public String getRolName() {
		return rolName;
	}
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public String toString(){
		return "SEC_ROL[rolId=" + rolId + ", rolName=" + rolName  + "]";
	}


}
