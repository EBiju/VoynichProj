/** Lab 5
 * Voynich Manuscript Decryption
 * Course: IST 242
 * Author: Eben Biju
 * Date Developed: 12/1
 * Last Date Changed: 12/20
 * Rev: 2
 */


//Program and Code is developed from Joe Oake's javaConstitutionManuscript program on github

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static String decrypt(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                decrypted.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
    //Performs the shift based of each letter in the string. A letter is assigned to c, and it is shifted based on a number. Then it is reattached to c


    public static Set<String> loadDictionary(String dictionaryFile) {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFile))) {
            String word;
            while ((word = br.readLine()) != null) {
                dictionary.add(word.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading the dictionary file: " + e.getMessage());
        }
        return dictionary;
    }
    //Checks the dictionary text file to see what words are in it, creating a set based on the words contained within it


    public static int countValidWords(String text, Set<String> dictionary) {
        String[] words = text.split("\\W+");
        int validWordCount = 0;

        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                validWordCount++;
            }
        }
        return validWordCount;
    }
    //Checks to see if words within the dictionary have no numerical values or use symbols

    public static void main(String[] args) {
        String cipherFile = "Voynich7rcomputertext.txt";
        String dictionaryFile = "dictionary.txt";
        String ciphertext = "";
        //turns the Voynich computer text and dictionary words into string classes to be used later, along with creating a string called ciphertext


        Set<String> dictionary = loadDictionary(dictionaryFile);


        try (BufferedReader br = new BufferedReader(new FileReader(cipherFile))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            ciphertext = sb.toString();
        } catch (IOException e) {
            System.err.println("Error reading the ciphertext file: " + e.getMessage());
            return;
        }
        // Checks to see if it is able to read the ciphertext string created earlier


        System.out.println("This is a brute force cipher that uses shifts in the english alphabet.");
        int bestShift = -1;
        int maxValidWords = 0;
        // This is the beginning of the brute force operation. Shift is set to -1 so the program can begin at a 0 shift.

        for (int shift = 0; shift < 26; shift++) {
            String decrypted = decrypt(ciphertext, shift);
            int validWords = countValidWords(decrypted, dictionary);
        //With the use of a counter control for loop, the program process an alphabetical shift of each value contained within the ciphertext.
        //It will start at 0 and go all the way to shift 25 because the for loop is counting how many shifts are being made.

            System.out.println("Shift: " + shift  + " Valid Words:" + validWords);
            System.out.println(decrypted);
            System.out.println();
            //Displays the Shift value and number of Valid Words from the result of each shift.


            if (validWords > maxValidWords) {
                maxValidWords = validWords;
                bestShift = shift;

            }
        }

        System.out.println("Best Shift: " + bestShift);
        //At the end of the program, the best shift is displayed. The best shift is the one that results in the most valid words from the dictionary
    }
}

//End