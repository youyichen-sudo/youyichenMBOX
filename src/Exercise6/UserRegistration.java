package Exercise6;

import java.util.Scanner;
import java.time.LocalDate;

public class UserRegistration {
    String fullName;
    String email;
    String dob;
    String cardExpiryDate;
    String cardProvider;
    String cardNumber;
    int cvv;

    boolean emailValid, ageValid, cardNumberValid, cardStillValid, validCVV;
    boolean minor, minorAndBirthday;

    double VIP_BASE_FEE = 100.0;

    Scanner sc = new Scanner(System.in);

    public void registerUser() {
        System.out.println("Let's start registration. Please enter your details.");

        System.out.print("Full Name: ");
        fullName = sc.nextLine();

        System.out.print("Email Address: ");
        email = sc.nextLine();

        System.out.println("Checking email...");
        emailValid = analyseEmail(email);

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        dob = sc.nextLine();

        System.out.println("Checking age...");
        ageValid = analyseAge(dob);
        ageValid = analyseAge(dob); // 学生重复写了一次，正常作业常见错误

        System.out.print("Card Expiry Date (MM-YY): ");
        cardExpiryDate = sc.nextLine();

        System.out.println("Checking card expiry...");
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);

        System.out.print("Card Provider (VISA/MasterCard/American Express): ");
        cardProvider = sc.nextLine();

        System.out.print("Card Number: ");
        cardNumber = sc.nextLine();

        System.out.print("CVV: ");
        cvv = sc.nextInt();

        System.out.println("Checking CVV...");
        validCVV = analyseCVV(cvv);
    }

    private boolean analyseCardExpiryDate(String date) {
        LocalDate now = LocalDate.now();
        int currYear = now.getYear();
        int currMonth = now.getMonthValue();

        int month = Integer.parseInt(date.substring(0, 2));
        int year = Integer.parseInt(date.substring(3, 5)) + 2000;

        if (year > currYear || (year == currYear && month >= currMonth)) {
            return true;
        } else {
            System.out.println("Card expired.");
            return false;
        }
    }

    private boolean analyseCVV(int cvvNum) {
        String cvvStr = String.valueOf(cvvNum);

        if (cardProvider.equals("American Express")) {
            if (cvvStr.length() == 4) {
                return true;
            }
        } else if (cardProvider.equals("VISA") || cardProvider.equals("MasterCard")) {
            if (cvvStr.length() == 3) {
                return true;
            }
        }

        System.out.println("CVV invalid.");
        return false;
    }

    public void finalCheckpoint() {
        if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV) {
            chargeFees();
        } else {
            System.out.println("Some validation failed. Going back.");
            registerUser();
        }
    }

    private void chargeFees() {
        double fee;

        if (minorAndBirthday) {
            fee = VIP_BASE_FEE * 0.75;
        } else if (minor) {
            fee = VIP_BASE_FEE * 0.80;
        } else {
            fee = VIP_BASE_FEE;
        }

        String last4 = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid " + fee + " to card ending with " + last4);
    }

    private boolean analyseEmail(String e) {
        if (e.contains("@") && e.contains(".")) {
            return true;
        }
        return false;
    }

    private boolean analyseAge(String date) {
        LocalDate birthDate = LocalDate.parse(date);
        LocalDate now = LocalDate.now();

        int age = now.getYear() - birthDate.getYear();

        if (age < 18) {
            minor = true;
        }

        return age >= 0;
    }

    public String toString() {
        String censored = "";
        for (int i = 0; i < cardNumber.length() - 4; i++) {
            censored += "*";
        }
        censored += cardNumber.substring(cardNumber.length() - 4);

        return "Registration Info:\n" +
                "Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "DOB: " + dob + "\n" +
                "Card Number: " + censored + "\n" +
                "Card Provider: " + cardProvider;
    }

    public void registration() {
        registerUser();
    }
}
