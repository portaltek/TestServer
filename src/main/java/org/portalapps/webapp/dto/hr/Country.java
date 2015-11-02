package org.portalapps.webapp.dto.hr;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES", catalog = "HR")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	private String countryId;
	@Column(name = "COUNTRY_NAME", unique = true, nullable = false, length = 20)
	private String countryName;
	@ManyToOne
	@JoinColumn(name="REGION_ID")
	private Region region;

	public Country(){

	}

	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
