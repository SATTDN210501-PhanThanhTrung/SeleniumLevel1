import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test
    public void TC16() {
        HomePage homePage = new HomePage();
        LoginPage loginPage=new LoginPage();
        homePage.open();
        System.out.println("2.Go to Login Page.");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoMyTicket();
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']/tbody/tr[" + i + "]/td[9]"));
            int count = Integer.parseInt(element.getText());
            sum += count;

        }
        System.out.println(sum);
    }
}
