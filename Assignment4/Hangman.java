/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import acm.util.*;

public class Hangman extends ConsoleProgram {
	
	/** Maximum number of guess */
	private static final int GUESS_NUM = 8;
	
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 700;
	
	public void init() {
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		canvas = new HangmanCanvas();
		add(canvas);
	}

    public void run() {
		/* You fill this in */
    	intro();
    	while(true) {
    		resetGame();
    		canvas.reset();
    		playGame();
    		String ans = readLine("Would you like another word? (y/n)");
    		if (ans.equals("n")) {
    			break;
    		}
    	}
    	ending();
	}
    
    /* Method: intro */
    /**
     * Print the introduction.
     */
    private void intro() {
    	println("Welcome to Hangman!");
    }
    
    /* Method: ending */
    /**
     * Print the ending.
     */
    private void ending() {
    	println("See you soon!");
    }
    
    /* Method: playGame */
    /**
     * Start the game loop.
     */
    private void playGame() {
    	while(true) {
    		if (tries > GUESS_NUM) {
    			println("You're completely hung.");
    			println("The word was: " + word);
    			println("You lose.");
    			break;
    		}
    		if (display.indexOf('_') == -1) {
    			println("You guessed the word: " + display);
    			println("Congradulations!");
    			println("You win!");
    			break;
    		}
    		println("The word now looks like this: " + display);
    		int guessLeft = GUESS_NUM - tries + 1;
    		println("You have " + guessLeft + " guess" + (guessLeft == 1 ? "" : "es") + " left.");
    		char ch = Character.toUpperCase(userTypeIn().charAt(0));
    		if (isRightLetter(ch, word)) {
    			display = changeDisplay(display, word, ch);
    			canvas.displayWord(display);
    			println("That guess is correct.");
    		} else {
    			println("There are no " + Character.toString(ch) + "'s in the word.");
    			canvas.noteIncorrectGuess(ch);
    			tries++;
    		}
    	}
    }
    
    /* Method: resetGame */
    private void resetGame() {
    	tries = 1;
    	int total = wordBank.getWordCount();
    	word = wordBank.getWord(rgen.nextInt(0, total - 1));
    	int length = word.length();
    	display = display(length);
    }
    
    /* Method: display */
    /**
     * Display a word with dashes.
     * @param length
     * @return
     */
    private String display(int length) {
    	String str = "";
    	for(int i = 0; i < length; i++) {
    		str += "_ ";
    	}
    	return str;
    }
    
    /* Method: userTypeIn */
    /**
     * Asks the user to type in a letter.
     * @return
     */
    private String userTypeIn() {
    	while(true) {
    		String str = readLine("Your guess: ");
        	if (str.length() == 1) {
        		return str;
        	} else {
        		println("Please type in only one letter.");
        	}
    	}
    }
    
    /* Method: changeDisplay */
    /**
     * Change the display if a letter is in the word.
     * @param display
     * @param word
     * @param ch
     * @return
     */
    private String changeDisplay(String display, String word, char ch) {
    	for (int i = 0; i < word.length(); i++) {
    		if (word.charAt(i) == ch) {
    			int pos = 2 * i;
    			display = display.substring(0, pos) + Character.toString(ch) + display.substring(pos + 1);
    		}
    	}
    	return display;
    }
    
    /* Method: isRightLetter */
    /**
     * Check if a letter is in the word.
     * @param ch
     * @param word
     * @return
     */
    private boolean isRightLetter(char ch, String word) {
    	if (word.indexOf(ch) != -1) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /* Method: appWidth()*/
    /**
     * Return APPLICATION_WIDTH for other classes.
     * @return
     */
    public int getApplicationWidth() {
    	return APPLICATION_WIDTH;
    }
    
    /* Method: appHeight() */
    /**
     * Return APPLICATION_HEIGHT for other classes.
     * @return
     */
    public int getApplicationHeight() {
    	return APPLICATION_HEIGHT;
    }
    
    /* Method: showDisplay */
    /**
     * Return the displayed word.
     * @return
     */
    public String getDisplay() {
    	return display;
    }
    
    /* Instance variables */
    private static HangmanLexicon wordBank = new HangmanLexicon();
    private static RandomGenerator rgen = new RandomGenerator();
    private static HangmanCanvas canvas;
    private static int tries;
    private static String word;
    private static String display;
}
