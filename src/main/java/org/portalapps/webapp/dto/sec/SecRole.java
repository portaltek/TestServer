package org.portalapps.webapp.dto.sec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEC_ROLE", catalog = "SEC")
public class SecRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, length = 100)
	private String roleId;
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	@Column(name = "DESCRIPTION", unique = false, length = 100)
	private String descripcion;

	public SecRole() {
	}

	public SecRole(String roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return "SEC_ROL[roleId=" + roleId + ", name=" + name + "]";
	}

}
