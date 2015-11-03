package org.portalapps.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.portalapps.webapp.dao.hr.CountryJpaDao;
import org.portalapps.webapp.dao.hr.RegionJpaDao;
import org.portalapps.webapp.dto.hr.Country;
import org.portalapps.webapp.dto.hr.Region;
import org.portalapps.webapp.dto.hr.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

	@Resource private CountryJpaDao countriesJpaDao;	
	@Resource private RegionJpaDao regionsJpaDao;

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
	@Transactional
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(
			@RequestBody Country country) {
		HttpHeaders headers = new HttpHeaders();
		try {
			countriesJpaDao.insert(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


}