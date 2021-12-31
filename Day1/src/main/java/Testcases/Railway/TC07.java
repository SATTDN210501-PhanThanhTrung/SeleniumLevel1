import Common.Constant;
import Common.Untilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "Verify that user can register successfully when enters valid all infornmation")
    public static void TC07() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on Register tab");
        homePage.gotoRegister();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on Register button");
        registerPage.register(Untilities.generateRandomEmail(), Constant.PASSWORD, Constant.PASSWORD, Untilities.generateRandomString());

        String actualMsg = registerPage.getReConfirm();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Registration successfully message is not displayed as expected");
    }
}
