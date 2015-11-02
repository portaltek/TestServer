package org.portalapps.webapp.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName="countriesWS")
public class   CountriesWS  {
	//DI via Spring
	@Autowired CountriesBO countriesBO;

	@WebMethod(exclude=true)
	public void setCountriesBO(CountriesBO countriesBO) {
		this.countriesBO = countriesBO;
	}

	@WebMethod(operationName="getHelloWorld")
	public String getHelloWorld() {		
		return countriesBO.getHelloWorld();
		
	}
}