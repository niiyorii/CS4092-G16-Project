
import javax.swing.*;
import java.util.*;
/**
 *
 * Group 16 Project1 CS4092 
 *L:Rory Tynan - 13119656
 *M:Neal Barry - 14118858 
 *M:Grace Bevan-Molloy - 14174642
 *M:Deirdre Shanahan - 14117452
 */
 
public class Group16Project1
{

	public static void main(String [] args)
	{
	int choice;
	String menuOption = "";
	
	while ((menuOption != null) && (!(menuOption.equals("0"))))
		{
		menuOption = getMenuOption();
		if (menuOption != null)
		  {
			choice = Integer.parseInt(menuOption);
			if (choice != 0)
			{
				switch(choice)
				{
				case 1: analyseVowel();	 		break;
				case 2: analyseConsonant();		break;
				case 3: analyseCharacter(); 		break;
				case 4: analyseKeybRow();		break;
				case 5: analyseAlternation();		break;
				case 6: analyseWordLength();	break;
				case 7: checkAnagram();			break;
				case 8: checkPalindrome();		break;
															
				}
			}	
		  }
		}
	}
	
	public static String getMenuOption()
	{
	String menuOption = "1. Analyse vowel content of word or phrase."+
	"\n2. Analyse consonants content of word or phrase."+
	"\n3. Determine the amount of characters and frequency of them in a word or phrase."+
	"\n4. Determine keys required to type a word or phrase."+
	"\n5. Does word or phrase have alternating vowels and consonants?"+
	"\n6. Display the shortest and longest words in a sentence."+
	"\n7. Are two words or phrases anagrams of each other."+
	"\n8. Is a word or phrase a palindrome."+
	"\n0. Exit.";
	boolean validInput = false;
	String selection = "", menuChoicePattern = "[0-8]{1}";
	String errorMessage = "Invalid menu option selected.";
		   errorMessage +="\n\nValid options are 0 to 8 inclusive.";
		   errorMessage += "\nSelect OK to retry.";
		   
	while (!(validInput))
	{
		selection = JOptionPane.showInputDialog(null,menuOption,
		"Choose number of option you wish to have executed",3);
		if ( selection == null || selection.matches(menuChoicePattern))
		validInput = true;
		else
		JOptionPane.showMessageDialog(null, errorMessage, "Error in user input",2);
	}
	return selection;
	}
	
	public static void analyseVowel()
	{
		//Rory
		//analyseVowel takes user input and 1st checks if it contains vowels then checks the frequency of vowels used.
		//then checks if all vowels are present and checks if they are in alphabetical order or reverse alphabetical order.
		String word ,wordCopy, temp, result= "";
		String vowelsUsed [] = {"a","e","i","o","u"};
		int vowelFreq[]= new int [vowelsUsed.length];
		//word takes the user input from getWordOrPhraseFromEndUser9=()methods
		word = getWordOrPhraseFromEndUser("Check vowel content of word/phase.","Enter word/phase.");
		//takes user input and changes it to lower case.
		wordCopy = word.toLowerCase();
		//temp is used if any changes need to be make to the user input.
		temp = wordCopy;
		if (word != null)
		{
			result += "\nInput is: "+word+".\n";
			//checks to see if user input has any vowels.and stores the frequency for each vowel if found.Also removes 1st vowels found so duplicates are not counted.
			if (wordCopy.indexOf('a') != -1 || wordCopy.indexOf('e') != -1 || wordCopy.indexOf('i') != -1|| wordCopy.indexOf('o') != -1 || wordCopy.indexOf('u') != -1)
			{
				for (int index =0 ; index < vowelFreq.length ; index++)
					{
					for ( int pass = 0;pass <wordCopy.length();pass++)
						{
						if (temp.indexOf(vowelsUsed[index]) != -1)
							{
							vowelFreq[index]++;
							temp = temp.replaceFirst(vowelsUsed[index],"#");
							}
						}
					}
				// add to results the frequency of vowels were are used.
				result +="Vowel frequency and occurrences:\n";
				for (int index = 0;index< vowelFreq.length;index++)
					{
					if (vowelFreq[index] !=0)
					result +=vowelsUsed[index]+": "+vowelFreq[index]+"\n";
					}
				//These check if all vowels are in userinput and if they are in alphabetical order or reverse alphabetical order.
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
				//results printed we appropriate messages. 
				result += "\""+word+"\""+ " does not contain any vowels.\n";
				JOptionPane.showMessageDialog(null,result,"Option One Results",1);
				}
		}
	}
		 
