/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 * A fine YouTube video that teaches you how to upload a project from eclipse to GitHub.
 * https://www.youtube.com/watch?v=Huwf0TgWrOw&ab_channel=Telusko
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon extends ConsoleProgram {
	
	/* This is the HangmanLexicon constructor. */
	public HangmanLexicon() {
		rd = openFileReader();
		try {
			while(true) {
				String line = rd.readLine();
				if (line == null) {
					break;
				}
				wordList.add(line);				
			}
			rd.close();
		} catch (IOException ex) {
			println("An I/O exception has occurred.");
		}
	}

	/* Method: countWords */
	/**
	 * Count word numbers in a line.
	 * @param line
	 * @return
	 */
	private int countWords(String line) {
		boolean inWord = false;
		int wordNum = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) {
					wordNum++;
				}
				inWord = false;
			}
		}
		if (inWord) {
			wordNum++;
		}
		return wordNum;
	}
	
	/* Method: openFileReader */
	/**
	 * Open and read a file.
	 * @param prompt
	 * @return
	 */
	private BufferedReader openFileReader() {
		BufferedReader rd = null;
		while (rd == null) {
			String fileName = "ShorterLexicon.txt";
			try {
				rd = new BufferedReader(new FileReader(fileName));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
	
	/* Method: getWordCount */
	/**
	 * Get word count.
	 * @return
	 */
	public int getWordCount() {
		return wordList.size();
	}
	
	/* Method: getWord */
	/**
	 * Get a word from the word list.
	 * @return
	 */
	public String getWord(int n) {
		return wordList.get(n);
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount1() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord1(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	}
	
	/* Instance variables */
	private static BufferedReader rd;
	private static ArrayList<String> wordList = new ArrayList<String>();
}
