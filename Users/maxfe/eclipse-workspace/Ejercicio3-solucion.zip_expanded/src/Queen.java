import java.util.ArrayList;

/**
 * Model object for Queen piece in the board game of Chess. It extends all the
 * attributes and methods of the parent class Piece.
 *
 * @author Maximo Fernandez Riera
 *         Taller JAVA para iniciados a la programación
 *         Universitat Oberta de Catalunya (UOC)
 * @version 4.0
 */
public class Queen extends Piece {

	final String white_queen = "\u25CE";
	final String black_queen = "\u25C9";
	// final String white_queen = "Q";
	// final String black_queen = "q";

	/**
	 * Queen's piece constructor. It set its parent colour attribute.
	 * 
	 * @param colour the colour of the Queen.
	 */
	public Queen(boolean colour) {
		super(colour);
	}

	/**
	 * Returns the graphical representation of Queen piece.
	 * 
	 * @return String the graphical representation of Queen, which can be black or
	 *         white.
	 */
	public String toString() {
		if (this.getColour()) {
			return this.white_queen;
		} else {
			return this.black_queen;
		}
	}

	/**
	 * Returns an ArrayList with all the cells where Queen can move.
	 * 
	 * @param chessBoard the board of the game.
	 * @return ArrayList with the available cells where Queen can be moved.
	 */
	public ArrayList<Cell> getMoves(ChessBoard chessBoard) throws CheckersException {

		// ToDo
		return null;
	}
}
