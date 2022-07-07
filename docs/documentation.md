## Documentation

Basically, two artifacts are available.
This is on the one hand the Spring-Boot-Starter `digiwf-address-service-integration-starter`
and on the other hand the service `digiwf-address-service-integration-service` which is provided as an
[Image](https://hub.docker.com/repository/docker/itatm/digiwf-address-service-integration-service).

### Spring-Boot-Starter

The usage of the starter is documented
in [quickstart.md](https://github.com/it-at-m/digiwf-address-service-integration#getting-started).

#### Error handling

The errors occurring during the rest request are divided into three error categories.
These are client-side errors, server-side errors and errors that cannot be assigned to either the client or the server.
Each of these three error categories is assigned its own exception, which is then thrown when the methods in the
repository classes `AdressenBundesweitRepository`, `AdressenMuenchenRepository` and `StrassenMuenchenRepository` are
called.

### Service provided as an image

The service is provided via Dockerhub as
an [Image](https://hub.docker.com/repository/docker/itatm/digiwf-address-service-integration-service).
The source code for the service can be found in
submodule [digiwf-okewo-integration-service](https://github.com/it-at-m/digiwf-ok.ewo-integration/tree/dev/digiwf-address-service-integration-service)
.

The requests to the address service are expected by the service over kafka event bus messages.
To provide the event bus functionality via kafka,
the [DigiWF Spring Cloudstream Utils](https://github.com/it-at-m/digiwf-spring-cloudstream-utils) are used.

#### Service Configuration

An example configuration can be found within the properties files.

* `application.yml`: `digiwf-address-service-integration-service/src/main/resources/application.yml`
* `application-local.yml`: `digiwf-address-service-integration-service/src/main/resources/application-local.yml`

The file `application.yml` contains the configuration according graceful shutdown, metrics, ports, ...

The file `application-local.yml` provides the event bus and address service relevant configuration.
The event bus configuration is implemented
according [DigiWF Spring Cloudstream Utils](https://github.com/it-at-m/digiwf-spring-cloudstream-utils#getting-started).

#### Service API usage

The address service requests have to be made via the element template defined in `addressServiceIntegration.json`.
The service and the template are providing eight types of requests.
The request type can be defined via the element template dropdown in field `Event Type`.

* `searchAdressenBundesweit`
* `checkAdresseMuenchen`
* `listAdressenMuenchen`
* `listAenderungenMuenchen`
* `searchAdressenMuenchen`
* `searchAdressenGeoMuenchen`
* `findStrasseByIdMuenchen`
* `listStrassenMuenchen`

For each request type, the payload has to be defined in the element templates request field as a JSON object.
The response is also an JSON object.
A crucial and mandatory JSON object attribute for a request is `eventType`.
This attribute is necessary for correct deserialization of the requests JSON payload within the integration service.

##### searchAdressenBundesweit

The following JSON object shows the example payload set at the element templates request field.

```json
{
  "eventType": "searchAdressenBundesweit",
  "query": "culpa incididunt occaecat ut",
  "plz": "conse",
  "ortsname": "culpa incididunt occaecat ut",
  "gemeindeschluessel": "culpa incididunt occaecat ut",
  "hausnummerfilter": "71564634",
  "hausnummerfilter": "48360614",
  "buchstabefilter": "mollit eu",
  "buchstabefilter": "anim sed quis consequat est",
  "sort": "culpa incididunt occaecat ut",
  "sortdir": "culpa incididunt occaecat ut",
  "page": "0",
  "pagesize": "20"
}
```

The response is as follows.

```json
{
  "page": {
    "size": 20,
    "number": 4711999,
    "totalElements": 86180198,
    "totalPages": -97380737,
    "numberOfElements": 11904480
  },
  "content": [
    {
      "score": 3966515.834937349,
      "adresse": {
        "adresse": "esse reprehenderit tempor",
        "hausnummer": -202318,
        "ortsname": "nostrud",
        "position": {
          "utm": {
            "north": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "east": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wgs": {
            "lat": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "lon": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "geohash": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "fragment": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        },
        "strasseId": "consectetur ",
        "strassenname": "dolore ad ullamco",
        "buchstabe": "dolor ",
        "geozuordnungen": {
          "postleitzahl": "in nulla nostrud sunt",
          "gemeinde": "Duis enim",
          "landesschluessel": "aute deserunt ad commodo do",
          "kreis": "anim labore voluptate su",
          "ortsteil": "ad magna qui",
          "ortsteilname": "Lorem",
          "regierungsbezirk": "E",
          "gemeindeschluessel": "ut deserunt amet in"
        }
      }
    },
    {
      "score": 8113004.566452727,
      "adresse": {
        "adresse": "labore occaecat",
        "hausnummer": -5232851,
        "ortsname": "aute ullamco ut ut cillum",
        "position": {
          "utm": {
            "north": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "east": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wgs": {
            "lat": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "lon": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "geohash": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "fragment": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        },
        "strasseId": "culpa i",
        "strassenname": "culpa",
        "buchstabe": "cillum ea occaecat reprehenderit",
        "geozuordnungen": {
          "postleitzahl": "qui pariatur non",
          "gemeinde": "iru",
          "landesschluessel": "pariatur",
          "kreis": "eu in sint dolore",
          "ortsteil": "nostrud mollit Ut nisi sunt",
          "ortsteilname": "id sint esse consequat",
          "regierungsbezirk": "veniam Duis voluptate",
          "gemeindeschluessel": "Lorem velit amet"
        }
      }
    }
  ]
}
```

##### checkAdresseMuenchen

The following JSON object shows the example payload set at the element templates request field.

```json
{
  "eventType": "checkAdresseMuenchen",
  "adresse": "culpa incididunt occaecat ut",
  "strassenname": "culpa incididunt occaecat ut",
  "strasseId": "303",
  "hausnummer": "culpa incididunt occaecat ut",
  "zusatz": "culpa incididunt occaecat ut",
  "plz": "culpa incididunt occaecat ut",
  "ortsname": "culpa incididunt occaecat ut",
  "gemeindeschluessel": "culpa incididunt occaecat ut"
}

```

The response is as follows.

```json
{
  "adressId": "nostrud",
  "adresse": "qui pariatur irure",
  "hausnummer": 88350807,
  "ortsname": "id dolor deserunt cupidatat dolore",
  "position": {
    "utm": {
      "north": -33535251.057741977,
      "east": 57590168.9756417
    },
    "wgs": {
      "lat": -26620807.119553417,
      "lon": 76802579.26506698,
      "geohash": "consequat irure occaecat",
      "fragment": true
    }
  },
  "strasseId": "Lorem aliquip in",
  "strassenname": "cupidatat officia ullamco Lorem Ut",
  "strassennameAbgekuerzt": "nisi aliqua enim elit a",
  "strassennameKurz": "voluptate nisi",
  "wirkung": {
    "status": "AKTIV",
    "vorgang": "UMNUMMERIERUNG",
    "wirkungsdatum": "1990-01-27"
  },
  "buchstabe": "reprehenderit cillum sunt ad",
  "ehemaligeAdresse": "eiusmod non magna consectetur",
  "geozuordnungen": {
    "baublock": "pariatur reprehenderit",
    "erhaltungssatzung": "nulla velit",
    "gemarkung": "in esse adipisicing",
    "grundschule": "ut non irure nisi",
    "kaminkehrerbezirk": "consequat ex",
    "mittelschule": "adipisicing offici",
    "parklizenzgebietId": -94121994,
    "parklizenzgebietName": "tempor deserunt consectetur",
    "polizeiinspektion": "Lorem sunt",
    "postleitzahl": "in officia deserunt esse sit",
    "verwaltungszuteilung": {
      "gemeinde": "culpa consectetur quis exercitation sed",
      "landesschluessel": "sint in ullamco",
      "kreis": "culpa sit dolore adipisicing",
      "ortsteil": "non",
      "regierungsbezirk": "est in sint",
      "stadtbezirk": "pariatur sit non Excepteur",
      "stadtbezirksteil": "sit non anim laboris",
      "stadtbezirksviertel": "cillum non cup",
      "gemeindeschluessel": "commodo nisi consequat ipsum"
    },
    "wahleinteilungen": {
      "stimmbezirk": 83357636,
      "stimmkreis": 88488065,
      "wahlkreis": 18979577,
      "wahlbezirk": 93264949
    }
  }
}
```

##### listAdressenMuenchen

The following JSON object shows the example payload set at the element templates request field.

```json
{
  "eventType": "listAdressenMuenchen",
  "baublock": "amet Lorem fugiat",
  "erhaltungssatzung": "amet Lorem fugiat",
  "gemarkung": "amet Lorem fugiat",
  "kaminkehrerbezirk": "amet Lorem fugiat",
  "plz": "amet Lorem fugiat",
  "mittelschule": "amet Lorem fugiat",
  "grundschule": "amet Lorem fugiat",
  "polizeiinspektio": "amet Lorem fugiat",
  "polizeiinspektion": "eu incididunt",
  "stimmbezirk": -93305045,
  "stimmkreis": -93305045,
  "wahlbezirk": -93305045,
  "wahlkreis": -93305045,
  "stadtbezirk": "amet Lorem fugiat",
  "stadtbezirksteil": "amet Lorem fugiat",
  "stadtbezirksviertel": "amet Lorem fugiat",
  "sort": "culpa incididunt occaecat ut",
  "sortdir": "culpa incididunt occaecat ut",
  "page": 0,
  "pagesize": 20
}

```

The response is as follows.

```json
{
  "page": {
    "size": 20,
    "number": 15947864,
    "totalElements": 47352921,
    "totalPages": 44413736,
    "numberOfElements": -62364652
  },
  "content": [
    {
      "score": 92866295.74778003,
      "adresse": {
        "adressId": "ad cillum",
        "adresse": "in adipisicing",
        "hausnummer": -55290609,
        "ortsname": "ut",
        "position": {
          "utm": {
            "north": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "east": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wgs": {
            "lat": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "lon": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "geohash": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "fragment": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        },
        "strasseId": "minim anim non",
        "strassenname": "reprehenderit sed qu",
        "strassennameAbgekuerzt": "tempor do id sunt magna",
        "strassennameKurz": "elit tempor consectetur",
        "wirkung": {
          "status": "AKTIV",
          "vorgang": "EINZIEHUNG",
          "wirkungsdatum": "1965-01-17"
        },
        "buchstabe": "voluptate culpa",
        "ehemaligeAdresse": "proident cillum ad Ut",
        "geozuordnungen": {
          "baublock": "sit aliquip magna",
          "erhaltungssatzung": "qui fugiat",
          "gemarkung": "Duis consequat anim consectetur",
          "grundschule": "laborum nulla ipsum qui cupidatat",
          "kaminkehrerbezirk": "voluptate quis",
          "mittelschule": "culpa sit",
          "parklizenzgebietId": -91228677,
          "parklizenzgebietName": "occaecat labore proident",
          "polizeiinspektion": "culpa aliquip",
          "postleitzahl": "cillum aute",
          "verwaltungszuteilung": {
            "gemeinde": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "landesschluessel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "kreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "ortsteil": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "regierungsbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirksteil": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirksviertel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "gemeindeschluessel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wahleinteilungen": {
            "stimmbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stimmkreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "wahlkreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "wahlbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        }
      }
    },
    {
      "score": -55518562.8487318,
      "adresse": {
        "adressId": "exercitation veniam qui esse do",
        "adresse": "id sunt",
        "hausnummer": -50110105,
        "ortsname": "eiusmod culpa aliquip labor",
        "position": {
          "utm": {
            "north": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "east": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wgs": {
            "lat": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "lon": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "geohash": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "fragment": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        },
        "strasseId": "cupidatat ad sed est non",
        "strassenname": "deserunt nulla cillum ex aute",
        "strassennameAbgekuerzt": "est Duis dolore velit",
        "strassennameKurz": "occaecat Ut",
        "wirkung": {
          "status": "HISTORISCH",
          "vorgang": "UMNUMMERIERUNG",
          "wirkungsdatum": "1943-07-28"
        },
        "buchstabe": "amet ",
        "ehemaligeAdresse": "nisi aliqua cillum nostrud",
        "geozuordnungen": {
          "baublock": "labore culpa et Duis",
          "erhaltungssatzung": "sunt laborum",
          "gemarkung": "veniam dolor",
          "grundschule": "exercitation qui nisi",
          "kaminkehrerbezirk": "proident Duis",
          "mittelschule": "cillum",
          "parklizenzgebietId": 59096451,
          "parklizenzgebietName": "Lorem anim fugiat",
          "polizeiinspektion": "in do",
          "postleitzahl": "la",
          "verwaltungszuteilung": {
            "gemeinde": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "landesschluessel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "kreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "ortsteil": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "regierungsbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirksteil": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stadtbezirksviertel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "gemeindeschluessel": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          },
          "wahleinteilungen": {
            "stimmbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "stimmkreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "wahlkreis": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            },
            "wahlbezirk": {
              "value": "<Error: Too many levels of nesting to fake this schema>"
            }
          }
        }
      }
    }
  ]
}
```

#### Error handling

If client-side errors, server-side errors or errors that cannot be assigned to either the client or the server occur
during the rest request within the service, an error response is returned to the caller via the event bus.

```json
{
  "message": "THE GENERIC ERROR MESSAGE"
}
```
