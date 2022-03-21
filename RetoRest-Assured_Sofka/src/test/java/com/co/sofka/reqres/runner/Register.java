package com.co.sofka.reqres.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/register/register.feature",
        glue = "com.co.sofka.reqres.stepdefinition.reqres.register",
        tags = "@RegisterSuccesfully",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class Register {
}
