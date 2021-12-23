import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends Before{
    @Test
    public void TC17() {
        System.out.println("Verify that user is navigated to the Registrer page if clicking on the Create account link");
        HomePage homePage = new HomePage();
        homePage.open();
        String actualMsg = homePage.createAccount().getCreateAccout();
        String expectedMsg = "Create account";
        Assert.assertEquals(actualMsg, expectedMsg, "Navigated Register failed");

    }

}
