import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends Before{
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
}
