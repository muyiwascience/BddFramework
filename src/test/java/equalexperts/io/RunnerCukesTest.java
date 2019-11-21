package equalexperts.io;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false
        ,monochrome = true
        ,plugin = {"pretty",
            "html:target/test-report/report-html",
            "json:target/test-report/report-json.json",
            "junit:target/test-report/report-xml.xml"}
        ,strict = false
        ,features = {"src/test/resources"}
        ,snippets = SnippetType.CAMELCASE
        ,tags = {"@Regression"}
)
public class RunnerCukesTest {
}
