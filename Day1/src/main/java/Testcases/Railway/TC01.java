import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    @Test(description = "Verify that user can login successfully when enters vaild Username and Password")
    public void TC01() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
