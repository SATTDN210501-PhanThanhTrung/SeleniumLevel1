package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user can register successfully when enters valid all infornmation")
    public void TC07() {

        System.out.println("1.Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2.Click on Register tab");
        homePage.gotoRegister();

        System.out.println("3.Enter valid information into all fields");
        registerPage.register(Utilities.generateRandomEmail(), Constant.PASSWORD, Constant.PASSWORD, Utilities.generateRandomString());

        System.out.println("4.Click on Register button");
        registerPage.clickRegisterButton();

        String actualMsg = registerPage.getReConfirm();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Registration successfully message is not displayed as expected");
    }
}
