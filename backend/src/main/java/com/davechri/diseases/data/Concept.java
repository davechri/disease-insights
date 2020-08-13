package com.davechri.diseases.data;

import java.util.List;

/**
 * UMLS concept.
 */
public class Concept {
  private String ontology;
  private String cui;
  private Integer rank;
  private String definition;
  private Boolean hasChildren;
  private Boolean hasParents;
  private Boolean hasSiblings;
  private String preferredName;
  private List<String> semanticTypes;
  private String semanticType;
  private List<String> surfaceForms;

  public String getOntology() {
    return ontology;
  }

  public void setOntology(String ontology) {
    this.ontology = ontology;
  }

  public String getCui() {
    return cui;
  }

  public void setCui(String cui) {
    this.cui = cui;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public Boolean isHasChildren() {
    return hasChildren;
  }

  public void setHasChildren(Boolean hasChildren) {
    this.hasChildren = hasChildren;
  }

  public Boolean isHasParents() {
    return hasParents;
  }

  public void setHasParents(Boolean hasParents) {
    this.hasParents = hasParents;
  }

  public Boolean isHasSiblings() {
    return hasSiblings;
  }

  public void setHasSiblings(Boolean hasSiblings) {
    this.hasSiblings = hasSiblings;
  }

  public String getPreferredName() {
    return preferredName;
  }

  public void setPreferredName(String preferredName) {
    this.preferredName = preferredName;
  }

  public List<String> getSemanticTypes() {
    return semanticTypes;
  }

  public void setSemanticTypes(List<String> semanticTypes) {
    this.semanticTypes = semanticTypes;
  }

  public List<String> getSurfaceForms() {
    return surfaceForms;
  }

  public void setSurfaceForms(List<String> surfaceForms) {
    this.surfaceForms = surfaceForms;
  }

  public String getSemanticType() {
    return semanticType;
  }

  public void setSemanticType(String semanticType) {
    this.semanticType = semanticType;
  }
  
}