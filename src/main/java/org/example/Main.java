package org.example;

public class Main {
    public static void main(String[] args) {
        // Schritt 1: Lege dir ein neues Java GitHub-Projekt an.
        // Schritt 2: Überlege dir, wie die Methoden für die Passwortvalidierung aussehen müssen.
        // Schritt 3: Schreibe einen Test für die Passwortlänge.
        // Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
        //      boolean schritt4 = passwordLength("password");
        // Schritt 5: Schreibe einen Test für die Überprüfung, ob das Passwort Zahlen enthält.
        // Schritt 6: Implementiere die Funktionalität zur Überprüfung, ob das Passwort Zahlen enthält.
        // Schritt 7 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
        // Schritt 8 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
        // Schritt 9 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort 'schlechte' Passwörter wie 'passwort' oder '123456' enthält.
        // Schritt 10 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort 'schlechte' Passwörter enthält.
    }

    // Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
    public static boolean passwordLength(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            System.out.println("Passwort too $hort.");
            return false;
        }
    }

    // Schritt 6: Implementiere die Funktionalität zur Überprüfung, ob das Passwort Zahlen enthält.
    public static boolean passwordContainsDigits(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }

        }
        return false;
    }

    //Schritt 8 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
    public static boolean passwordContainsUpperCase(String password) {
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            }
            if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            }

            if (containsUpperCase && containsLowerCase) {
                return true;
            }

        }
        return false;
    }

    // Schritt 10 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort 'schlechte' Passwörter enthält.
    public static boolean passwordIsBad(String password) {
        String[] badPasswords = {"12345678", "password", "Password", "qwertzui", "123456789"};
     for (String badPassword : badPasswords) {
         if(badPassword == password) {
             return true;
         }
     }
     return false;
    }

    public static boolean passwordContainsSpecialCharacters(String password) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:',.<>/?";

        for (char ch : password.toCharArray()) {
            for(char c : specialCharacters.toCharArray()) {
                if (ch == c) {
                    return true;
                }
            }
        }
        return false;


    }
}