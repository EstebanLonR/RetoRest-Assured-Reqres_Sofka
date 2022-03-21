package com.co.sofka.reqres.stepdefinition.reqres.register;

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
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RegisterStepDefinition extends SetUpServices {
    private Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private Response response;
    private RequestSpecification requestSpecification;

    @Given("el usario se encuentra en la pagina de registro con el correo {string} y password {string}")
    public void elUsarioSeEncuentraEnLaPaginaDeRegistroConElCorreoYPassword(String email, String password) {
        try {
            generalSetUp();
            requestSpecification = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(getJsonFromFile(PATH_GENERAL_JSON + "/register.json")
                            .replace("{email}", email)
                            .replace("{password}", password));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @When("el usuario hace una peticion de respuesta")
    public void elUsuarioHaceUnaPeticionDeRespuesta() {
        try {
            response = requestSpecification.when()
                    .post(REGISTER_RESOURCE);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el sistema debera mostrarle un codigo de respuesta exitoso junto un id y un token")
    public void elSistemaDeberaMostrarleUnCodigoDeRespuestaExitosoJuntoUnIdYUnToken() {
        try {
            response.then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", Matchers.notNullValue(),
                            "id", Matchers.isA(int.class));


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
