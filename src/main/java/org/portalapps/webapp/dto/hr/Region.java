package org.portalapps.webapp.dto.hr;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS", catalog = "HR")
public class Region implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	    @Id @GeneratedValue
	    @Column(name = "REGION_ID", unique = true, nullable = false)
	    private int regionId;
	    @Column(name = "REGION_NAME", unique = true, nullable = false, length = 20)
	    private String regionName;
	    
//	    @OneToMany(mappedBy="region",fetch=FetchType.EAGER)
//	    private List<Country> countryList;	    
//	    
	    
	    public Region(){
	    	
	    }

		public int getRegionId() {
			return regionId;
		}

		public void setRegionId(int regionId) {
			this.regionId = regionId;
		}

		public String getRegionName() {
			return regionName;
		}

		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}

//		public List<Country> getCountryList() {
//			return countryList;
//		}
//
//		public void setCountriesList(List<Country> countryList) {
//			this.countryList = countryList;
//		}
	    
	

}
