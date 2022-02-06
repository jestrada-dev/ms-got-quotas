package com.jestrada.msgotquotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jestrada.msgotquotas.models.Quota;

@RestController
public class QuotasController {
	
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${GOT_QUOTAS_API.BASE_URL}")
    private String BASE_URL;
    
    @Value("${GOT_QUOTAS_API.END_POINTS.RANDOM}")
    private String RANDOM;
	
	@GetMapping("/random")
	public ResponseEntity<Quota> getRandom() {
	       
		ResponseEntity<Quota> responseEntity = restTemplate
		.getForEntity(BASE_URL + RANDOM, Quota.class);
		 
        return responseEntity;
	}
}
