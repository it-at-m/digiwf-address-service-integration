/*
 * Camel REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: Schema 2.0.2 Service 2.3.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.muenchendigital.digiwf.okewo.integration.gen.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * AnschriftType
 */


public class AnschriftType {
  @JsonProperty("gemeindeschluessel")
  private String gemeindeschluessel = null;

  @JsonProperty("hausnummer")
  private String hausnummer = null;

  @JsonProperty("buchstabeHausnummer")
  private String buchstabeHausnummer = null;

  @JsonProperty("teilnummerHausnummer")
  private String teilnummerHausnummer = null;

  @JsonProperty("ort")
  private String ort = null;

  @JsonProperty("ortsteil")
  private String ortsteil = null;

  @JsonProperty("postleitzahl")
  private String postleitzahl = null;

  @JsonProperty("stockwerk")
  private String stockwerk = null;

  @JsonProperty("appartmentnummer")
  private String appartmentnummer = null;

  @JsonProperty("strasse")
  private String strasse = null;

  @JsonProperty("wohnungsgeber")
  private String wohnungsgeber = null;

  @JsonProperty("zusatz")
  private String zusatz = null;

  @JsonProperty("staat")
  private String staat = null;

  @JsonProperty("anschriftUnbekannt")
  private Boolean anschriftUnbekannt = null;

  @JsonProperty("sperrvermerk")
  private Boolean sperrvermerk = null;

  public AnschriftType gemeindeschluessel(String gemeindeschluessel) {
    this.gemeindeschluessel = gemeindeschluessel;
    return this;
  }

   /**
   * Get gemeindeschluessel
   * @return gemeindeschluessel
  **/
  @Schema(description = "")
  public String getGemeindeschluessel() {
    return gemeindeschluessel;
  }

  public void setGemeindeschluessel(String gemeindeschluessel) {
    this.gemeindeschluessel = gemeindeschluessel;
  }

