package com.davechri.diseases.service;

import com.davechri.diseases.controller.ApiController.Filters;
import com.davechri.diseases.data.Concept;
import com.davechri.diseases.data.Concepts;
import com.davechri.diseases.data.CoocurringQuery;
import com.davechri.diseases.exception.EntityNotFoundException;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiseaseService {    

    private final static String VERSION = "version=2020-08-08";
        
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Get co-occurring conconcepts for a disease.
     * @param disease - name of disease
     * @param filters - filter on: 
     * @return List of disease concepts
     */
    public Concepts getCooccurringConcepts(String disease, Filters filters, int limit) { 
        final String url = "https://covid-19-navigator.mybluemix.net/corpora/covid19";

        Concept concept = null;
        try {           
            concept = restTemplate.getForObject(url+"/concepts/"+disease+"?"+VERSION,
                                                 Concept.class);            
        }
        catch (Exception e) {
            throw new EntityNotFoundException();
        }
        
        final String semanticType = concept.getSemanticTypes().get(0);
        final CoocurringQuery diseasesQuery = new CoocurringQuery(concept.getCui(), semanticType, filters, limit);
        final HttpEntity<CoocurringQuery> request = new HttpEntity<>(diseasesQuery);
        Concepts concepts = restTemplate.postForObject(url+"/search?"+VERSION, request, Concepts.class);

        return concepts;
    }
}