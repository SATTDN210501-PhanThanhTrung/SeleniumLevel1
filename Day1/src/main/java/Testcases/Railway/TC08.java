import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();

        System.out.println("1.Go to RailWay web");
        homePage.open();

        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();

        System.out.println("3.Enter username and password of account hasn't been activated.");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "User can login with an account hasn't been activated");
    }
}
