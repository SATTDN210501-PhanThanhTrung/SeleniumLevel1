import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends Before{
    @Test
    public void TC09() {
        System.out.println("User can't change password when New Password and Confirm Password are different.");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("trung123@gmail.com", "trungphan");
        ChangePassWord changePassWord = homePage.gotoChangePassword();
        changePassWord.changePassWord("trungphan", "1234512345", "1234512346");
        String actualMsg1 = changePassWord.getErrorChangePW();
        String actualMsg2 = changePassWord.getErrorDontMatch();
        String expectedMsg1 = "Password change failed. Please correct the errors and try again.";
        String expectedMsg2 = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
    }
}
