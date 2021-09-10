import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "Hallo, false",
            "HalloHalloHalloHallo, false",
            "HalloHallo123, true",
            "1, false"
    })
    public void testPasswordValidatorWithSinglePassword(String password, boolean expected) {
        // WHEN
        boolean actual = PasswordValidator.checkPassword(password);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordValidatorWithListOfPasswordsOne() {
        // GIVEN
        String[] passwords = {"Hallo", "hallo", "12345"};
        boolean expected = false;
        // WHEN
        boolean actual = PasswordValidator.checkAnArrayOfPasswords(passwords);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordValidatorWithListOfPasswordsTwo() {
        // GIVEN
        String[] passwords = {"HalloHalloHallo", "123123123123123", "hallohallo123456789"};
        boolean expected = false;
        // WHEN
        boolean actual = PasswordValidator.checkAnArrayOfPasswords(passwords);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordValidatorWithListOfPasswordsThree() {
        // GIVEN
        String[] passwords = {"HalloJava123", "halloNeueFische6", "a12345aA"};
        boolean expected = true;
        // WHEN
        boolean actual = PasswordValidator.checkAnArrayOfPasswords(passwords);
        // THEN
        assertEquals(expected, actual);
    }
}