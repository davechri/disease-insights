package com.davechri.diseases;

import com.davechri.diseases.data.Concepts;
import com.davechri.diseases.exception.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Ignore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DiseasesApplicationTests {
	private static final String URL = "http://localhost:8080";
  private RestTemplate restTemplate = new RestTemplate();

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAgeGroupsForDisease() {
		Concepts concepts = restTemplate.getForObject(URL+"/api/diseases/diabetes?filters=age_groups&limit=100", Concepts.class);
		Assert.assertTrue(concepts.getConcepts().size() > 0);
	}

	@Test
	void testGetDrugsForDisease() {
		Concepts concepts = restTemplate.getForObject(URL+"/api/diseases/diabetes?filters=drugs&limit=100", Concepts.class);
		Assert.assertTrue(concepts.getConcepts().size() > 0);
	}

	@Test
	void testGetGenesForDisease() {
		Concepts concepts = restTemplate.getForObject(URL+"/api/diseases/diabetes?filters=genes&limit=100", Concepts.class);
		Assert.assertTrue(concepts.getConcepts().size() > 0);
	}

	@Test
	void testGetSymptomsForDisease() {
		Concepts concepts = restTemplate.getForObject(URL+"/api/diseases/diabetes?filters=symptoms&limit=100", Concepts.class);
		Assert.assertTrue(concepts.getConcepts().size() > 0);
	}

	// This error test is not working correctly
	// @Test	
	// void testUnknownDisease() {
	// 	try {
	// 		restTemplate.getForObject(URL+"/api/diseases/badbadbad?filters=drugs&limit=100", Concepts.class);
	// 		Assert.assertTrue("EntityNotFoundException was thrown", false);
	// 	}
	// 	catch(EntityNotFoundException e) {}		
	// }
}
