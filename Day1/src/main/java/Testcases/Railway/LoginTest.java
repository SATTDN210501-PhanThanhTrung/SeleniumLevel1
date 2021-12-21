
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
//        ((JavascriptExecutor)
//                Constant.WEBDRIVER).executeScript ("window.scrollTo( 0, document.body.scrollHeight)");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        //Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("Verify that user can login successfully when enters vaild Username and Password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Login failed");
    }

    @Test
    public void TC02() {
        System.out.println("Verify that user can register successfully when enters valid all infornmation");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        String actualMsg = registerPage.register("mitom2016@gmail.com", "1234512345", "1234512345", "123456789").getReConfirm();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Register failed");
    }

    @Test
    public void TC03() {
        System.out.println("Verify that user is navigated to the Registrer page if clicking on the Create account link");
        HomePage homePage = new HomePage();
        homePage.open();
        String actualMsg = homePage.createAccount().getCreateAccout();
        String expectedMsg = "Create account";
        Assert.assertEquals(actualMsg, expectedMsg, "Navigated Register failed");
    }
}