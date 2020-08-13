package com.davechri.diseases.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.davechri.diseases.controller.ApiController.Filters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {
  "query": {
    "concepts": [
      {
        "ontology": "concepts",
        "cui": "C0021400",
        "rank": 10
      }
    ],
    "boolTerm": {}
  },
  "returns": {
    "concepts": {
      "ontology": "concepts",
      "types": [
        "Antibiotic",
        "ClinicalDisease",
        "Hormone",
        "PharmacologicSubstance"
      ],
      "limit": 25,
      "mode": "popular"
    }
  }
}
 */ 
public class CoocurringQuery {
  private static final Map<Filters, List<String>> filtersMap = Map.of(
    Filters.age_groups, List.of("AgeGroup"),
    Filters.drugs, List.of("Antibiotic", "ClinicalDisease", "Hormone","PharmacologicSubstance"),
    Filters.genes, List.of("GeneOrGenome"),
    Filters.symptoms, List.of("SignOrSymptom")

  );

  private Query query = new Query();
  private Returns returns = new Returns();

  /**
   * Build co-occurring query with filter on age, drugs, genes, or symptoms.
   * @param cui
   * @param filters
   * @param limit
   */
  public CoocurringQuery(final String cui, final String semanticType, Filters filters, int limit) {    
    Concept concept = new Concept();
    concept.setOntology("concepts"); // todo: define concept
    concept.setCui(cui);
    concept.setSemanticType(semanticType);
    concept.setRank(10); // require
    query.getConcepts().add(concept);

    ReturnsConcepts returnsConcepts = returns.getConcepts();
    returnsConcepts.setOntology("concepts");
    returnsConcepts.setTypes(filtersMap.get(filters));
    returnsConcepts.setLimit(limit); 
    returnsConcepts.setMode("significant");  

    //System.out.println(this.toString());
  }

  public static class Query {
    List<Concept> concepts = new ArrayList<Concept>();

    public List<Concept> getConcepts() {
      return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
      this.concepts = concepts;
    }
  }

  public static class Returns {
    ReturnsConcepts concepts = new ReturnsConcepts();

    public ReturnsConcepts getConcepts() {
      return concepts;
    }

    public void setConcepts(ReturnsConcepts concepts) {
      this.concepts = concepts;
    }

  }

  public static class ReturnsConcepts {
    private String ontology;
    private List<String> types;
    private int limit;
    private String mode;

    public String getOntology() {
      return ontology;
    }

    public void setOntology(String ontology) {
      this.ontology = ontology;
    }

    public List<String> getTypes() {
      return types;
    }

    public void setTypes(List<String> types) {
      this.types = types;
    }

    public int getLimit() {
      return limit;
    }

    public void setLimit(int limit) {
      this.limit = limit;
    }

    public String getMode() {
      return mode;
    }

    public void setMode(String mode) {
      this.mode = mode;
    }
    
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }

  public Returns getReturns() {
    return returns;
  }

  public void setReturns(Returns returns) {
    this.returns = returns;
  }

  @Override
  public String toString() {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}