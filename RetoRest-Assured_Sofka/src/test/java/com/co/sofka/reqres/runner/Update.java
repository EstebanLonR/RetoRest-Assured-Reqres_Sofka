package com.co.sofka.reqres.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/update/update.feature",
        glue = "com.co.sofka.reqres.stepdefinition.reqres.update",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class Update {
}
