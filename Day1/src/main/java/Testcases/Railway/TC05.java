import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends Before{
    @Test
    public void TC05() throws InterruptedException {
        System.out.println("System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constant.USERNAME, "abbcbcbcbc");
            WebElement email = loginPage.txtUserName;
            email.clear();
            Thread.sleep(1000);
            if (i == 3) {
                String actualMsg = homePage.getErrorLogMsg();
                String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
                Assert.assertEquals(actualMsg, expectedMsg, "Error message is not same");
            }
        }


    }
}
