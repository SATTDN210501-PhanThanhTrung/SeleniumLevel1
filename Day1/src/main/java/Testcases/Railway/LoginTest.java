import org.openqa.selenium.WebElement;
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
        // Constant.WEBDRIVER.manage().window().maximize();
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
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }


    @Test
    public void TC02() {
        System.out.println("Verify that user User can't login with blank Username textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        HomePage actualMsg = registerPage.register("", "123456789", "123456789", "1234512345");
        String a1 = actualMsg.getErrorEmail();
        String a2 = actualMsg.getErrorMsg();
        String expectedMsg = "Invalid email length";
        String expectedMsg2 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(a1, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(a2, expectedMsg2, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("Verify that user can't login when enters vaild Username and invalid Password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, "abbcbcbcbc").getErrorLogMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookticketPage bookticketPage = homePage.gotoBookticet();
        String actualMsg = bookticketPage.getTextBookticket();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg, "You are not logged in");
    }

    @Test
    public void TC05() throws InterruptedException {
        System.out.println("System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constant.USERNAME, "abbcbcbcbc");
            WebElement email = loginPage.getTxtUserName();
            email.clear();
            Thread.sleep(1000);
            if (i == 3) {
                String actualMsg = homePage.getErrorLogMsg();
                String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
                Assert.assertEquals(actualMsg, expectedMsg, "Error message is not same");
            }
        }


    }

    @Test
    public void TC07() {
        System.out.println("Verify that user can register successfully when enters valid all infornmation");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        String actualMsg = registerPage.register("mitom2018@gmail.com", "1234512345", "1234512345", "123456789").getReConfirm();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Registration successfully message is not displayed as expected");
    }

    @Test
    public void TC17() {
        System.out.println("Verify that user is navigated to the Registrer page if clicking on the Create account link");
        HomePage homePage = new HomePage();
        homePage.open();
        String actualMsg = homePage.createAccount().getCreateAccout();
        String expectedMsg = "Create account";
        Assert.assertEquals(actualMsg, expectedMsg, "Navigated Register failed");
    }


}
