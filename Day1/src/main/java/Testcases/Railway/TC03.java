import Common.Constant;
import Common.Untilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test(description = "Verify that user can't login when enters vaild Username and invalid Password")
    public void TC03() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();

        System.out.println("1.Go to RailWay web");
        homePage.open();

        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();

        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Untilities.generateRandomString());

        String actualMsg = loginPage.getErrorLogMsg();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
