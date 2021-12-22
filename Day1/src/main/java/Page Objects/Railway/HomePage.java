import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    private final By createAcc = By.xpath("//a[contains(text(),'create an account')]");

    protected WebElement getLinkCreateAcc() {
        return Constant.WEBDRIVER.findElement(createAcc);
    }

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public HomePage createAccount() {
        this.getLinkCreateAcc().click();
        return new HomePage();
    }

}
