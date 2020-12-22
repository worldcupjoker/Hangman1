/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		addScaffold();
		addDisplayWord(hangman.getDisplay());
		wrongLetters = "";
		addWrongLetters();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		displayBoard.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		updateWrongLetters(letter);
		drawPicture(wrongLetters.length());
	}
	
	/* Method: addScaffold */
	/**
	 * Draw a scaffold.
	 */
	private void addScaffold() {
		GLine scaffoldBeam = new GLine(appWidth / 2, appHeight * 0.204, appWidth / 2 - BEAM_LENGTH, appHeight * 0.204);
		GLine scaffoldPole = new GLine(appWidth / 2 - BEAM_LENGTH, appHeight * 0.204, appWidth / 2 - BEAM_LENGTH, appHeight * 0.204 + SCAFFOLD_HEIGHT);
		GLine rope = new GLine(appWidth / 2, appHeight * 0.204, appWidth / 2, appHeight * 0.204 + ROPE_LENGTH);
		add(scaffoldBeam);
		add(scaffoldPole);
		add(rope);
	}
	
	/* Method: addDisplayWord */
	private void addDisplayWord(String str) {
		displayBoard = new GLabel(str);
		displayBoard.setFont("Times New Roman-20");
		displayBoard.setLocation(appWidth * 0.127, appHeight * 0.8 + 30);
		add(displayBoard);
	}
	
	/* Method: updateWrongLetters*/
	/**
	 * Keep recording wrong letters.
	 * @param letter
	 */
	private void updateWrongLetters(char letter) {
		wrongLetters += Character.toString(letter);
		letterBoard.setLabel(wrongLetters);
	}
	
	/* Method: addWrongLetters */
	/**
	 * Add display of wrong letters.
	 */
	private void addWrongLetters() {
		letterBoard = new GLabel(wrongLetters);
		letterBoard.setFont("Times New Roman-15");
		letterBoard.setLocation(appWidth * 0.127, appHeight * 0.8);
		add(letterBoard);
	}
	
	/* Method: drawPicture*/
	/**
	 * Draw the hangman picture.
	 * @param len
	 */
	private void drawPicture(int len) {
		switch (len) {
		case 1: drawHead(); break;
		case 2: drawBody(); break;
		case 3: drawLeftArm(); break;
		case 4: drawRightArm(); break;
		case 5: drawLeftLeg(); break;
		case 6: drawRightLeg(); break;
		case 7: drawLeftFoot(); break;
		case 8: drawRightFoot(); break;
		default: break;
		}
	}
	
	/* Method: drawHead */
	private void drawHead() {
		GOval head = new GOval(appWidth / 2 - HEAD_RADIUS, appHeight * 0.204 + ROPE_LENGTH, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		add(head);
	}
	
	/* Method: drawBody */
	private void drawBody() {
		GLine body = new GLine(appWidth / 2, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS, appWidth / 2, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(body);
	}
	
	/* Method: drawLeftArm */
	private void drawLeftArm() {
		GLine upperArm = new GLine(appWidth / 2, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, appWidth / 2 - UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		GLine lowerArm = new GLine(appWidth / 2 - UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, appWidth / 2 - UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(upperArm);
		add(lowerArm);
	}
	
	/* Method: drawRightArm */
	private void drawRightArm() {
		GLine upperArm = new GLine(appWidth / 2, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, appWidth / 2 + UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		GLine lowerArm = new GLine(appWidth / 2 + UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, appWidth / 2 + UPPER_ARM_LENGTH, appHeight * 0.204 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(upperArm);
		add(lowerArm);
	}
	
	/*Method: drawLeftLeg */
	private void drawLeftLeg() {
		GLine hip = new GLine(appWidth / 2, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH, appWidth / 2 - HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH);
		GLine leg = new GLine(appWidth / 2 - HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH, appWidth / 2 - HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(hip);
		add(leg);
	}
	
	/*Method: drawRightLeg */
	private void drawRightLeg() {
		GLine hip = new GLine(appWidth / 2, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH, appWidth / 2 + HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH);
		GLine leg = new GLine(appWidth / 2 + HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH, appWidth / 2 + HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(hip);
		add(leg);
	}
	
	/* Method: drawLeftFoot */
	private void drawLeftFoot() {
		GLine foot = new GLine(appWidth / 2 - HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, appWidth / 2 - HIP_WIDTH - FOOT_LENGTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(foot);
	}
		
	/* Method: drawRightFoot */
	private void drawRightFoot() {
		GLine foot = new GLine(appWidth / 2 + HIP_WIDTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, appWidth / 2 + HIP_WIDTH + FOOT_LENGTH, appHeight * 0.204 + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(foot);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

    /* Instance variables */
    private static String wrongLetters;
    private static Hangman hangman = new Hangman(); //Create another instance of Hangman class. Only class variables are shared by different instances. Therefore, String display must be a class variable. Need "static" in front of it.
    private static int appWidth = hangman.getApplicationWidth() / 2;
    private static int appHeight = hangman.getApplicationHeight();
    private static GLabel letterBoard, displayBoard;
}
