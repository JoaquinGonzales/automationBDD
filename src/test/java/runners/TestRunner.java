package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {
                "pretty",                                       // Output legible en consola
                "html:target/cucumber-reports.html",            // Reporte HTML
                "json:target/cucumber.json",                    // Reporte JSON
                "junit:target/cucumber.xml"                     // Reporte JUnit XML
        },
        monochrome = true
)
public class TestRunner {
}