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

        System.out.println("Passwort eingeben: ");

        int length = 8;
        String specialChar = "!@#^*()-_=+[]{}|;:,.?";
        String passwortGenerator = generatePassword(length, specialChar);


        Scanner scanner = new Scanner(System.in);

        String password = scanner.next(); // next liest alles bis zur nächsten Leerzeile ein.
        // nextLine würde die ganze verbleibene Zeile lesen

        boolean passwortLaenge = passwordLength(password, length);
        boolean passwortWithDigits = passwordContainsDigits(password);
        boolean passwortWithUpperLowerCase = passwordContainsUpperCase(password);
        boolean passwortBad = passwordIsBad(password);
        boolean passwortWithSpecialChar = passwordContainsSpecialCharacters(password, specialChar);

    }

    // Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
    public static boolean passwordLength(String password, int laenge) {

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

        // return password.matches(".*[0-9].*");
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

    public static boolean passwordContainsSpecialCharacters(String password, String specialCharacters) {


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
    public static String generatePassword(int length, String specialChars) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        /* for (int i = 0; i < length; i++) {
            int randomAscii = random.nextInt(126 -33 +1)+33;
            password.append((char) randomAscii);
        }
        */

        // Zeichen definieren
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";


        // Mindestens ein Zeichen jedes Zeichensatzes hinzufügen
        password.append((upperCaseChars.charAt(random.nextInt(upperCaseChars.length()))));
        password.append((lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length()))));
        password.append((numberChars.charAt(random.nextInt(numberChars.length()))));
        password.append((specialChars.charAt(random.nextInt(specialChars.length()))));

        // Restliches Passwort mit Zufallszeichen auffüllen
        String allChars = upperCaseChars + lowerCaseChars + numberChars + specialChars;
        for (int i = 4; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        // Mischen der Zeichenfolge
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        System.out.println("zB: " + password.toString());
        return password.toString();
    }
}