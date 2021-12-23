import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends Before{
    @Test
    public void TC02() {
        System.out.println("Verify that user User can't login with blank Username textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        registerPage.register("", "123456789", "123456789", "1234512345");
        String actualMsg1 = registerPage.getErrorRegEmail();
        String actualMsg2 = registerPage.getErrorRegMsg();
        String expectedMsg = "Invalid email length";
        String expectedMsg2 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg1, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");
    }
}
