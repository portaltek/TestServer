package org.portalapps.webapp.dto.sec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRUEBA", catalog = "SEC")
public class Prueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRUEBA", unique = false, nullable = false, length = 100)
	private String prueba;

	public Prueba() {
	}
	public Prueba(String prueba) {
		this.prueba = prueba;
	}


}
