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
import io.muenchendigital.digiwf.address.service.integration.gen.model.AdresseGeozuordnungen;
import io.muenchendigital.digiwf.address.service.integration.gen.model.Position;
import io.muenchendigital.digiwf.address.service.integration.gen.model.Wirkung;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * Adresse aus Strasse, Hausnummer, Buchstabe usw.
 */
@Schema(description = "Adresse aus Strasse, Hausnummer, Buchstabe usw.")

public class Adresse {
  @JsonProperty("adressId")
  private String adressId = null;

  @JsonProperty("buchstabe")
  private String buchstabe = null;

  @JsonProperty("ehemaligeAdresse")
  private String ehemaligeAdresse = null;

  @JsonProperty("hausnummer")
  private Long hausnummer = null;

  @JsonProperty("ortsname")
  private String ortsname = null;

  @JsonProperty("strasseId")
  private Long strasseId = null;

  @JsonProperty("strassenname")
  private String strassenname = null;

  @JsonProperty("strassennameKurz")
  private String strassennameKurz = null;

  @JsonProperty("position")
  private Position position = null;

  @JsonProperty("geozuordnungen")
  private AdresseGeozuordnungen geozuordnungen = null;

  @JsonProperty("wirkung")
  private Wirkung wirkung = null;

  public Adresse adressId(String adressId) {
    this.adressId = adressId;
    return this;
  }

   /**
   * Get adressId
   * @return adressId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getAdressId() {
    return adressId;
  }

  public void setAdressId(String adressId) {
    this.adressId = adressId;
  }

  public Adresse buchstabe(String buchstabe) {
    this.buchstabe = buchstabe;
    return this;
  }

   /**
   * Get buchstabe
   * @return buchstabe
  **/
  @Schema(description = "")
  public String getBuchstabe() {
    return buchstabe;
  }

  public void setBuchstabe(String buchstabe) {
    this.buchstabe = buchstabe;
  }

  public Adresse ehemaligeAdresse(String ehemaligeAdresse) {
    this.ehemaligeAdresse = ehemaligeAdresse;
    return this;
  }

   /**
   * Get ehemaligeAdresse
   * @return ehemaligeAdresse
  **/
  @Schema(description = "")
  public String getEhemaligeAdresse() {
    return ehemaligeAdresse;
  }

  public void setEhemaligeAdresse(String ehemaligeAdresse) {
    this.ehemaligeAdresse = ehemaligeAdresse;
  }

  public Adresse hausnummer(Long hausnummer) {
    this.hausnummer = hausnummer;
    return this;
  }

   /**
   * Get hausnummer
   * @return hausnummer
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Long getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(Long hausnummer) {
    this.hausnummer = hausnummer;
  }

  public Adresse ortsname(String ortsname) {
    this.ortsname = ortsname;
    return this;
  }

   /**
   * Get ortsname
   * @return ortsname
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getOrtsname() {
    return ortsname;
  }

  public void setOrtsname(String ortsname) {
    this.ortsname = ortsname;
  }

  public Adresse strasseId(Long strasseId) {
    this.strasseId = strasseId;
    return this;
  }

   /**
   * Get strasseId
   * @return strasseId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Long getStrasseId() {
    return strasseId;
  }

  public void setStrasseId(Long strasseId) {
    this.strasseId = strasseId;
  }

  public Adresse strassenname(String strassenname) {
    this.strassenname = strassenname;
    return this;
  }

   /**
   * Get strassenname
   * @return strassenname
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getStrassenname() {
    return strassenname;
  }

  public void setStrassenname(String strassenname) {
    this.strassenname = strassenname;
  }

  public Adresse strassennameKurz(String strassennameKurz) {
    this.strassennameKurz = strassennameKurz;
    return this;
  }

   /**
   * Get strassennameKurz
   * @return strassennameKurz
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getStrassennameKurz() {
    return strassennameKurz;
  }

  public void setStrassennameKurz(String strassennameKurz) {
    this.strassennameKurz = strassennameKurz;
  }

  public Adresse position(Position position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @NotNull
  @Valid
  @Schema(required = true, description = "")
  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Adresse geozuordnungen(AdresseGeozuordnungen geozuordnungen) {
    this.geozuordnungen = geozuordnungen;
    return this;
  }

   /**
   * Get geozuordnungen
   * @return geozuordnungen
  **/
  @Valid
  @Schema(description = "")
  public AdresseGeozuordnungen getGeozuordnungen() {
    return geozuordnungen;
  }

  public void setGeozuordnungen(AdresseGeozuordnungen geozuordnungen) {
    this.geozuordnungen = geozuordnungen;
  }

  public Adresse wirkung(Wirkung wirkung) {
    this.wirkung = wirkung;
    return this;
  }

   /**
   * Get wirkung
   * @return wirkung
  **/
  @NotNull
  @Valid
  @Schema(required = true, description = "")
  public Wirkung getWirkung() {
    return wirkung;
  }

  public void setWirkung(Wirkung wirkung) {
    this.wirkung = wirkung;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Adresse adresse = (Adresse) o;
    return Objects.equals(this.adressId, adresse.adressId) &&
        Objects.equals(this.buchstabe, adresse.buchstabe) &&
        Objects.equals(this.ehemaligeAdresse, adresse.ehemaligeAdresse) &&
        Objects.equals(this.hausnummer, adresse.hausnummer) &&
        Objects.equals(this.ortsname, adresse.ortsname) &&
        Objects.equals(this.strasseId, adresse.strasseId) &&
        Objects.equals(this.strassenname, adresse.strassenname) &&
        Objects.equals(this.strassennameKurz, adresse.strassennameKurz) &&
        Objects.equals(this.position, adresse.position) &&
        Objects.equals(this.geozuordnungen, adresse.geozuordnungen) &&
        Objects.equals(this.wirkung, adresse.wirkung);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adressId, buchstabe, ehemaligeAdresse, hausnummer, ortsname, strasseId, strassenname, strassennameKurz, position, geozuordnungen, wirkung);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Adresse {\n");
    
    sb.append("    adressId: ").append(toIndentedString(adressId)).append("\n");
    sb.append("    buchstabe: ").append(toIndentedString(buchstabe)).append("\n");
    sb.append("    ehemaligeAdresse: ").append(toIndentedString(ehemaligeAdresse)).append("\n");
    sb.append("    hausnummer: ").append(toIndentedString(hausnummer)).append("\n");
    sb.append("    ortsname: ").append(toIndentedString(ortsname)).append("\n");
    sb.append("    strasseId: ").append(toIndentedString(strasseId)).append("\n");
    sb.append("    strassenname: ").append(toIndentedString(strassenname)).append("\n");
    sb.append("    strassennameKurz: ").append(toIndentedString(strassennameKurz)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    geozuordnungen: ").append(toIndentedString(geozuordnungen)).append("\n");
    sb.append("    wirkung: ").append(toIndentedString(wirkung)).append("\n");
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
