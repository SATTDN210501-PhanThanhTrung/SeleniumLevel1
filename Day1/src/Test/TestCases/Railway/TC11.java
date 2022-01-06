package Railway;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {

        System.out.println("1.Go to RailWay web");
        homePage.open();

        System.out.println("2.Go to Register Page");
        homePage.gotoRegister();

        System.out.println("3.Enter valid email address and leave other fields empty");
        registerPage.register(Utilities.generateRandomEmail(), "", "", "");

        System.out.println("4.Click on Register button");
        registerPage.clickRegisterButton();

        String actualMsg1 = registerPage.getErrorMsg();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg2 = registerPage.getErrorPassWordMsg();
        String expectedMsg2 = "Invalid password length";

        String actualMsg3 = registerPage.getErrorPIDMsg();
        String expectedMsg3 = "Invalid ID length";

        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg3, expectedMsg3, "Error message is not displayed as expected");
    }
}
