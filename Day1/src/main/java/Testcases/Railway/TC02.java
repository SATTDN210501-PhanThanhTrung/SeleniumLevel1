import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    @Test(description = "Verify that user User can't login with blank Username textbox")
    public void TC02() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to Railway Website");
        homePage.open();
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();
        System.out.println("3. User doesn't type any words into Username textbox but enter valid information into Password textbox ");
        System.out.println("4. Click on Login button");
        loginPage.login("",Constant.PASSWORD);
        String actualMsg1 = loginPage.getErrorLogMsg();
        String actualMsg2 = loginPage.getErrorEmailMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        String expectedMsg2 = "You must specify a username.";
        Assert.assertEquals(actualMsg1, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
    }
}
