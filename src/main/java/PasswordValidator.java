import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    static int PASSWORD_REQUIRED_LENGTH = 8;
    static List<String> goodPasswords = new ArrayList<>();
    static List<String> badPasswords = new ArrayList<>();

    public static void main(String[] args) {
        String[] passwords = {"password", "Password1", "pw", "123123123123"};
        checkAnArrayOfPasswords(passwords);
    }

    public static boolean checkAnArrayOfPasswords(String[] passwords) {
        boolean allPasswordsInArrayAreGoodPasswords = true;
        for (String password : passwords) {
            if (!checkPassword(password)) {
                allPasswordsInArrayAreGoodPasswords = false;
            }
        }
        System.out.println("\nAll Passwords in array are good passwords: " + allPasswordsInArrayAreGoodPasswords);
        System.out.println("\nGood Passwords: ");
        for (String goodPassword : goodPasswords) {
            System.out.println(goodPassword);
        }
        System.out.println("\nBad Passwords: ");
        for (String badPassword : badPasswords) {
            System.out.println(badPassword);
        }
        return allPasswordsInArrayAreGoodPasswords;
    }

    public static boolean checkPassword(String password) {
        System.out.println("\nChecking Password: " + password);
        boolean isLongEnough = checkIfPasswordIsLongEnough(password);
        System.out.println("Password is long enough: " + isLongEnough);
        boolean containsNumbers = checkIfPasswordContainsNumbers(password);
        System.out.println("Password contains numbers: " + containsNumbers);
        boolean containsUpperAndLowerCase = checkIfPasswordContainsUpperAndLowerCase(password);
        System.out.println("Password contains upper AND lowercase characters: " + containsUpperAndLowerCase);
        boolean isGoodPassword = isLongEnough && containsNumbers && containsUpperAndLowerCase;
        System.out.println("Your password >> " + password + " << is good: " + isGoodPassword);
        System.out.println("------------------------------------------------------------------");
        if (isGoodPassword){
            goodPasswords.add(password);
        } else {
            badPasswords.add(password);
        }
        return isGoodPassword;
    }

    public static boolean checkIfPasswordContainsUpperAndLowerCase(String password) {
        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                containsUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                containsLowerCase = true;
            }
        }
        return containsLowerCase && containsUpperCase;
    }

    public static boolean checkIfPasswordContainsNumbers(String password) {
        boolean containsNumber = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                containsNumber = true;
            }
        }
        return containsNumber;
    }

    public static boolean checkIfPasswordIsLongEnough(String password) {
        return password.length() >= PASSWORD_REQUIRED_LENGTH;
    }
}
