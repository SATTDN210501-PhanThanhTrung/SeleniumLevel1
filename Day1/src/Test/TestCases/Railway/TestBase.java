package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\src\\main\\resources\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
