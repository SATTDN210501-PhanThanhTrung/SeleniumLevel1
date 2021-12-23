import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC15 extends Before{
    @Test
    public void TC15(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookticketPage bookticketPage = homePage.gotoBookticet();
        bookticketPage.BookTicket();
        System.out.println( Constant.WEBDRIVER.findElement(By.xpath("//div[@class='DivTable']")).getText());
    }
}
