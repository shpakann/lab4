import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запит на введення речення для шифрування
        System.out.print("Enter the sentence to encrypt: ");
        String sentence = scanner.nextLine();

        // Запит на введення значення N (кількість позицій для зсуву)
        System.out.print("Enter the value of N (number of positions to shift): ");
        int N = scanner.nextInt();

        // Шифрування речення з використанням введеного значення N
        String encryptedSentence = encrypt(sentence, N);
        System.out.println("Encrypted sentence: " + encryptedSentence);

        // Розшифрування зашифрованого речення з використанням введеного значення N
        String decryptedSentence = decrypt(encryptedSentence, N);
        System.out.println("Decrypted sentence: " + decryptedSentence);

        scanner.close();
    }

    // Метод для шифрування речення
    public static String encrypt(String sentence, int N) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (Character.isLetter(ch)) {
                // Шифрування літери з використанням зсуву N
                char encryptedChar = (char) ((ch + N - 'a') % 26 + 'a');
                result.append(encryptedChar);
            } else {
                // Додавання символів, які не є літерами, без змін
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Метод для розшифрування речення
    public static String decrypt(String sentence, int N) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (Character.isLetter(ch)) {
                // Розшифрування літери з використанням зсуву N
                char decryptedChar = (char) ((ch - N - 'a' + 26) % 26 + 'a');
                result.append(decryptedChar);
            } else {
                // Додавання символів, які не є літерами, без змін
                result.append(ch);
            }
        }
        return result.toString();
    }
}
