import static org.junit.Assert.*;

import java.util.Random;

import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.Mine;
import minesweeper.core.Tile;

import org.junit.Test;

public class TestField { // pocet riadkov, pocet stlpcov, pocet min, getMineCount, ci Clues
							// maju spravne nastavene hodnoty

	@Test
	public void testGenerateNumberOfRows() {

		Random cislo = new Random();
		int rows = cislo.nextInt(20) + 1;
		int columns = cislo.nextInt(20) + 1;
		int mines = cislo.nextInt(rows * columns);
		System.out.println(1 + "riadky: " + rows + " stlpce: " + columns
				+ " miny: " + mines);

		Field testField = new Field(rows, columns, mines);
		assertTrue(rows == testField.getRowCount());
	}

	@Test
	public void testGenerateNumberOfColumns() {

		Random cislo = new Random();
		int rows = cislo.nextInt(20) + 1;
		int columns = cislo.nextInt(20) + 1;
		int mines = cislo.nextInt(rows * columns);
		System.out.println(2 + "riadky: " + rows + " stlpce: " + columns
				+ " miny: " + mines);

		Field testField = new Field(rows, columns, mines);

		assertTrue(columns == testField.getColumnCount());
	}

	@Test
	public void testGenerateNumberOfMines() {
		int pocetMinVTestovacomPoli = 0;

		Random cislo = new Random();
		int rows = cislo.nextInt(20) + 1;
		int columns = cislo.nextInt(20) + 1;
		int mines = cislo.nextInt(rows * columns);
		System.out.println(3 + "riadky: " + rows + " stlpce: " + columns
				+ " miny: " + mines);

		Field testField = new Field(rows, columns, mines);
		for (int m = 0; m < testField.getRowCount(); m++) {
			for (int n = 0; n < testField.getColumnCount(); n++) {
				if (testField.getTile(m, n) instanceof Mine) {
					pocetMinVTestovacomPoli++;
				}
			}
		}
		assertTrue(pocetMinVTestovacomPoli == mines);
	}

	@Test
	public void testGenerateMineCount() {
		int pocetMinVTestovacomPoli = 0;

		Random cislo = new Random();
		int rows = cislo.nextInt(20) + 1;
		int columns = cislo.nextInt(20) + 1;
		int mines = cislo.nextInt(rows * columns);
		System.out.println(4 + "riadky: " + rows + " stlpce: " + columns
				+ " miny: " + mines);

		Field testField = new Field(rows, columns, mines);
		for (int m = 0; m < testField.getRowCount(); m++) {
			for (int n = 0; n < testField.getColumnCount(); n++) {
				if (testField.getTile(m, n) instanceof Mine) {
					pocetMinVTestovacomPoli++;
				}
			}
		}
		assertTrue(pocetMinVTestovacomPoli == testField.getMineCount());
	}

	@Test
	public void testGenerateClues() {
		Random cislo = new Random();
		int rows = cislo.nextInt(20) + 1;
		int columns = cislo.nextInt(20) + 1;
		int mines = cislo.nextInt(rows * columns);

		System.out.println(5 + "riadky: " + rows + " stlpce: " + columns
				+ " miny: " + mines);
		int testClue = 0;

		Field testField = new Field(rows, columns, mines);

		for (int m = 0; m < testField.getRowCount(); m++) {
			for (int n = 0; n < testField.getColumnCount(); n++) {
				if (testField.getTile(m, n) instanceof Clue) {
					testClue = ((Clue) testField.getTile(m, n)).getValue();
					int count = 0;
					for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
						int actRow = m + rowOffset;
						if (actRow >= 0 && actRow < testField.getRowCount()) {
							for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
								int actColumn = n + columnOffset;
								if (actColumn >= 0
										&& actColumn < testField
												.getColumnCount()) {
									if (testField.getTile(actRow, actColumn) instanceof Mine) {
										count++;
									}
								}
							}
						}
					}
					assertTrue(testClue == count);
				}
			}
		}
	}

	/*
	 * public void test() { fail("Not yet implemented"); }
	 */

}
