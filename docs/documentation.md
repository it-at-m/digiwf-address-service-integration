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

#### Error handling

If client-side errors, server-side errors or errors that cannot be assigned to either the client or the server occur
during the rest request within the service, an error response is returned to the caller via the event bus.

```json
{
  "message": "THE GENERIC ERROR MESSAGE"
}
```
