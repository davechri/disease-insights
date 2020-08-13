package com.davechri.diseases.data;

import java.util.List;

/**
 * List of UMLS concepts representing a JSON response.
 */
public class Concepts {
  List<ConceptEntry> concepts;
  
  public static class ConceptEntry {
    private int count;
    private String cui;
    private int hitCount;
    private String ontology;
    private String preferredName;
    private String semanticType;

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public String getCui() {
      return cui;
    }

    public void setCui(String cui) {
      this.cui = cui;
    }

    public int getHitCount() {
      return hitCount;
    }

    public void setHitCount(int hitCount) {
      this.hitCount = hitCount;
    }

    public String getOntology() {
      return ontology;
    }

    public void setOntology(String ontology) {
      this.ontology = ontology;
    }

    public String getPreferredName() {
      return preferredName;
    }

    public void setPreferredName(String preferredName) {
      this.preferredName = preferredName;
    }

    public String getSemanticType() {
      return semanticType;
    }

    public void setSemanticType(String semanticType) {
      this.semanticType = semanticType;
    }
  }

  public List<ConceptEntry> getConcepts() {
    return concepts;
  }

  public void setConcepts(List<ConceptEntry> concepts) {
    this.concepts = concepts;
  }
}