package myTrial;

import java.util.Scanner;

/**
 * Tic-Tac-Toe: Two-player console, non-graphics, non-OO version. All
 * variables/methods are declared as static (belong to the class) in the non-OO
 * version.
 */
public class TTTConsoleNonOO2P {
	// Name-constants to represent the seeds and cell contents
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int NOUGHT = 2;

	// Name-constants to represent the various states of the game
	public static final int PLAYING = 0;
	public static final int DRAW = 1;
	public static final int CROSS_WON = 2;
	public static final int NOUGHT_WON = 3;

	// The game board and the game status
	public static int currentState; // the current state of the game
									// (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
	public static int currentPlayer; // the current player (CROSS or NOUGHT)
	public static int currentRow; // current seed's row
	public static int currentCol; // current seed's column

	public static Scanner in = new Scanner(System.in); // the input Scanner

	// ---------tambahan sendiri-----------//
	public static int DIMENSION;
	public static int[][] board;

	/** The entry main method (the program starts here) */
	public static void main(String[] args) {
		System.out.print("Please enter the board dimension : ");
		DIMENSION = in.nextInt();
		board = new int[DIMENSION][DIMENSION];
		// Initialize the game-board and current status
		initGame();
		// Play the game once
		do {
			playerMove(currentPlayer); // update currentRow and currentCol
			updateGame(currentPlayer, currentRow, currentCol); // update currentState
			printBoard(getHorizontalPartition());
			// Print message if game-over
			if (currentState == CROSS_WON) {
				System.out.println("'X' won! Bye!");
			} else if (currentState == NOUGHT_WON) {
				System.out.println("'O' won! Bye!");
			} else if (currentState == DRAW) {
				System.out.println("It's a Draw! Bye!");
			}
			// Switch player
			currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
		} while (currentState == PLAYING); // repeat if not game-over
	}

	/** Initialize the game-board contents and the current states */
	private static void initGame() {
		for (int row = 0; row < DIMENSION; ++row) {
			for (int col = 0; col < DIMENSION; ++col) {
				board[row][col] = EMPTY; // all cells empty
			}
		}
		currentState = PLAYING; // ready to play
		currentPlayer = CROSS; // cross plays first
	}

	/**
	 * Player with the "theSeed" makes one move, with input validation. Update
	 * global variables "currentRow" and "currentCol".
	 */
	private static void playerMove(int theSeed) {
		boolean validInput = false; // for input validation
		do {
			if (theSeed == CROSS) {
				System.out
						.print("Player 'X', enter your move (row[1-" + DIMENSION + "] column[1-" + DIMENSION + "]): ");
			} else {
				System.out
						.print("Player 'O', enter your move (row[1-" + DIMENSION + "] column[1-" + DIMENSION + "]): ");
			}
			int row = in.nextInt() - 1; // array index starts at 0 instead of 1
			int col = in.nextInt() - 1;
			if (row >= 0 && row < DIMENSION && col >= 0 && col < DIMENSION && board[row][col] == EMPTY) {
				currentRow = row;
				currentCol = col;
				board[currentRow][currentCol] = theSeed; // update game-board content
				validInput = true; // input okay, exit loop
			} else {
				System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
			}
		} while (!validInput); // repeat until input is valid
	}

	/**
	 * Update the "currentState" after the player with "theSeed" has placed on
	 * (currentRow, currentCol).
	 */
	private static void updateGame(int theSeed, int currentRow, int currentCol) {
		if (hasWon(theSeed, currentRow, currentCol)) { // check if winning move
			currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
		} else if (isDraw()) { // check for draw
			currentState = DRAW;
		}
		// Otherwise, no change to currentState (still PLAYING).
	}

	/** Return true if it is a draw (no more empty cell) */
	// TODO: Shall declare draw if no player can "possibly" win
	private static boolean isDraw() {
		for (int row = 0; row < DIMENSION; ++row) {
			for (int col = 0; col < DIMENSION; ++col) {
				if (board[row][col] == EMPTY) {
					return false; // an empty cell found, not draw, exit
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	/**
	 * Return true if the player with "theSeed" has won after placing at
	 * (currentRow, currentCol)
	 */
	private static boolean hasWon(int theSeed, int currentRow, int currentCol) {
		return (isHorizontallyComplete(theSeed, currentRow) || isVerticallyComplete(theSeed, currentCol)
				|| currentRow == currentCol // 3-in-the-diagonal
						&& isDiagonallyComplete(theSeed)
				|| currentRow + currentCol == DIMENSION - 1 // 3-in-the-opposite-diagonal
						&& isDiagonallyOppositeComplete(theSeed));
	}

	private static boolean isHorizontallyComplete(int theSeed, int currentRow) {
		for (int i = 0; i < DIMENSION; i++) {
			if (board[currentRow][i] != theSeed) {
				return false;
			}
		}
		return true;
	}

	private static boolean isVerticallyComplete(int theSeed, int currentCol) {
		for (int i = 0; i < DIMENSION; i++) {
			if (board[i][currentCol] != theSeed) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDiagonallyComplete(int theSeed) {
		for (int i = 0; i < DIMENSION; i++) {
			if (board[i][i] != theSeed) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDiagonallyOppositeComplete(int theSeed) {
		for (int i = 0; i < DIMENSION; i++) {
			if (board[i][DIMENSION - i - 1] != theSeed) {
				return false;
			}
		}
		return true;
	}

	/** Print the game board */
	private static void printBoard(String horizontalPartition) {
		for (int row = 0; row < DIMENSION; ++row) {
			for (int col = 0; col < DIMENSION; ++col) {
				printCell(board[row][col]); // print each of the cells
				if (col != DIMENSION - 1) {
					System.out.print("|"); // print vertical partition
				}
			}
			System.out.println();
			if (row != DIMENSION - 1) {
				System.out.println(horizontalPartition); // print horizontal partition
			}
		}
		System.out.println();
	}

	private static String getHorizontalPartition() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < DIMENSION; i++) {
			sb.append("---");
			if (i < DIMENSION - 1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}

	/** Print a cell with the specified "content" */
	private static void printCell(int content) {
		switch (content) {
		case EMPTY:
			System.out.print("   ");
			break;
		case NOUGHT:
			System.out.print(" O ");
			break;
		case CROSS:
			System.out.print(" X ");
			break;
		}
	}
}