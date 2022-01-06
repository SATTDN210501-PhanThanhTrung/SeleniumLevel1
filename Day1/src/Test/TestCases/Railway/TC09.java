package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.ChangePassWord;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePassWord changePassWord = new ChangePassWord();
    RegisterPage registerPage =new RegisterPage();

    @Test(description = "User can't change password when New Password and Confirm Password are different.")
    public void TC09() {

        System.out.println("Pre-Condition");
        homePage.open();
        homePage.gotoRegister();
        registerPage.register(Utilities.generateRandomEmail(), Constant.PASSWORD, Constant.PASSWORD, Utilities.generateRandomString());
        String useName = registerPage.getTextEmail().getAttribute("value");
        registerPage.clickRegisterButton();

        System.out.println("1.Navigate to Railway Website");
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();

        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(useName, Constant.PASSWORD);

        System.out.println("5.Go to Change PassWord Page");
        homePage.gotoChangePassword();

        System.out.println("6.Enter valid information into Current Password textbox but enter different information into NewPassword and ConfirmPassword");
        changePassWord.changePassWord(Constant.PASSWORD, Utilities.generateRandomString(), Utilities.generateRandomString());

        String actualMsg1 = changePassWord.getErrorChangePW();
        String expectedMsg1 = "Password change failed. Please correct the errors and try again.";

        String actualMsg2 = changePassWord.getErrorDontMatch();
        String expectedMsg2 = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
    }
}
