import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase2 {
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\src\\main\\resources\\Executables\\geckodriver.exe");
        Constant.WEBDRIVER = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
