import java.util.Random;
import java.util.Scanner;

public class Untilities {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhập độ dài của chuỗi bạn cần random: ");
        int targetStringLength = Integer.parseInt(sc.nextLine());
        generateRandomString(targetStringLength);
    }

    private static void generateRandomString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString+"@gmail.com");

    }

}
