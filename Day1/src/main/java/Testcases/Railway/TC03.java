import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends Before{
    @Test
    public void TC03() {
        System.out.println("Verify that user can't login when enters vaild Username and invalid Password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = new LoginPage();
//        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, "abbcbcbcbc").getErrorLogMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
