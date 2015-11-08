package org.portalapps.webapp.controller;
import java.util.List;

import javax.annotation.Resource;

import org.portalapps.webapp.dao.hr.CountryJpaDao;
import org.portalapps.webapp.dao.hr.RegionJpaDao;
import org.portalapps.webapp.dto.hr.Country;
import org.portalapps.webapp.dto.hr.Region;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class DefaultController {
	
	@Resource private CountryJpaDao countriesJpaDao;	
	@Resource private RegionJpaDao regionsJpaDao;
//	@EJB private CountriesEjbDao countriesEjbDao;
	 
//	@RequestMapping(value={ "/", "/index", "/views/index.jsp"})
//	public String hello(){
//		System.out.println("hello");
//		 
//		List<Countries> list = countriesJpaDao.findAll();
//		printAll(list);
//		countriesEjbDao.printHello();
//		return "index";
//	}
	
	@RequestMapping(value={ "/users"})
    public String usersManagement() {
        return "UserManagement";
    }
	
//	@RequestMapping(value={ "/"})
//    public String index() {
//		return "index"; 
//    }
//	
	
	
	public void printAll(List<Country> list){
		System.out.println("********* JPA ***********");
		for (Country c: list){
			String m = "=>" + c.getCountryId() 
					+ ", " + c.getCountryName() ;
			System.out.println(m);
		}
		System.out.println("MAIN: " + list.size());
		System.out.println("********* Regions ***********");
		List<Region> regionList = regionsJpaDao.findAll();
		for (Region c: regionList){
			RegionJpaDao.initializeAndUnproxy(c);
			String m = "=>" + c.getRegionId() 
					+ ", " + c.getRegionName()
//					+ ", => " + c.getCountriesList().size()
					;
			System.out.println(m);
		}
		System.out.println("MAIN: " + regionList.size());
	}
	
//	@RequestMapping(value={  "/index2", "views/index2", "/views/index2.jsp"})
//	public String hello2(){
//		System.out.println("hello2");
//		return "index2";
//	}	
}
