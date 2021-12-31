import Common.Constant;
import Common.Untilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    @Test(description = "User can't create account with an already in-use email")
    public void TC10() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1.Go to RailWay web");
        homePage.open();

        System.out.println("2.Go to Register Page");
        homePage.gotoRegister();

        System.out.println("3.Enter information of the created account in Pre-condition");
        System.out.println("4.Click on Register button");
        registerPage.register(Constant.USERNAME, Constant.PASSWORD,
                Constant.PASSWORD, Untilities.generateRandomString());

        String actualMsg = registerPage.getErrorAlreadyEmailMsg();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
