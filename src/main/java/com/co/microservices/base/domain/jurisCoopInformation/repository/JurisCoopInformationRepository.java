package com.co.microservices.base.domain.jurisCoopInformation.repository;

import org.apache.log4j.Logger;
import com.co.microservices.base.domain.morty.response.RickyResponse;

public interface JurisCoopInformationRepository {
	
   final static Logger logger = Logger.getLogger(JurisCoopInformationRepository.class);
	   
   public RickyResponse getMessage();
   
}
