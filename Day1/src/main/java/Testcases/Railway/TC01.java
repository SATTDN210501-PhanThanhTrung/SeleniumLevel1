import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends Before{
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
}
