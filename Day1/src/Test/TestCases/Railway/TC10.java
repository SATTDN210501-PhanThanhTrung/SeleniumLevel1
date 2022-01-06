package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account with an already in-use email")
    public void TC10() {

        System.out.println("Pre-Condition");
        homePage.open();
        homePage.gotoRegister();
        registerPage.register(Utilities.generateRandomEmail(), Constant.PASSWORD, Constant.PASSWORD, Utilities.generateRandomString());
        String useName = registerPage.getTextEmail().getAttribute("value");
        registerPage.clickRegisterButton();

        System.out.println("1.Go to RailWay web");
        System.out.println("2.Go to Register Page");
        homePage.gotoRegister();

        System.out.println("3.Enter information of the created account in Pre-condition");
        registerPage.register(useName, Constant.PASSWORD,
                Constant.PASSWORD, Utilities.generateRandomString());

        System.out.println("4.Click on Register button");
        registerPage.clickRegisterButton();

        String actualMsg = registerPage.getErrorAlreadyEmailMsg();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
