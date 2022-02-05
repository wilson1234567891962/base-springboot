package com.co.microservices.base.adapter.api.facade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.microservices.base.domain.jurisCoopInformation.service.JurisCoopInformationService;
import com.co.microservices.base.domain.morty.response.RickyResponse;

@Service
public class JurisCoopFacade {


    final static Logger logger = Logger.getLogger(JurisCoopFacade.class);
    
    @Autowired
    private JurisCoopInformationService jurisCoopInformationService;
    
    public RickyResponse getMessage() {
    	return jurisCoopInformationService.getRickyMortinData();
    }
}
