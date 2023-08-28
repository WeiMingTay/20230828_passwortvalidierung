package org.example;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Schritt 1: Lege dir ein neues Java GitHub-Projekt an.
        // Schritt 2: Überlege dir, wie die Methoden für die Passwortvalidierung aussehen müssen.
        // Schritt 3: Schreibe einen Test für die Passwortlänge.
        // Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
        // Schritt 5: Schreibe einen Test für die Überprüfung, ob das Passwort Zahlen enthält.
        // Schritt 6: Implementiere die Funktionalität zur Überprüfung, ob das Passwort Zahlen enthält.
        // Schritt 7 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
        // Schritt 8 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
        // Schritt 9 (Bonus): Schreibe einen Test für die Überprüfung, ob das Passwort 'schlechte' Passwörter wie 'passwort' oder '123456' enthält.
        // Schritt 10 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort 'schlechte' Passwörter enthält.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Passwort eingeben: ");
        String password = scanner.next(); // next liest alles bis zur nächsten Leerzeile ein.
        // nextLine würde die ganze verbleibene Zeile lesen

        boolean passwortLaenge = passwordLength(password);
        boolean passwortWithDigits = passwordContainsDigits(password);
        boolean passwortWithUpperLowerCase = passwordContainsUpperCase(password);
        boolean passwortBad = passwordIsBad(password);
        boolean passwortWithSpecialChar = passwordContainsSpecialCharacters(password);

        int length = 8;
        String passwortGenerator = generatePassword(length);
    }

    // Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
    public static boolean passwordLength(String password) {
        int laenge = 8;

        if (password.length() >= laenge) {
            return true;
        } else {
            System.out.println("Passwort Too $hort. Bitte geben Sie min. " + laenge + " Zeichen ein.");
            // System.out.println("zB: "+generatePassword(23));
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
        System.out.println("Passwort muss Ziffern enthalten");
        return false;
    }

    //Schritt 8 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
    public static boolean passwordContainsUpperCase(String password) {
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
                break; // Schleife wird beendet, sobald if-Abfrage true ist.
                // Kann in sehr langen Zeichenfolgen/ Texten von Vorteil sein.
                // Sonst funktioniert dies auch mit zwei if in einer Schleife ohne break!
            }
        }
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                containsLowerCase = true;
                break;
            }
        }
        if (containsUpperCase && containsLowerCase) {
            return true;
        }

        System.out.println("Passwort muss sowohl Groß- als auch Kleinbuchstaben enthalten.");
        return false;
    }

    // Schritt 10 (Bonus): Implementiere die Funktionalität zur Überprüfung, ob das Passwort 'schlechte' Passwörter enthält.
    public static boolean passwordIsBad(String password) {
        String[] badPasswords = {"12345678", "password", "qwertzui", "qwertyui", "123456789"};
        for (String badPassword : badPasswords) {
            if (badPassword.contains(password.toLowerCase())) {
                System.out.println("Passwort steht auf der Blacklist und ist zu unsicher.");
                return true;
            }
        }

        return false;
    }
// Bonus 1: Erweitere die Passwortvalidierung um die Überprüfung, ob das Passwort Sonderzeichen enthält.

    public static boolean passwordContainsSpecialCharacters(String password) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:',.<>/?";

        for (char ch : password.toCharArray()) {
            for (char c : specialCharacters.toCharArray()) {
                if (ch == c) {
                    return true;
                }
            }
        }
        System.out.println("Passwort muss min. eines der folgenden Zeichen enthalten: " + specialCharacters);
        return false;


    }

    // Bonus 2: Implementiere eine Funktion, die ein zufälliges sicheres Passwort generiert.
    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomAscii = random.nextInt(126 -33 +1)+33;
            password.append((char) randomAscii);
        }
        System.out.println("zB.: "+password.toString());
        return password.toString();
    }
}