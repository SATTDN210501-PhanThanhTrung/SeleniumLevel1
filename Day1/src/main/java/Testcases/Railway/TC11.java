import Common.Constant;
import Common.Untilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        System.out.println("2.Go to Register Page");
        homePage.gotoRegister();
        System.out.println("3.Enter valid email address and leave other fields empty");
        System.out.println("4.Click on Register button");
        registerPage.register(Untilities.generateRandomEmail(), Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
        String actualMsg1 = registerPage.getErrorMsg();
        String actualMsg2 = registerPage.getErrorPassWordMsg();
        String actualMsg3 = registerPage.getErrorPIDMsg();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsg2 = "Invalid password length";
        String expectedMsg3 = "Invalid ID length";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg3, expectedMsg3, "Error message is not displayed as expected");
    }
}
