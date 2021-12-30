import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "User is redirected to Home page after logging out")
    public void TC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("5.Go to Contact Page");
        homePage.gotoContact();
        System.out.println("6. Click on Log out tab");
        homePage.logout();
        String actualMsg = homePage.getTextWelcomeHP();
        String expectedMsg = "Welcome to Safe Railway";
        Assert.assertEquals(actualMsg, expectedMsg, "You are not logged in");
    }
}