	public static void analyseConsonant()
	{
	//rory
	//analyses consonants of the user input and displays which consonants are used and there frequency
	String word , consonantsUsed ="", temp, result ="", vowels[]= {"a","e","i","o","u"};
	word = getWordOrPhraseFromEndUser("Check consonants content of word/phase.","Enter word/phase.");
	temp = word.toLowerCase();
	int position =0;
	if (word != null)
		{
		result += "Word/phrase= "+word+".\n";
		//replaces all vowels and non alphabetical characters.
		for (int index = 0; index < 5;index++)
			{
			temp= temp.replaceAll(vowels[index],"");
			}
			temp = temp.replaceAll("[\\W\\d]","");
			if (temp.isEmpty() != true)
				{
				//loop goes thought user input and checks characters adds them to consonantsUsed unless character is already found.
				for (int index = 0 ; index < temp.length(); index++)
					{
					String aChar = temp.substring(index,index+1);
					if ( consonantsUsed.indexOf(aChar) == -1)
						{
						consonantsUsed+= aChar;
						}
					}
					// sets an array of consonantsUsed length to then count frequency of consonants in user input.
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
						// adds to result the 1st character of consonantsUsed and 1st value of consonantsFrequency used in loop.
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
		
	public static void analyseCharacter()
	{
		//Neal
		//analyses characters used in user input and outputs each character used and it frequency.
		String wordPhrase , temp , charactersUsed="", result="";
		//gets user input from getWordOrPhraseFromEndUser method
		wordPhrase = getWordOrPhraseFromEndUser("Analyse character content of word/phrase.","Enter word/phrase");
	
		if (wordPhrase != null)
		{
		//temp changes to lowercase and replaces all spaces
		temp = wordPhrase.toLowerCase();
		temp = wordPhrase.replaceAll(" ","");
		int position = 0;
		result += "Word/phrase entered: "+ wordPhrase+"\n";
		// loop gets characters used without duplicates
		for (int index = 0 ; index < temp.length(); index++)
					{
					String aChar = temp.substring(index,index+1);
					if ( charactersUsed.indexOf(aChar) == -1)
						{
						charactersUsed+= aChar;
						}
					}
					int charactersFrequency[] = new int [charactersUsed.length()];
					// sets up a array to count frequency of used characters
					for (int index = 0 ; index < temp.length(); index ++)
					{
					String aChar = temp.substring(index,index+1);
						if (charactersUsed.indexOf(aChar) != -1)
							{
							position = charactersUsed.indexOf(aChar);
							charactersFrequency[position]++;
							}
					}
						result +="Characters used and frequency,\n";
						//adds to results each characters and frequency to results
						for (int index =0 ; index < charactersUsed.length(); index++)
							{
							result +="("+charactersUsed.substring(index,index+1)+"= "+charactersFrequency[index]+"),  ";
							}
				JOptionPane.showMessageDialog(null,result,"Option Three Results",1);
			}
	} 
	
	public static void analyseKeybRow()
	{
	//Grace
	//takes user input and checks if input can be typed using one row on the keyboard or more using boolean logic.
	String txt;
	txt = getWordOrPhraseFromEndUser("Analyse character content of word/phrase.","Enter word/phrase");
	String kr1="qwertyuiopQWERTYUIOP";
	String kr2="asdfghjklASDFGHJKL";
	String kr3="zxcvbnmZXCVBNM";
	String result="The text you entered was \""+txt+"\" \nThis can be typed using the following rows of the keyboard: ";
	boolean k1=false; boolean k2=false; boolean k3=false;
	int count=0;
	//for loop checks each character of user input to see if its present in the strings kr1,kr2 and kr3. 
	for (count=0;count<txt.length();count++)
	{
		if (kr1.indexOf(txt.substring(count, count+1))!=(-1))
			k1=true;
		else if  (kr2.indexOf(txt.substring(count, count+1))!=(-1))
			k2=true;
		else if  (kr3.indexOf(txt.substring(count, count+1))!=(-1))
			k3=true;
	}
	// if statement to show incorrect user input.
	if (!k1&&!k2&&!k3)
	result="Please enter text containing alphabetic characters.";
	// add to results if boolean is true
	if (k1)
	result+="1,";
	if (k2)
	result+="2,";
	if (k3)	
	result+="3,";
	
	JOptionPane.showMessageDialog(null,result,"Option Four Results",1);
	}
	 
	public static void analyseAlternation()
	{
	//Deirdre
	// analyses user input and checks if vowels and consonants alternates.	
	 String wordPhrase, copyWordPhrase, result = "";
	 String pattern = "[aeiou]";
	 wordPhrase = getWordOrPhraseFromEndUser("Please enter a word/phrase/sentence:", "Checking to see if input comprises alternating vowels and consonants");
	 boolean isAlternating = true;
	 if (wordPhrase != null)
	 {
	  copyWordPhrase = wordPhrase.toLowerCase();
	  copyWordPhrase = copyWordPhrase.replaceAll("[\\W\\d]", "");
		// for loop checks user input taking the 1st two characters and see if there is a vowel/consonant or consonant/vowel
	 for (int i = 0 ; i < copyWordPhrase.length() - 1 && isAlternating; i++)
	  {
	   //checks if a vowel is 1st then consonant
	   if (copyWordPhrase.substring(i, i + 1).matches(pattern) && (!(copyWordPhrase.substring(i + 1, i + 2).matches(pattern))))
	   {
		isAlternating = true;
		result = "The vowels and consonants in the word/phrase/sentence \"" + wordPhrase + "\" do alternate.";
	   }
		//checks if a consonant is 1st then consonant
	  else if ((!(copyWordPhrase.substring(i, i + 1).matches(pattern))) && copyWordPhrase.substring(i + 1, i + 2).matches(pattern)) 
	   {
	    isAlternating = true;
		result = "The vowels and consonants in the word/phrase/sentence \"" + wordPhrase + "\" do alternate.";
	   }
		// if the two conditions above false boolean is changed to false and input does not alternate
	  else
	   {
	    isAlternating = false;
		result = "The vowels and consonants in the word/phrase/sentence \"" + wordPhrase + "\" do not alternate.";
	   }
	  }
     }
	 JOptionPane.showMessageDialog(null, result, "Option five results:" , 1);
	}
	
	public static void checkAnagram()
	{
	//Deirdre
	// takes two inputs from user and checks if there are anagrams of each other.
	String wordPhrase, copyWordPhrase, wordPhrase2, copyWordPhrase2, aChar, result = "";
	boolean isAnAnagram = true;
	wordPhrase = getWordOrPhraseFromEndUser("Check if word/phrase is an anagram.", "Enter first word/phrase:");
		if (wordPhrase != null)
		{  //changes user inputs to lower case and removes all spaces and non alphabetical characters
			copyWordPhrase = wordPhrase.toLowerCase();
			wordPhrase2= getWordOrPhraseFromEndUser("Check if word/phase is an anagram.", "Enter second word/phase:");
			 copyWordPhrase2= wordPhrase2.toLowerCase();
				 copyWordPhrase= copyWordPhrase.replaceAll("[\\W\\d]", "");
				 copyWordPhrase2= copyWordPhrase2.replaceAll("[\\W\\d]", "");
				 // if statement makes sure the second input contains alphabetical characters.
				 if (wordPhrase2.equals("") != true)
				{
				// after all non alphabetical characters and spaces are removed checks if lengths of inputs are the same length.
				 if (copyWordPhrase.length() == copyWordPhrase2.length())
				 {	
					//loop then checks the 1st character of copyWordPhrase and see if it is in copyWordPhrase2.
					for (int i = 0; i < copyWordPhrase.length() && isAnAnagram; i++)
					{
						aChar = copyWordPhrase.substring(i, i + 1);
						if (copyWordPhrase2.indexOf(aChar) != -1)
							{	
								// if character is found it is then removed so it will not check against the same character twice.
								isAnAnagram = true;
								copyWordPhrase2 = copyWordPhrase2.replaceFirst(aChar, "");
								result = "Word/phrase are anagrams.";
							}
						else
							{
								// if character is not found boolean will go to false and loop is fail.
								isAnAnagram = false;
								result = "Word/phrase are not anagrams.";
							}
					}
				 }
				 else
				 {
				  result = "Word/phrase are not anagrams.";
				 }
                }				 
		}
			JOptionPane.showMessageDialog(null, result, "The result for option seven is:", 1);
		
	}
	
	public static void checkPalindrome()
	{
		//Neal
		//takes user input and checks if input is palindrome at the letter level and the word level.
		String wordPhrase , copyWordPhrase, result ="";
		wordPhrase = getWordOrPhraseFromEndUser("Check if word/phrase is palindrome.","Enter word/phrase");
		int position = 0;
		if (wordPhrase != null)
		{
			copyWordPhrase = wordPhrase.toLowerCase();
			result += "Word normal:\t\t "+copyWordPhrase+"\n";
			String palindrome = "";
			// for loop puts user input into string palindrome in reverse order
			for (int i =copyWordPhrase.length()-1 ;i >= 0; i--)
			{
				palindrome += copyWordPhrase.charAt(i);
			}
				result+= "Word in reverse:\t " + palindrome+"\n";
				//compares copyWordPhrase to palindrome if not = zero it will check at the word level else it is palindrome.
				if (copyWordPhrase.compareTo(palindrome) == 0)
				{
					result +="Word is palindrome at letter level and sentence-level.\n";
				}
				else
					{
					//splits user input ans stores it in an array and sets up another array of the same length.
					String sentenceArray [] = copyWordPhrase.split(" ");
					String sentenceArrayCopy [] = new String [sentenceArray.length];	
					boolean wordPalindrome = true;
					//puts sentenceArray into sentenceArrayCopy in reverse positions in the array.
					for (int index = sentenceArray.length-1; index >=0  ; index--)
						{
							sentenceArrayCopy[position] = sentenceArray[index];
							position ++;
						}
						//checks the two arrays against each other and if condition fails input is not palindrome at word/letter levels
						for (int index = 0; index < sentenceArray.length; index++)
							{
								if (sentenceArray[index].equals(sentenceArrayCopy[index])== true)
								{
								}
								else
								wordPalindrome = false;
							}
						// if wordPalindrome is true it is palindrome at the word level only.
						if (wordPalindrome == true)
						{
							result += "Letters are not palindrome but,\nSentence is palindrome at the word level.";
						}
						else
						result +="Word is not palindrome at letter level or sentence level.";
					}
		JOptionPane.showMessageDialog(null,result,"Results of test Eight",1);
		}
	}
	
	public static void analyseWordLength()
	{
		//Grace
		//This is the method for determining the shortest and longest words in a piece of text.
		String txt = getWordOrPhraseFromEndUser("Check longest and shortest words in sentence.","Enter word/phrase");
		String n=(txt.replaceAll("[^a-zA-Z0-9\\s]",""));
		//This method only deals with the alphanumeric characters entered in the window, and not punctuation.
		n=n.toLowerCase();
		String [] words;
		words = (n.split(" "));
		//The string is split wherever a space has been entered, and each separate word is put into the array called words.
		String result = "The text you entered is : "+txt+"\n";//This string forms part of the final output message.
		ArrayList<String>wordList = new ArrayList<String>(); 
		//This ArrayList exists to avoid duplication in the result. Each word is compared to all of the words which can be found in this list. 
		wordList.add(words[0]);
		String minwords = words[0]+",";
		String maxwords = words[0]+",";
		int min=(words[0].length());
		int max=(words[0].length());//The first word is used as a starting point for length comparisons.
		int i;
		for (i=0;i<words.length;i++)
			{	
			if (wordList.contains(words[i]))//The steps below are skipped if the word can be found in wordList.
			{}
			else//If the word has not already been added to wordList....
			{
				wordList.add(words[i]);//...it is added.
				
					if (words[i].length()>max)
			{
				max=words[i].length();
				maxwords=words[i]+",";
			}				
				
		else if (words[i].length()==max)
		maxwords+=" "+words[i]+",";
				
		else if (words[i].length()<min)
			{
				min=words[i].length();
				minwords=words[i]+",";
			}				
		else if (words[i].length()==min)
		minwords+=" "+words[i]+",";	
//The contents of the minwords and maxwords strings are changed based on the lengths of the words.
//The values of max and min are changed based on the lengths of the words.
		}
	}
	result+="The length of the longest word is : "+max;
	result+="\nThe length of the shortest word is : "+min;
	result+="\nThe following words are the longest: "+maxwords;
	result+="\nThe following words are the shortest: "+minwords;
	JOptionPane.showMessageDialog(null, result);
//The details of word maximum and minimum lengths are added to the result and displayed in a dialog box.
	}
	
	public static String getWordOrPhraseFromEndUser(String windowMessage,String windowTitle)
	{
	boolean validInput = false;
	String userInput = "";
	String pattern = "([a-zA-Z\\W0-9]+)|(([a-zA-Z\\W0-9]+\\s[a-zA-Z\\W0-9]+)+)";
	String errorMessage = "Invalid input";
		   errorMessage += "\nEnter a word or phrase comprising ";
		   errorMessage += "valid characters only.";
		   errorMessage += "\nSelect OK to retry.";
		   
	while (!(validInput))
	{
		userInput = JOptionPane.showInputDialog(null,windowMessage,windowTitle, 3);
		
		if (userInput == null || userInput.matches(pattern))
		validInput = true;
		else 
		JOptionPane.showMessageDialog(null, errorMessage, "Error in user input." , 2);
	}
	return userInput;
	
	}
}
	