  public AnschriftType hausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
    return this;
  }

   /**
   * Get hausnummer
   * @return hausnummer
  **/
  @Schema(description = "")
  public String getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    this.hausnummer = hausnummer;
  }

  public AnschriftType buchstabeHausnummer(String buchstabeHausnummer) {
    this.buchstabeHausnummer = buchstabeHausnummer;
    return this;
  }

   /**
   * Get buchstabeHausnummer
   * @return buchstabeHausnummer
  **/
  @Schema(description = "")
  public String getBuchstabeHausnummer() {
    return buchstabeHausnummer;
  }

  public void setBuchstabeHausnummer(String buchstabeHausnummer) {
    this.buchstabeHausnummer = buchstabeHausnummer;
  }

  public AnschriftType teilnummerHausnummer(String teilnummerHausnummer) {
    this.teilnummerHausnummer = teilnummerHausnummer;
    return this;
  }

   /**
   * Get teilnummerHausnummer
   * @return teilnummerHausnummer
  **/
  @Schema(description = "")
  public String getTeilnummerHausnummer() {
    return teilnummerHausnummer;
  }

  public void setTeilnummerHausnummer(String teilnummerHausnummer) {
    this.teilnummerHausnummer = teilnummerHausnummer;
  }

  public AnschriftType ort(String ort) {
    this.ort = ort;
    return this;
  }

   /**
   * Get ort
   * @return ort
  **/
  @Schema(description = "")
  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public AnschriftType ortsteil(String ortsteil) {
    this.ortsteil = ortsteil;
    return this;
  }

   /**
   * Get ortsteil
   * @return ortsteil
  **/
  @Schema(description = "")
  public String getOrtsteil() {
    return ortsteil;
  }

  public void setOrtsteil(String ortsteil) {
    this.ortsteil = ortsteil;
  }

  public AnschriftType postleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
    return this;
  }

   /**
   * Get postleitzahl
   * @return postleitzahl
  **/
  @Schema(description = "")
  public String getPostleitzahl() {
    return postleitzahl;
  }

  public void setPostleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
  }

  public AnschriftType stockwerk(String stockwerk) {
    this.stockwerk = stockwerk;
    return this;
  }

   /**
   * Get stockwerk
   * @return stockwerk
  **/
  @Schema(description = "")
  public String getStockwerk() {
    return stockwerk;
  }

  public void setStockwerk(String stockwerk) {
    this.stockwerk = stockwerk;
  }

  public AnschriftType appartmentnummer(String appartmentnummer) {
    this.appartmentnummer = appartmentnummer;
    return this;
  }

   /**
   * Get appartmentnummer
   * @return appartmentnummer
  **/
  @Schema(description = "")
  public String getAppartmentnummer() {
    return appartmentnummer;
  }

  public void setAppartmentnummer(String appartmentnummer) {
    this.appartmentnummer = appartmentnummer;
  }

  public AnschriftType strasse(String strasse) {
    this.strasse = strasse;
    return this;
  }

   /**
   * Get strasse
   * @return strasse
  **/
  @Schema(description = "")
  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public AnschriftType wohnungsgeber(String wohnungsgeber) {
    this.wohnungsgeber = wohnungsgeber;
    return this;
  }

   /**
   * Get wohnungsgeber
   * @return wohnungsgeber
  **/
  @Schema(description = "")
  public String getWohnungsgeber() {
    return wohnungsgeber;
  }

  public void setWohnungsgeber(String wohnungsgeber) {
    this.wohnungsgeber = wohnungsgeber;
  }

  public AnschriftType zusatz(String zusatz) {
    this.zusatz = zusatz;
    return this;
  }

   /**
   * Get zusatz
   * @return zusatz
  **/
  @Schema(description = "")
  public String getZusatz() {
    return zusatz;
  }

  public void setZusatz(String zusatz) {
    this.zusatz = zusatz;
  }

  public AnschriftType staat(String staat) {
    this.staat = staat;
    return this;
  }

   /**
   * Get staat
   * @return staat
  **/
  @Schema(description = "")
  public String getStaat() {
    return staat;
  }

  public void setStaat(String staat) {
    this.staat = staat;
  }

  public AnschriftType anschriftUnbekannt(Boolean anschriftUnbekannt) {
    this.anschriftUnbekannt = anschriftUnbekannt;
    return this;
  }

   /**
   * Get anschriftUnbekannt
   * @return anschriftUnbekannt
  **/
  @Schema(description = "")
  public Boolean isAnschriftUnbekannt() {
    return anschriftUnbekannt;
  }

  public void setAnschriftUnbekannt(Boolean anschriftUnbekannt) {
    this.anschriftUnbekannt = anschriftUnbekannt;
  }

  public AnschriftType sperrvermerk(Boolean sperrvermerk) {
    this.sperrvermerk = sperrvermerk;
    return this;
  }

   /**
   * Get sperrvermerk
   * @return sperrvermerk
  **/
  @Schema(description = "")
  public Boolean isSperrvermerk() {
    return sperrvermerk;
  }

  public void setSperrvermerk(Boolean sperrvermerk) {
    this.sperrvermerk = sperrvermerk;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnschriftType anschriftType = (AnschriftType) o;
    return Objects.equals(this.gemeindeschluessel, anschriftType.gemeindeschluessel) &&
        Objects.equals(this.hausnummer, anschriftType.hausnummer) &&
        Objects.equals(this.buchstabeHausnummer, anschriftType.buchstabeHausnummer) &&
        Objects.equals(this.teilnummerHausnummer, anschriftType.teilnummerHausnummer) &&
        Objects.equals(this.ort, anschriftType.ort) &&
        Objects.equals(this.ortsteil, anschriftType.ortsteil) &&
        Objects.equals(this.postleitzahl, anschriftType.postleitzahl) &&
        Objects.equals(this.stockwerk, anschriftType.stockwerk) &&
        Objects.equals(this.appartmentnummer, anschriftType.appartmentnummer) &&
        Objects.equals(this.strasse, anschriftType.strasse) &&
        Objects.equals(this.wohnungsgeber, anschriftType.wohnungsgeber) &&
        Objects.equals(this.zusatz, anschriftType.zusatz) &&
        Objects.equals(this.staat, anschriftType.staat) &&
        Objects.equals(this.anschriftUnbekannt, anschriftType.anschriftUnbekannt) &&
        Objects.equals(this.sperrvermerk, anschriftType.sperrvermerk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gemeindeschluessel, hausnummer, buchstabeHausnummer, teilnummerHausnummer, ort, ortsteil, postleitzahl, stockwerk, appartmentnummer, strasse, wohnungsgeber, zusatz, staat, anschriftUnbekannt, sperrvermerk);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnschriftType {\n");
    
    sb.append("    gemeindeschluessel: ").append(toIndentedString(gemeindeschluessel)).append("\n");
    sb.append("    hausnummer: ").append(toIndentedString(hausnummer)).append("\n");
    sb.append("    buchstabeHausnummer: ").append(toIndentedString(buchstabeHausnummer)).append("\n");
    sb.append("    teilnummerHausnummer: ").append(toIndentedString(teilnummerHausnummer)).append("\n");
    sb.append("    ort: ").append(toIndentedString(ort)).append("\n");
    sb.append("    ortsteil: ").append(toIndentedString(ortsteil)).append("\n");
    sb.append("    postleitzahl: ").append(toIndentedString(postleitzahl)).append("\n");
    sb.append("    stockwerk: ").append(toIndentedString(stockwerk)).append("\n");
    sb.append("    appartmentnummer: ").append(toIndentedString(appartmentnummer)).append("\n");
    sb.append("    strasse: ").append(toIndentedString(strasse)).append("\n");
    sb.append("    wohnungsgeber: ").append(toIndentedString(wohnungsgeber)).append("\n");
    sb.append("    zusatz: ").append(toIndentedString(zusatz)).append("\n");
    sb.append("    staat: ").append(toIndentedString(staat)).append("\n");
    sb.append("    anschriftUnbekannt: ").append(toIndentedString(anschriftUnbekannt)).append("\n");
    sb.append("    sperrvermerk: ").append(toIndentedString(sperrvermerk)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
