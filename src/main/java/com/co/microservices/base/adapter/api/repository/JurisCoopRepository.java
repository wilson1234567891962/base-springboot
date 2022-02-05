package com.co.microservices.base.adapter.api.repository;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.co.microservices.base.domain.jurisCoopInformation.repository.JurisCoopInformationRepository;
import com.co.microservices.base.domain.morty.response.RickyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JurisCoopRepository implements JurisCoopInformationRepository {

    final static Logger logger = Logger.getLogger(JurisCoopRepository.class);
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	@Autowired
	public JurisCoopRepository(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public RickyResponse getMessage() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Object> responseEntity  = restTemplate.exchange("http://rickandmortyapi.com/api/", HttpMethod.GET, entity, Object.class);
		return objectMapper.convertValue(responseEntity.getBody(), RickyResponse.class);
	}
}
