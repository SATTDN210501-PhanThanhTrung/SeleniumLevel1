package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";
    public static final String USERNAME = "phantrung1@gmail.com";
    public static final String PASSWORD = "123456789";
    public static final String EMPTY="";
    public static void scrollIntoview() {
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Web hosting by Somee.com')]"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
