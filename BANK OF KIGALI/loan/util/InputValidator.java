package loan.util;

public class InputValidator {

    public static boolean isValidAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
}