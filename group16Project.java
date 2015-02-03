//imports
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 16 CS4092 
 *L:Rory Tynan - 13119656
 *M:Neal Barry - 14118858 
 *M:Grace Bevan-Molloy - 14174642
 *M:Deidre Shanahan - 14117452
 */
public class group16Project {
    //Global Declarations (word,vowel,consonant,result)
    // I Often Declared Variables as early as possible in 2007 in order to insure every possibility was accounted for, but over recent years
    // Programming has changed and so have the methods, instead of calling declarations globally (this is now for cross-class communication
    // (in other words from one class file to another) they need to be called when used ( as late as possible)
    // So what I've done here is I've typed out as many declarations and methods with it's associated javadoc
    // for now and have worked on the main menu method.
    
 String word,consonant,aChar,results,vowels="aeiou";
 String KeybRow [] = {"qwertyuiop[]","asdfghjkl;'#","\\zxcvbnm,./"};// (ignore this - anyone that can develop a solution for storing the row information outside of an array shoot me an email)
 Scanner sc;
 boolean isAlternate; 
 boolean isAnagram;
 boolean isPalindrome;
 boolean isValidInput; 
 
      
    


    /**
     * Handles the Main Menu GUI and selection by returning the choice variable
     * @param choice
     * @return
     */
    
public static String Mainmenu (String choice){
   String pattern1 ="([0-7],{1})";
   boolean isValidInput = true;
   
   while (!(isValidInput))
    if (choice.matches(pattern1))
        isValidInput=true;
        choice = JOptionPane.showInputDialog(null, "1. Analyse a word/phrase/sentence for vowel content"
            + "\n2. Analyse a word/phrase/sentence "
            + "\n3. Analyse a word/phrase/sentence "
            + "\n4. Analyse a word/phrase/sentence "
            + "\n5. Analyse a word/phrase/sentence "
            + "\n6. Analyse a word/phrase/sentence "
            + "\n7. Analyse a word/phrase/sentence "
            + "\n0.Exit.", "Word/Phrase/Setence Analyser", 3);
   
       
       
   return choice;
}

    /**
     * Analyses Vowel content: whether or not the input contains any vowels, contains all vowels, are in alphabetic order
     * are in reverse alphabetic order, the frequency of each vowel (only for those where there is at least one of within input.)
     * @param vowel
     * @return
     */
    public static String AnalyseVowel(String vowel){
     return vowel;   
    }

    /**
     * Analyses the consonant content : the frequency of each consonant (only for those for which there is at least one of occurrence within input)
     * @param consonant
     * @return 
     */
    public static String AnalyseConsonant(String consonant)
    {
    
      return consonant;  
    }

    /**
     *  Analyses Character content : the number of alphanumeric (SEPARATELY alphabetic and numeric) characters, and the number of other symbols,
     *  inclusive - count the frequency of each character found in the Input.
     * @param aChar
     * @return
     */
    public static char AnalyseCharacter(char aChar){
    
        
        return aChar;
    }

    /**
     *Analyse KeyBoard Rows : return which rows on the keyboard a specific set of characters from a word is used e.g typewriter  (first row 10 chars)
     * @param KeybRow TBA 
     * @return 
     */
    public static String AnalyseKeybRow(String KeybRow){
    
        return KeybRow;
    }
    /**
     * Analyse Pattern(Alternation Check) :  returns whether or not the input alternates between consonants and vowels or vice versa vowels and consonants
     * @param isAlternate boolean flag to set at an if statement  if x.contains[i] = vowels (not correct)  isAlternate = true , else  isAlternate = false;
     * @return
     */
    public static boolean AnalyseAlternation(boolean isAlternate){
     
        return isAlternate;
    }

    /**
     * Analyse Word Length : return the lengths of the longest word, and the shortest word, Additionally, the method should report the other words that match
     * in length of both variables (no duplicates), data is also required to be verified (a-z and A-Z) and digits 0-9 ONLY! all others should be ignored.
     * the return value should return both variables.
     * @param wordsLength the length of the longest and shortest words output example:"The longest word was 7 the shortest word was 3"
     * @return 
     */
    public static String AnaylseWordLength(String wordsLength){
        
        
        return wordsLength;
    }

    /**
     *  Analyse Anagram (Anagram Check) : return whether or not a set of words are anagrams of each other, 
     * words/phrase or sentence that is an exact reproduction of the other
     * using each character exactly once.
     * @param isAnagram a boolean flag for an anagram pair - if ((x.equals(y))) isAnagram = true; J.Option...."X is an anagram of y");
     * , else isAnagram = false; JOption..("X isn't an Anagram of Y");
     * @return 
     */
         
    public static boolean CheckAnagram(boolean isAnagram){
      
        return isAnagram;
    }
       

    /**
     * 
     *@param isPalindrome
     * @return
     */
    public static boolean CheckPalinDrome(boolean isPalindrome){
        
        return isPalindrome;
    }
    /**
     * the main Method handles the Main Menu and calls all other Methods, data is required to be validated and the methods handled appropriately. 
     * @param args the command line arguments
     */
public static void main (String [] args){
String input;

}
}
