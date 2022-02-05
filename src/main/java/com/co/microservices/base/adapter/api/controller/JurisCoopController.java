package com.co.microservices.base.adapter.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.microservices.base.adapter.api.ApiConst;
import com.co.microservices.base.adapter.api.facade.JurisCoopFacade;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import ubunpay.commons.domain.constant.ConstantErrors;
import ubunpay.commons.domain.constant.EnumErrors;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.apache.log4j.Logger;
@RestController
@RequestMapping(value = ApiConst.JURISCOOP_PATH)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class JurisCoopController {

    final static Logger logger = Logger.getLogger(JurisCoopController.class);
    
    private JurisCoopFacade jurisCoopFacade;
    
    @Autowired
    public JurisCoopController(JurisCoopFacade jurisCoopFacade) {
        this.jurisCoopFacade = jurisCoopFacade;
    }
    
	@GetMapping("/message")
	public String getMessage() {
		return "V20200914_01";
	}
	
	@ApiOperation(value = "testMessageServices")
	@RequestMapping(value = "/testMessageServices/", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCalculateFromValue() {
		try {
			return new ResponseEntity<String>(new Gson().toJson(this.jurisCoopFacade.getMessage()), HttpStatus.ACCEPTED);
		} 
		catch (Exception e) {
			logger.error(e);
			return new ResponseEntity<String> (new Gson().toJson(ConstantErrors.ERRORS_STATES.get(EnumErrors.GENERIC_ERROR.getCode())), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
