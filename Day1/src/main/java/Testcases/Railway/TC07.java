import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends Before{
    @Test
    public void TC07() {
        System.out.println("Verify that user can register successfully when enters valid all infornmation");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        registerPage.register("mitom2019@gmail.com", "1234512345", "1234512345", "123456789");
        String actualMsg = registerPage.getReConfirm();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Registration successfully message is not displayed as expected");
    }
}
