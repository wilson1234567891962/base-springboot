package com.co.microservices.base.domain.morty.response;
import org.apache.log4j.Logger;
import lombok.Data;

@Data
public class RickyResponse {

	final static Logger logger = Logger.getLogger(RickyResponse.class);
	private String characters;
	private String locations;
	private String episodes;
	
	public RickyResponse() {
	}
}
