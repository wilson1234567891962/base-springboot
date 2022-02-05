package com.co.microservices.base.domain.jurisCoopInformation.service;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.co.microservices.base.domain.jurisCoopInformation.repository.JurisCoopInformationRepository;
import com.co.microservices.base.domain.morty.response.RickyResponse;
import com.co.microservices.base.adapter.database.repository.ExampleRepositoryJPA;

@Component
public class JurisCoopInformationService {

	final static Logger logger = Logger.getLogger(JurisCoopInformationService.class);
	private JurisCoopInformationRepository jurisCoopInformationRepository;
	private DozerBeanMapper mapper;
	@Autowired
	private ExampleRepositoryJPA exampleRepositoryJPA;

	@Autowired
	public JurisCoopInformationService(JurisCoopInformationRepository jurisCoopInformationRepository,
			DozerBeanMapper mapper) {

		this.jurisCoopInformationRepository = jurisCoopInformationRepository;
		this.mapper = mapper;
	}

	public RickyResponse getRickyMortinData() {
		logger.info(exampleRepositoryJPA.findAll());
		return jurisCoopInformationRepository.getMessage();
	}
}
