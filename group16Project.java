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

    // Global Declarations (word,vowel,consonant,result)
    //  over the recent years Programming has changed and so have the methods, instead of calling declarations immediately and
    // globally (this is now for multiple method interaction.
    // (in other words from one method to another, and even to other class files) they need to be called when used ( as late as possible)
    // So what I've done here is I've typed out as many declarations and methods with it's associated javadoc 
    // for now and have worked building a type of data structure that allows everything to work as intended.
    //static String s1, s2, consonant, aChar, results, vowels = "aeiou"; // sample declarations
    static Scanner sc; // for debugging (System.in System.out etc)
    static boolean notValidInput; // globally declare this so all methods can use notValidInput instead of multiple declarations
    static String pattern = "[^a-zA-Z]+,[0-9]"; // one or more characters of a-z  or A-Z, any digit of 0-9 (no limit).
    static String results = "";

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
        /**
         *
         * this is what's called a constructor, where ever it sees it's own
         * variable c it will reference the group16Project class as a new
         * instance of itself in order to call the other methods.
         * c.AnalyseVowel(); is the same as group16Project.AnalyseVowel(); with
         * a constructor
         *
         */
        int choice = 0;
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
        pattern = "([0-8]{1})";
        String errorMessage = "Invalid menu option selected.";
        errorMessage += "\n\nValid options are 0 to 8 inclusive.";
        errorMessage += "\nSelect OK to retry.";

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
        notValidInput = true; // which holds - as menuChoice is an empty string and the pattern requires at least one digit.
        while (notValidInput) // notValidInput should be set to true.
        {
           // I parsed the menu options here instead of the main method as the main method will handle all the switch case statements
            
            menuChoice = JOptionPane.showInputDialog(null, menuString, "Word/ Phrase / Sentence Analyser - Make a Selection", 3);
            
            if (menuChoice.matches(pattern)) {
                notValidInput = false; 
                choice = Integer.parseInt(menuChoice);// as the menuChoice has now passed data validation we can set the boolean flag to false to step through the WHILE loop..
            } else if (menuChoice.matches("0")) {
                notValidInput = false;
                System.exit(0); // Safe to Assume we can exit the program without errors (do we ask to quit though?)
            } else {
                JOptionPane.showMessageDialog(null, errorMessage, "Error!", 3);
            }
            
        }
        return choice;
    }

    /**
     * Analyses Vowel content: whether or not the input contains any vowels,
     * contains all vowels, are in alphabetic order are in reverse alphabetic
     * order, the frequency of each vowel (only for those where there is at
     * least one of within input.)
     *
     * @return vowels
     */
    public static void analyseVowel()
	{
		String word ,wordCopy, temp, result= "";
		int a=0, e=0, i=0, o=0, u=0;
		// call getWordOrPhraseFromEndUser method passing in strings for dialog boxes.
		word = getWordOrPhraseFromEndUser("Check vowel content of word/phase.","Enter word/phase.");
		wordCopy = word.toLowerCase();
		temp = wordCopy;
		if (word != null)
		{
			result += "\nInput is: "+word+".\n";
			if (wordCopy.indexOf('a') != -1 || wordCopy.indexOf('e') != -1 || wordCopy.indexOf('i') != -1|| wordCopy.indexOf('o') != -1 || wordCopy.indexOf('u') != -1)
			{
				result += "\""+word+"\""+ " does contain vowel(s).\n";
				for (int index =0 ; index < wordCopy.length() ; index++)
					{
					if (temp.indexOf('a') != -1)
						{
						a++;
						temp = temp.replaceFirst("a", "#");
						}
						else if (temp.indexOf('e') != -1)
							{
							e++;
							temp = temp.replaceFirst("e", "#");
							}
							else if (temp.indexOf('i') != -1)
								{
								i++;
								temp = temp.replaceFirst("i", "#");
								}
								else if (temp.indexOf('o') != -1)
									{
									o++;
									temp = temp.replaceFirst("o", "#");
									}
									else if (temp.indexOf('u') != -1)
										{
										u++;
										temp = temp.replaceFirst("u", "#");
										}	
					}
				result +="Vowel frequency and occurrences:\nA="+a+" E="+e+" I="+i+" O="+o+" U=" +u+"\n";
				if (wordCopy.indexOf('a') !=-1 && wordCopy.indexOf('e')!=-1 && wordCopy.indexOf('i') !=-1 && wordCopy.indexOf('o')!=-1 && wordCopy.indexOf('u')!=-1)
					{
						result +="\""+word+"\" contains all vowels.\n";
						if (wordCopy.indexOf('a') < wordCopy.indexOf('e') && wordCopy.indexOf('i') < wordCopy.indexOf('o'))
							{
							result += "\""+word+"\" contains vowels in alphabetical order.\n";
							}
							else if (wordCopy.indexOf('u') < wordCopy.indexOf('o') && wordCopy.indexOf('i') < wordCopy.indexOf('e'))
								{
								result += "\""+word+"\" contains vowels in reverse alphabetical order.\n";
								}
					}
				JOptionPane.showMessageDialog(null,result,"Option One Results",1);
			}
			else	
				{
				result += "\""+word+"\""+ " does not contain any vowels.\n";
				JOptionPane.showMessageDialog(null,result,"Option One Results",1);
				}
		}
	}
		 
	public static void analyseConsonant()
	{
	String word , consonantsUsed ="", temp, result ="", vowels[]= {"a","e","i","o","u"};
	word = getWordOrPhraseFromEndUser("Check consonants content of word/phase.","Enter word/phase.");
	temp = word.toLowerCase();
	int position =0;
	if (word != null)
		{
		result += "Word/phrase= "+word+".\n";
		for (int index = 0; index < 5;index++)
			{
			temp= temp.replaceAll(vowels[index],"");
			}
			temp = temp.replaceAll("\\W","");
			temp = temp.replaceAll("\\d","");
			if (temp.isEmpty() != true)
				{
				for (int index = 0 ; index < temp.length(); index++)
					{
					String aChar = temp.substring(index,index+1);
					if ( consonantsUsed.indexOf(aChar) == -1)
						{
						consonantsUsed+= aChar;
						}
					}
					int consonantsFrequency[] = new int [consonantsUsed.length()];
					for (int index = 0 ; index < temp.length()-1; index ++)
					{
					String aChar = temp.substring(index,index+1);
						if (consonantsUsed.indexOf(aChar) != -1)
							{
							position = consonantsUsed.indexOf(aChar);
							consonantsFrequency[position]++;
							}
					}
					result +="Consonants used and frequency,\n";
						for (int index =0 ; index < consonantsUsed.length(); index++)
							{
							result +=consonantsUsed.substring(index,index+1)+": "+consonantsFrequency[index]+" ";
							}
				}
				else
					{
					result+="Word/Phase does not contain consonants.\n";
					}
		}
		else
		result+=word + " does not contain consonants.\n";
	
		JOptionPane.showMessageDialog(null, result,"Option Two Results",1);
	}
            /**
             * Analyses Character content : the number of alphanumeric
             * (SEPARATELY alphabetic and numeric) characters, and the number of
             * other symbols, inclusive - count the frequency of each character
             * found in the Input.
             *
             * @return aChar
             *
             */
    public static void analyseCharacter () 
{
	String words = "This is a Sentence to Analyse for character content, frequency of each character and occurrences";
	String chars = words.trim() , results ="";
	int numOfchars, numAlphabet,numNumerical;
	int freq [] = new int [chars.length];

	
	
		if (chars.matches([a-zA-Z]+)
			numAlphabet = words.ReplaceAll([a-zA-Z]+,"#").length();
			results+= "you typed: " +words+;
			results+= "number of characters is " +numAlphabet+ "\n";
		
			for(char ch = 0; ch < freq.length; ch++)
      				if (words[ch] > 0)
          			results += ch + " appears " + freq[ch] + " times. \n";

		}
	
	}	
}

    /**
     * Analyse KeyBoard Rows : return which rows on the keyboard a specific set
     * of characters from a word is used e.g typewriter (first row 10 chars)
     *
     * @return KeybRow
     *
     */
    public static void analyseKeybRow() {
        String KeybRow = "First Row:X \n Second Row: Y \n Third Row: Z";
        String KeybRow1 = "qwertyuiop[]";
        String KeybRow2 = "asdfghjkl;'#";
        String KeybRow3 = "\\zxcvbnm,./"; // added escape \ to include it to the string

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
    public static void analyseAlternation() {
        boolean isAlternate = false;
        String analyseAlt = JOptionPane.showInputDialog(null, "Enter a word phrase or sentence to test for alternation", "Alternation Analysis", 3);

        if (analyseAlt.charAt(i) > analyseAlt.charAt(+1)) {

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
    public static void analyseWordLength() {
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
    public static void checkAnagram() {
        boolean isAnagram = false;

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
    public static void checkPalindrome() {
        boolean isPalindrome;
        String s2 = "";
        String s1 = JOptionPane.showInputDialog(null, "Test if the word/phrase or sentence is a Palindrome", "Palindrome Analyser", 3);
        s1 = s1.toLowerCase(); //Ignore Caps;
        s1 = s1.trim(); //trim Whitespaces;
        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.substring(i, i + 1);
        }
        if (s1.equals(s2)) {
            isPalindrome = true;
            JOptionPane.showMessageDialog(null, s1 + " - has been analysed to be a Palindrome at a word level."
                    + "\n Click OK to continue", "Palindrom Analysis Complete", 2);
                        if()
        } else {
            isPalindrome = false;
            JOptionPane.showMessageDialog(null, s1 + " - has been analysed not to be a Palindrome at a word level."
                    + "\n Click OK to Continue.", "Palindrome Analysis Complete", 2);
        }
        mainMenu(8); 
    }

}
