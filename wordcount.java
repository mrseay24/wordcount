package wordcount;

/*
  CSC3410 - Fall 2015
  Sidney Seay -  sseay5@student.gsu.edu

  Assignment: #2

  Deck class

  File(s): wordcount.java

  Purpose: Prompt user for input file, count the amount of words,
           count the amount of lines, count amount of alphanumeric characters,
           count the number of sentences, count the amount of vowels (a, e, i, o, u),
           count the amount of punctuation 
    
*/


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class wordcount {

	/*
	 * constructor
	 */
	wordcount() {
		
	}
	/*
     *  read input file
     */
    private static void read_inputFile() {
    	/*
    	 * 1. call method countWord - count number of words in the file
    	 * 2. call method countLine - count number of lines in the file
    	 * 3. call method countAlphaNum - count number of alphanumeric
    	 *    characters in the file
    	 * 4. call method countSentence - count number of sentences in the file
    	 * 5. call method countVowel - count number of vowels in the file
    	 * 6. call method countPun - count number of punctuation in the file
      	 */
 	   String fileName = "";
 	   String line = null;
 	   // initialize counter
 	   int iCounter = 0;
 	   int wCounter = 0;  // word counter
 	   int lCounter = 0;  // line counter
 	   int aCounter = 0;  // alphanumeric counter
 	   int sCounter = 0;  // sentence counter
 	   int vCounter = 0;  // vowel counter
 	   int pCounter = 0;  // punctuation counter
 	   
 	   Scanner input = new Scanner(System.in);
 	   // display on console enter file name
 	   System.out.println("Enter the file name with directory location - for example c:\\TestFile.txt : ");
 	   input = new Scanner(System.in);
 	   fileName = input.nextLine();

	   // reference input file containing sentence, word, vowel, etc
	   File fExpression = new File(fileName);
 	   
 	   // try catch - verify file name is valid
	   try {
		   // create buffered reader for the input file
		   BufferedReader buffReader = new BufferedReader(new FileReader(fExpression));
		   line = buffReader.readLine();
           
		   // check for empty file
		   if (line == null) {
			     // write to console
			     System.out.println(" ");
			     System.out.println("The input file is empty");
			     // write to output file c:\output.txt
				 PrintWriter writer = new PrintWriter("c:\\output" + ".txt", "UTF-8");
				 writer.println("The input file is empty");
				 writer.close();
		   }
		   else
		   {
			   // process entire input file data
			   // call each method to process input data
			   while (line != null) {
				     // call method countWord
				     // reset iCounter
				     iCounter = 0;
				   	 iCounter = countWord(line, iCounter);
				   	 wCounter = wCounter + iCounter;
				     // call method countLine
				     // reset iCounter			   	 
				   	 iCounter = 0;
					 iCounter = countLine(line, iCounter);
					 lCounter = lCounter + iCounter;
				     // call method countAlphaNum
				     // reset iCounter				 
					 iCounter = 0;
					 iCounter = countAlphaNum(line, iCounter);
					 aCounter = aCounter + iCounter;
				     // call method countSentence
				     // reset iCounter
					 iCounter = 0;
					 iCounter = countSentence(line, iCounter);
					 sCounter = sCounter + iCounter;
				     // call method countVowel
				     // reset iCounter
					 iCounter = 0;
					 iCounter = countVowel(line, iCounter);
					 vCounter = vCounter + iCounter;
				     // call method countPun
				     // reset iCounter
					 iCounter = 0;
					 iCounter = countPun(line, iCounter);
	                 pCounter = pCounter + iCounter;
					 
					 line = buffReader.readLine();		   
			   }
			     // write to console
			     System.out.println(" ");
				 System.out.println("Number of words in file is : " + wCounter);			   	 
				 System.out.println("Number of lines in file is : " + lCounter);			   	 
				 System.out.println("Number of alphanumeric in file is : " + aCounter);			   	 
				 System.out.println("Number of sentences in file is : " + sCounter);			   	 
				 System.out.println("Number of vowels in file is : " + vCounter);			   	 
				 System.out.println("Number of punctuation in file is : " + pCounter);			   	 		   

			     // write to output file c:\output.txt
				 PrintWriter writer = new PrintWriter("c:\\output" + ".txt", "UTF-8");

				 writer.println("Number of words in file is : " + wCounter);
				 writer.println("Number of lines in file is : " + lCounter);
				 writer.println("Number of alphanumeric in file is : " + aCounter);			   	 
				 writer.println("Number of sentences in file is : " + sCounter);			   	 
				 writer.println("Number of vowels in file is : " + vCounter);			   	 
				 writer.println("Number of punctuation in file is : " + pCounter);			   	 		   

				 // close output file
				 writer.close();
				 
		   }
        }
	   catch (Exception exp) {
		   System.out.println("filename is " + fileName);		   
		   System.out.println("Error occurred while reading input file: " + exp.getMessage());
	    }	   
    }
    
    /*
     * count the number of word in file 
     */
	 private static int countWord(String inputData, int wCounter) {
		 //char charData;
		 String[] wordData = null;
         /*
         The array is split/parse by blank which
         indicate a word. The length of the array
         is the number of word in the array
	    */
         wordData = inputData.split(" ");
         
         wCounter = wordData.length;

         return wCounter;
	 }
    /*
     * count the number of line in file 
     */	 
	 private static int countLine(String inputData, int lCounter) {
        /*
         *  we are reading 1 line from the file at a time
         *  add 1 to counter for the line read from the
         *  input file
         */
         return ++lCounter;
	 }	 
    /*
     * count the number of alphanumeric character in file 
     */	 
	 private static int countAlphaNum(String inputData, int aCounter) {
		 char charData;
		 String sData = "";

		 for (int i=0;i < inputData.length(); i++)
		 {
		    charData = inputData.charAt((i));
		    sData = String.valueOf(charData);
		    /*
		     *  counter the number of digit found
		     */
		    if (Character.isDigit(charData)) {
		    	aCounter++;  // found digit
		    }
		    /*
		     *  counter the number of letter found
		     */		    
		    if (Character.isLetter(charData)) {
		    	aCounter++;  // found letter
		    }		    
		 }
         return aCounter;
	 }
    /*
     * count the number of sentence in file 
     */	 	 
	 private static int countSentence(String inputData, int sCounter) {
		 char punct[]={'.','!',',','?',':',';'}; 
         char charData;
         int pLength = punct.length;
         
		 for( int j =0; j < inputData.length(); j++)
		 {
 		    charData = inputData.charAt((j));			 
            for (int pun = 0; pun < pLength; pun++) {
            	/*
            	 * a sentence is separated by the values in
            	 * punct array
            	 * counter the number of sentence
            	 */
     		    if(charData == punct[pun])
                {
                        sCounter++; // found sentence                	
    		    }            	
            }
		 }
		 return sCounter;
	 }
    /*
     * count the number of vowel in file 
     */	 
	 private static int countVowel(String inputData, int vCounter) {
		 char charData;
		 char lowerCase;
		 String sData = "";

		 for (int i = 0; i < inputData.length(); i++)
		 {
		    charData = inputData.charAt((i));
		    sData = String.valueOf(charData);
		    lowerCase = Character.toLowerCase(charData);
            /*
             * counter the number of vowel at the character position
             * in the input data
             */
		    switch(lowerCase){
		    case('a'):
		    case('e'):
		    case('i'):
		    case('o'):
		    case('u'):		    	
		    	vCounter++;  // found vowel		    	
            break;		    	
		    }
		 }
         return vCounter;
	 }
    /*
     * count the number of punctuation in file 
     */	 	 
	 private static int countPun(String inputData, int pCounter) {
		 char punct[]={'.','!',',','?',':',';'}; 
         char charData;
         int pLength = punct.length;
         
		 for( int j = 0; j < inputData.length(); j++)
		 {
 		    charData = inputData.charAt((j));			 
            for (int pun = 0; pun < pLength; pun++) {
            	/*
            	 * counter the number of punctuation symbol
            	 * found in the input data per array punct
            	 */
     		    if(charData == punct[pun])
                {
    		    	pCounter++; // found punctuation
    		    }            	
            }
		 }
		 return pCounter;
	 }
    
    /*
     * Main program logic
     * call method read_inputFile
     * method read_inputFile will call sub-methods
     * 
     */
    public static void main(String args[]){
    	
    	read_inputFile();
    	
    }
}