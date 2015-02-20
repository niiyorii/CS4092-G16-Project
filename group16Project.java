//imports

import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * This File is under MIT License, you may copy, redistribute, edit,
 * commercially use under the conditions that a/ the authors names remain
 * intact, and b/ Use of this file and any adverse effects are at the user's
 * risk and the authors are at no point in it's use, edit or redistribution
 * liable.
 * 
 */
/**
 *
 * @authors Group 16 CS4092 University of Limerick - 2015 L:Rory Tynan -
 * 13119656 M:Neal Barry - 14118858 M:Grace Bevan-Molloy - 14174642 M:Deidre
 * Shanahan - 14117452
 */
public class group16Project {

    //Global Declarations
    static int choice;
    static String s1, s2, consonant, aChar, results, vowels = "aeiou";
    static Scanner sc; // for debug (System.in System.out etc)
    static String pattern = "[^a-zA-Z]+,[0-9]"; // one or more characters of a-z  or A-Z, any digit of 0-9 (no limit).

    /**
     * the main Method handles the Main Menu and calls all other Methods, data
     * is required to be validated and the methods handled appropriately.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         *
         * this is what's called a constructor, where ever it sees it's own
         * variable c it will reference the group16Project class as a new
         * instance of itself in order to call the other methods.
         * c.AnalyseVowel(); is the same as group16Project.AnalyseVowel(); with
         * a constructor
         *
         */
        group16Project01 c = new group16Project01();
        choice = c.mainMenu(choice);
        if (choice != 0) {
            switch (choice) {
                case 1:
                    c.analyseVowel();
                    break;
                case 2:
                    c.analyseConsonant();
                    break;
                case 3:
                    c.analyseCharacter();
                    break;
                case 4:
                    c.analyseKeybRow();
                    break;
                case 5:
                    c.analyseAlternation();
                    break;
                case 6:
                    c.analyseWordLength();
                    break;
                case 7:
                    c.checkAnagram();
                    break;
                case 8:
                    c.checkPalindrome();
                    break;

            }

        }
    }

    /**
     * Handles the Main Menu GUI and selection by returning the choice variable
     * to the main method, use this as an example for the other methods
     *
     * @param choice
     * @return
     */
    public static Integer mainMenu(int choice) {
        pattern = "([0-8]+,{1})";
        String errorMessage = "Invalid menu option selected.";
        errorMessage += "\n\nValid options are 0 to 8 inclusive.";
        errorMessage += "\nSelect OK to retry.";
        boolean validInput;
        String menuChoice = "";

        String menuString = "1. Analyse vowel content of word/phrase."
                + "\n2. Analyse consonants content of word/phase."
                + "\n3. Determine the amount of characters and frequency of them."
                + "\n4. Determine keys required to type word/phase."
                + "\n5. Does word/phase have alternating vowels and consonants?"
                + "\n6. Display the shortest and longest words in a sentence."
                + "\n7. Are two words/phases anagrams of each other."
                + "\n8. Is a word/phase a palindrome."
                + "\n0. Exit.";
        validInput = false; // which holds - assuming we can never trust the end user.
        // I parsed the menu options here instead of the main method as
        //the main method will handle all the switch case statements
            menuChoice = JOptionPane.showInputDialog(null, menuString, 3);
            
        while (!(validInput)) // validInput should be set to false.
        {
            if (menuChoice.matches(pattern)) {
                // as the menuChoice has now passed data validation we can set the 
                //boolean flag to false to step through the WHILE loop and now parse menuChoice to integer data type
                validInput = true; 
                
            } else if (menuChoice.Equals("0")) {
                System.exit(0); // System Exit without any errors
            } else {
                // Did something in java hiccup ? or the end user give us invalid input?
                JOptionPane.showMessageDialog(null, errorMessage, "Error!", 3);
            }
            choice = Integer.parseInt(menuChoice);
        }
        return choice;
    }

    /**
     * Analyses Vowel content: whether or not the input contains any vowels,
     * contains all vowels, are in alphabetic order are in reverse alphabetic
     * order, the frequency of each vowel (only for those where there is at
     * least one of within input.)
     *
     * 
     */
    public static String analyseVowel() {
        s2 = ""; // temporary value

        boolean hasVowels;

        s1 = JOptionPane.showInputDialog(null, "Enter a Word,Phrase or Sentence to Analyse for Vowel Content.", "Analyse Vowels", 2); /// fifty

        for (int i = 0; i < s1.length(); i++) {
            //  Look for vowels..
            char ch = s1.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                results += "The word/phrase/Sentence contains vowels \n";
                hasVowels = true;

                //count the vowels
                int count = s1.replaceAll("[^aeiouAEIOU]", "").length();
                results += count + "\n";
                //Check Order
                string order = s1.replaceAll(pattern, "[^aeiouAEIOU]");
                if (s1.charAt(i) > s1.charAt(+1)) {
                    
                }
            } else {
                results += "The word/phrase/Sentence contains no vowels \n";
            }

        }
        return vowels;
    }

    /**
     * Analyses the consonant content : the frequency of each consonant (only
     * for those for which there is at least one of occurrence within input)
     *
     * @return consonant
     */
    public static String analyseConsonant() {
        consonant = "c"; // temporary variable;

        return consonant;
    }

    /**
     * Analyses Character content : the number of alphanumeric (SEPARATELY
     * alphabetic and numeric) characters, and the number of other symbols,
     * inclusive - count the frequency of each character found in the Input.
     *
     * @return aChar
     *
     */
    public static char analyseCharacter() {
        char aChar = 'a'; // temporary variable;

        return aChar;
    }

    /**
     * Analyse KeyBoard Rows : return which rows on the keyboard a specific set
     * of characters from a word is used e.g typewriter (first row 10 chars)
     *
     * @return KeybRow
     *
     */
    public static String analyseKeybRow() {
        String KeybRow = "First Row:X \n Second Row: Y \n Third Row: Z";
        String KeybRow1 = "qwertyuiop[]";
        String KeybRow2 = "asdfghjkl;'#";
        String KeybRow3 = "\\zxcvbnm,./"; // added escape \ to include it to the string

        return KeybRow;
    }

    /**
     * Analyse Pattern(Alternation Check) : returns whether or not the input
     * alternates between consonants and vowels or vice versa vowels and
     * consonants
     *
     * @return isAlternate boolean flag to set at an if statement if
     * x.contains[i] = vowels (not correct) isAlternate = true , else
     * isAlternate = false;
     */
    public static boolean analyseAlternation() {
        boolean isAlternate = false;
        String analyseAlt = JOptionPane.showInputDialog(null, "Enter a word phrase or sentence to test for alternation", "Alternation Analysis", 3);

        if (analyseAlt.charAt(i) > analyseAlt.charAt(+1)) {
            return isAlternate;
        }
    }

    /**
     * Analyse Word Length : return the lengths of the longest word, and the
     * shortest word, Additionally, the method should report the other words
     * that match in length of both variables (no duplicates), data is also
     * required to be verified (a-z and A-Z) and digits 0-9 ONLY! all others
     * should be ignored. the return value should return both variables.
     *
     * @return wordsLength the length of the longest and shortest words output
     * example:"The longest word was 7 the shortest word was 3"
     */
    public static String analyseWordLength() {
        String analyseWords = "Enter a word, phrase or sentence to analyse it's length."; // temporary variable
        String longestWord, shortestWord;
        pattern = ("[a-zA-Z],[0-9]");
        String wordsLength = JOptionPane.showInputDialog(null, analyseWords, "Analyse Word/Phrase/Sentence Length", 2);

        //Words
        if (wordsLength.matches(pattern)) {
            wordsLength.replaceAll(pattern);
        } //Phrases
        else if () {

        } //Sentences
        else if () {
        } else {
        }

        return wordsLength;

    }

    /**
     * Analyse Anagram (Anagram Check) : return whether or not a set of words
     * are anagrams of each other, words/phrase or sentence that is an exact
     * reproduction of the other using each character exactly once.
     *
     * @return isAnagram a boolean flag for an anagram pair - if ((x.equals(y)))
     * isAnagram = true; J.Option...."X is an anagram of y"); , else isAnagram =
     * false; JOption..("X isn't an Anagram of Y");
     *
     */
    public static boolean checkAnagram() {
        boolean isAnagram = false;

        return isAnagram;
    }

    /**
     * Analyse Palindrome (Palindrome Check) : returns whether or not a word
     * phrase or sentence is a palindrome.a word phrase or sentence that is the
     * same backwards as it is forwards,This Method 1/ IGNORES Punctuation,
     * Whitespaces and Caps 3/ Assumes two palindrome(or non) types at
     * word-level and sentence-level will be entered by the End-User
     *
     * @return isPalindrome a boolean flag for a palindrome, at either a word
     * level or sentence level.. isPalindrome=true; else isPalindrom=false;
     *
     */
    public static boolean checkPalindrome() {
        boolean isPalindrome;
        s2 = "";
        s1 = JOptionPane.showInputDialog(null, "Test if the word/phrase or sentance is a Palindrome", "Palindrome Analyser", 3);
        s1 = s1.toLowerCase(); //Ignore Caps;
        s1 = s1.trim(); //trim Whitespaces;
        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.substring(i, i + 1);
        }
        if (s1.equals(s2)) {
            isPalindrome = true;
            JOptionPane.showMessageDialog(null, s1 + " - has been analysed to be a Palindrome."
                    + "\n Click OK to continue", "Palindrom Analysis Complete", 2);
        } else {
            isPalindrome = false;
            JOptionPane.showMessageDialog(null, s1 + " - has been analysed not to be a Palindrome."
                    + "\n Click OK to Continue.", "Palindrome Analysis Complete", 2);
        }
        return isPalindrome;
    }

}
