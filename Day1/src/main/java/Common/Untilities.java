package Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class Untilities {
    public static String generateRandomEmail() {
        return generateRandomString()+System.currentTimeMillis() + "@gmail.com";
    }

    public static String generateRandomString() {
        int targetStringLength = 8;
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void scrollIntoview() {
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Web hosting by Somee.com')]"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}

