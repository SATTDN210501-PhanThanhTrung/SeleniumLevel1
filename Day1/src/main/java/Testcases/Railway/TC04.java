import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "User is redirected to Book ticket page after logging in")
    public void TC04() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();
        BookticketPage bookticketPage=new BookticketPage();

        System.out.println("1. Go to RailWay web");
        homePage.open();

        System.out.println("2. Go to Bookticket Page");
        homePage.gotoBookticet();

        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("5.Go to Bookticket Page");
        homePage.gotoBookticet();

        String actualMsg = bookticketPage.getBookticketTitle();
        String expectedMsg = "Book ticket";

        Assert.assertEquals(actualMsg, expectedMsg, "YUser can't redirected to Book ticket page after logging in");
    }
}
