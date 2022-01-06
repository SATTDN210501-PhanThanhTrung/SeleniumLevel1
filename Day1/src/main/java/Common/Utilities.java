package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilities {
    public static String generateRandomEmail() {
        return generateRandomString() + System.currentTimeMillis() + "@gmail.com";
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

    public static void scrollIntoview(WebElement element) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getDayNextWeek() {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = currentDate.plusWeeks(1);
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        String temp = date.format(dateFormatter);
        String[] temp1 = temp.split("/");
        int month = Integer.parseInt(temp1[0]);
        int day = Integer.parseInt(temp1[1]);
        int year = Integer.parseInt(temp1[2]);
        String departDay = month + "/" + day + "/" + year;
        return departDay;
    }

}

