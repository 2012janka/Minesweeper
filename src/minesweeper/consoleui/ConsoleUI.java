package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.Mine;
import minesweeper.core.Tile;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
	/** Playing field. */
	private Field field;

	/** Input reader. */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Reads line of text from the reader.
	 * 
	 * @return line as a string
	 */
	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field
	 * )
	 */
	@Override
	public void newGameStarted(Field field) {
		this.field = field;
		do {
			update();
			processInput();
			// throw new
			// UnsupportedOperationException("Resolve the game state - winning or loosing condition.");
		} while (true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
	@Override
	public void update() {
		System.out.print("  ");
		for (int i = 0; i < field.getRowCount(); i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.print("____________________");
		for (int m = 0; m < field.getRowCount(); m++) {
			System.out.println();
			System.out.printf("%c |", ((char) (m + 'A')));
			for (int n = 0; n < field.getColumnCount(); n++) {
				Tile aktualnaDlazdica = field.getTile(m, n);
				if (aktualnaDlazdica.getState() == Tile.State.OPEN
						&& aktualnaDlazdica instanceof Mine) {
					System.out.print("X ");
				} else if (aktualnaDlazdica.getState() == Tile.State.OPEN
						&& aktualnaDlazdica instanceof Clue) {
					System.out
							.print(((Clue) aktualnaDlazdica).getValue() + " ");
				} else if (aktualnaDlazdica.getState() == Tile.State.MARKED) {
					System.out.print("M ");
				} else if (aktualnaDlazdica.getState() == Tile.State.CLOSED) {
					System.out.print("- ");
				}
			}
		}
	}

	/**
	 * Processes user input. Reads line from console and does the action on a
	 * playing field according to input string.
	 */
	private void processInput() {
		Pattern INPUT_PATTERN = Pattern
				.compile("X|(M)([A-I])([0-8])|(O)([A-I])([0-8])");
		System.out.println();
		System.out
				.println("Please enter your selection <X> EXIT, <MA1> MARK, <OB4> OPEN : ");
		String value = readLine();
		//Formatter f = new Formatter();
		Matcher matcher = INPUT_PATTERN.matcher(value);
		if (matcher.matches()) {
			String vyber1 = matcher.group(1);
			String vyber2 = matcher.group(2);
			String vyber3= matcher.group(3);
			String vyber4 = matcher.group(4);
			String vyber5= matcher.group(5);
			String vyber6 = matcher.group(6);
			if (value.equals("X")) {
				System.exit(0);
			}
			else if (vyber1.equals("M")) {


			}	
			else if (vyber4.equals("O")) {
				
			}

		} else {
			System.out.println("Wrong input!");
		}
		System.exit(0);
	}
}
