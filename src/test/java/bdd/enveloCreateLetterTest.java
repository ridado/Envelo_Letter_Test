package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/features/envelo-create-letter.feature",
        plugin = {"pretty", "html:out/report.html"}
)

public class enveloCreateLetterTest {
}
