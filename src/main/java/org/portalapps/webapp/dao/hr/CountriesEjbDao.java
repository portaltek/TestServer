package org.portalapps.webapp.dao.hr;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.portalapps.webapp.service.CountriesService;

@WebService(name = "CountriesService", serviceName = "CountriesService", targetNamespace = "urn:CountriesService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Stateless(name = "CountriesService")
//@Stateless
//public class CountriesEjbDao extends AbstracEjbDao<Countries> {
public class CountriesEjbDao implements CountriesService{
	
	public void printHello(){
		String m = "*****************************************";
		System.out.println(m);
		System.out.println("CountriesEjbDao");
	}
}
