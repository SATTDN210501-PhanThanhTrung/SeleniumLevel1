import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends Before{
    @Test
    public void TC10() {
        System.out.println("User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegister();
        String actualMsg = registerPage.register("trungphan@gmail.com", "1234512345", "1234512345", "123456789").getErrorAlreadyEmail();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
