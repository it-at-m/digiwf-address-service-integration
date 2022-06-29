package io.muenchendigital.digiwf.address.service.integration.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ListAdressenMuenchenModel {

    private List<String> baublock;

    private List<String> erhaltungssatzung;

    private List<String> gemarkung;

    private List<String> kaminkehrerbezirk;

    private List<String> plz;

    private List<String> mittelschule;

    private List<String> grundschule;

    private List<String> polizeiinspektion;

    private List<Long> stimmbezirk;

    private List<Long> stimmkreis;

    private List<Long> wahlbezirk;

    private List<Long> wahlkreis;

    private List<String> stadtbezirk;

    private List<String> stadtbezirksteil;

    private List<String> stadtbezirksviertel;

    private String sort;

    private String sortdir;

    private Integer page;

    private Integer pagesize;

}
