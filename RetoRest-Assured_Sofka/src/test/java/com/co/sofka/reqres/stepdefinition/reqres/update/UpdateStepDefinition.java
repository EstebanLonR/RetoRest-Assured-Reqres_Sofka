package com.co.sofka.reqres.stepdefinition.reqres.update;

import com.co.sofka.reqres.stepdefinition.setup.services.SetUpServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class UpdateStepDefinition extends SetUpServices {
    private Logger LOGGER = Logger.getLogger(UpdateStepDefinition.class);
    private Response response;
    private RequestSpecification requestSpecification;

    @Given("el usuario se encuentra en el apartado de actualizacion con el nombre {string} y el job {string}")
    public void elUsuarioSeEncuentraEnElApartadoDeActualizacionConElNombreYElJob(String name, String job) {
        try {
            generalSetUp();
            requestSpecification = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(getJsonFromFile(PATH_GENERAL_JSON + "/update.json")
                            .replace("{name}", name).replace("{job}", job));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());

        }
    }

    @When("el usuario envia una peticion de respuesta")
    public void elUsuarioEnviaUnaPeticionDeRespuesta() {
        try {
            response = requestSpecification
                    .put(UPDATE_RESOURCE);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Then("el sistema debera mostrarle un codigo de respuesta exitoso junto a sus atributos actualizados")
    public void elSistemaDeberaMostrarleUnCodigoDeRespuestaExitosoJuntoASusAtributosActualizados() {
        try {
            response.then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("name", Matchers.hasToString("morpheus"),
                            "job", Matchers.hasToString("zion resident"));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
