package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Schritt 3: Schreibe einen Test für die Passwortlänge.
    @Test
    void passwordLongerThan8() {
        //GIVEN
        String password = "password";
        int laenge = 8;
        //WHEN
        boolean actual = Main.passwordLength(password, laenge);
        //THEN
        assertTrue(actual);
    }

    @Test
    void passwordNoLongerThan8() {
        //GIVEN
        String password = "passwor";
        int laenge = 8;
        //WHEN
        boolean actual = Main.passwordLength(password, laenge);
        //THEN
        assertFalse(actual);
    }

    // Schritt 5: Schreibe einen Test für die Überprüfung, ob das Passwort Zahlen enthält.
    @Test
    void passwordContainsDigits() {
        //GIVEN
        String password = "password23";
        //WHEN
        boolean actual = Main.passwordContainsDigits(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void passwordContainsNoDigits() {
        //GIVEN
        String password = "password";
        //WHEN
        boolean actual = Main.passwordContainsDigits(password);
        //THEN
        assertFalse(actual);
    }

    // Schritt 7 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
    @Test
    void passwordContainsUpperCase() {
        //GIVEN
        String password = "passwoRd";
        //WHEN
        boolean actual = Main.passwordContainsUpperCase(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void passwordContainsNoUpperCase() {
        //GIVEN
        String password = "PASSWORD";
        //WHEN
        boolean actual = Main.passwordContainsUpperCase(password);
        //THEN
        assertFalse(actual);
    }

    // Schritt 9 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort 'schlechte' Passwörter wie 'passwort' oder '123456' enthält.
    @Test
    void passwordIsBad() {
        //GIVEN
        String password = "12345678";
        //WHEN
        boolean actual = Main.passwordIsBad(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void passwordIsOkay() {
        //GIVEN
        String password = "wasGanzAnderes99?";
        //WHEN
        boolean actual = Main.passwordIsBad(password);
        //THEN
        assertFalse(actual);
    }

    // Bonus 1: Erweitere die Passwortvalidierung um die Überprüfung, ob das Passwort Sonderzeichen enthält.
    @Test
    void passwordContainsSpecialChar() {
        //GIVEN
        String password = "password!";
        String specialChar = "!@#^*()-_=+[]{}|;:,.?";
        //WHEN
        boolean actual = Main.passwordContainsSpecialCharacters(password, specialChar);
        //THEN
        assertTrue(actual);
    }

    @Test
    void passwordContainsNoSpecialChar() {
        //GIVEN
        String password = "password";
        String specialChar = "!@#^*()-_=+[]{}|;:,.?";
        //WHEN
        boolean actual = Main.passwordContainsSpecialCharacters(password, specialChar);
        //THEN
        assertFalse(actual);
    }
}
//GIVEN
//WHEN
//THEN

