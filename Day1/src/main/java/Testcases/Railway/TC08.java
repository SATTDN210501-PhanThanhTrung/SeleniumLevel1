import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends Before{
    @Test
    public void TC08() {
        System.out.println("User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login("trungphan123@gmail.com", Constant.PASSWORD).getErrorLogMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
