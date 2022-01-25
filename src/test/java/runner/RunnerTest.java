package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        plugin = {"json:target/report/cucumber.json"},
        glue = "steps",
        publish = true,
        tags = "@regressivo"

)
public class RunnerTest {
    @AfterClass
    public static void report() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10"))
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
    }
}
