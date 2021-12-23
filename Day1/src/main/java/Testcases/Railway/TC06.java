import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends Before{
    @Test
    public void TC06() {
        System.out.println("User is redirected to Home page after logging out");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.logout();
        String actualMsg = homePage.getTextWelcomeHP();
        String expectedMsg = "Welcome to Safe Railway";
        Assert.assertEquals(actualMsg, expectedMsg, "You are not logged in");
    }
}
