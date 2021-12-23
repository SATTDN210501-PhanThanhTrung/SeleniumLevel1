import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends Before{
    @Test
    public void TC11() {
        System.out.println("User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        registerPage.register("trungphan@gmail.com", "", "", "");
        String actualMsg1 = registerPage.getErrorRegMsg();
        String actualMsg2 = registerPage.getErrorRegPW();
        String actualMsg3 = registerPage.getErrorRegPID();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsg2 = "Invalid password length";
        String expectedMsg3 = "Invalid ID length";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg3, expectedMsg3, "Error message is not displayed as expected");
    }
}
