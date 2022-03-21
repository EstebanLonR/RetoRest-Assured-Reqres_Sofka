package com.co.sofka.reqres.stepdefinition.setup.services;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.co.sofka.reqres.util.Log4j2Values.LOG4J_PROPERTIES_FILE_PATH;

public class SetUpServices {
    //Rutas PATHS
    private final String BASE_URI = "https://reqres.in";
    private final String BASE_PATH = "/api";
    protected final String REGISTER_RESOURCE = "/register";
    protected final String UPDATE_RESOURCE = "/users/2";
    //Ruta archivos JSON
    protected static final String PATH_GENERAL_JSON = "src/main/resources/json";

    protected void setUpLog4j() {
        PropertyConfigurator.configure(System.getProperty("user.dir")  + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void basesSetUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
    }

    protected void generalSetUp() {
        setUpLog4j();
        basesSetUp();
    }

    //Traer body desde un archivo .json
    protected String getJsonFromFile(String fileroute) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileroute)));
    }
}
