package org.portalapps.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.portalapps.webapp.dao.hr.CountriesJpaDao;
import org.portalapps.webapp.dao.hr.RegionsJpaDao;
import org.portalapps.webapp.dto.hr.Country;
import org.portalapps.webapp.dto.hr.Region;
import org.portalapps.webapp.dto.hr.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.sf.json.JSONObject;


@RestController
@RequestMapping(value = "/country/")
public class CountryRestController {

	@Resource private CountriesJpaDao countriesJpaDao;	
	@Resource private RegionsJpaDao regionsJpaDao;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> findAll() {
		JSONObject json = new JSONObject();
		List<Country> list = countriesJpaDao.findAll();
		
		if(list.isEmpty()){
			return new ResponseEntity<String>(json.toString(), HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}

	    json.put("LIST", list);
		return new ResponseEntity<String>(json.toString(),  HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(
			@RequestBody Country country,    UriComponentsBuilder ucBuilder) {

		Region r = new Region();
		r.setRegionId(1);
		r.setRegionName("Americas");
		
		Country c = new Country();
		c.setCountryId("AA");
		c.setCountryName("AAA");
		c.setRegion(r);
		
		countriesJpaDao.insert(c);

		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


}