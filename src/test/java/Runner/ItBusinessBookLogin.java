package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\Friday\\IdeaProjects\\Playwright_Project\\src\\test\\java\\Runner\\ItBusinessBookLogin.feature",
        glue="Runner",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        plugin={"html:Reports/loginIT.html"}
)
public class ItBusinessBookLogin extends AbstractTestNGCucumberTests {


}
