/*
 * Address-Service API
 * ## Zentraler Service für Adressen.  Weitere Informationen zu diesem Service erhalten Sie hier:  [Geodatenpool / Geodateninfrastruktur in Wilma](https://wilma.muenchen.de/workspaces/geodatenpool-gdp-geodateninfrastruktur-gdi)  Über die \"Try it out\" Funktion können direkt aus dieser Dokumentation Test-Anfragen gesendet werden.   ### Allgemeine Informationen  * Die maximale Ergebnismenge beträgt 10.000 Elemente  * Sortierung standardmäßig über Scoring (Empfohlen)  * Für die Anbindung einer EAI aus dem Datacenter muss die EAI-URL genutzt werden (Siehe unten Servers)   ### DEPRECATED - Bitte auf Version 2 migrieren  
 *
 * OpenAPI spec version: V1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.muenchendigital.digiwf.address.service.integration.gen.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * GeoPoint
 */


public class GeoPoint {
  @JsonProperty("lat")
  private Double lat = null;

  @JsonProperty("lon")
  private Double lon = null;

  @JsonProperty("geohash")
  private String geohash = null;

  @JsonProperty("fragment")
  private Boolean fragment = null;

  public GeoPoint lat(Double lat) {
    this.lat = lat;
    return this;
  }

   /**
   * Get lat
   * @return lat
  **/
  @Schema(description = "")
  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public GeoPoint lon(Double lon) {
    this.lon = lon;
    return this;
  }

   /**
   * Get lon
   * @return lon
  **/
  @Schema(description = "")
  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public GeoPoint geohash(String geohash) {
    this.geohash = geohash;
    return this;
  }

   /**
   * Get geohash
   * @return geohash
  **/
  @Schema(description = "")
  public String getGeohash() {
    return geohash;
  }

  public void setGeohash(String geohash) {
    this.geohash = geohash;
  }

  public GeoPoint fragment(Boolean fragment) {
    this.fragment = fragment;
    return this;
  }

   /**
   * Get fragment
   * @return fragment
  **/
  @Schema(description = "")
  public Boolean isFragment() {
    return fragment;
  }

  public void setFragment(Boolean fragment) {
    this.fragment = fragment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoPoint geoPoint = (GeoPoint) o;
    return Objects.equals(this.lat, geoPoint.lat) &&
        Objects.equals(this.lon, geoPoint.lon) &&
        Objects.equals(this.geohash, geoPoint.geohash) &&
        Objects.equals(this.fragment, geoPoint.fragment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon, geohash, fragment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoPoint {\n");
    
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("    geohash: ").append(toIndentedString(geohash)).append("\n");
    sb.append("    fragment: ").append(toIndentedString(fragment)).append("\n");
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
