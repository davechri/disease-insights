package com.davechri.diseases.controller;

import com.davechri.diseases.data.Concepts;
import com.davechri.diseases.service.DiseaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diseases")
public class ApiController {
    @Autowired    
    private DiseaseService diseaseService;

    public enum Filters {
        age_groups, drugs, genes, symptoms;
    }

    /**
     * Get co-occurring concepts
     * @param disease - name of disease (e.g., diabetes)
     * @param filters - filter on: age groups, drugs, genes or symptoms
     * @param limit - maximum number of concepts to return
     * @return concepts identifying UMLS concepts for diseases
     */
    @GetMapping("/{disease}")
    public Concepts getCoocurringConcepts(@PathVariable String disease,  
                                          @RequestParam Filters filters,
                                          @RequestParam(required = false, defaultValue="25") int limit) {
        return diseaseService.getCooccurringConcepts(disease, filters, limit);
    }
}