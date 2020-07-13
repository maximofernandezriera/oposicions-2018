/**
 * Model object for a Cell of a ChessBoard.
 *
 * @author Maximo Fernandez Riera
 *         Taller JAVA para iniciados a la programación
 *         Universitat Oberta de Catalunya (UOC)
 * @version 4.0
 */
public class Cell {

	public static boolean WHITE = true;
	public static boolean BLACK = false;

	private static String white = "\u2591";
	private static String black = "\u2588";

	private Piece piece;
	private boolean colour;
	private char coordX;
	private char coordY;

	/**
	 * Default constructor
	 * 
	 * @param colour the colour of the Cell.
	 * @param piece  the Piece assigned to the Cell.
	 * @param x      Cell's x coordinate.
	 * @param y      Cell's y coordinate.
	 */
	public Cell(boolean colour, Piece piece, char x, char y) {
		this.setColour(colour);
		this.setPiece(piece);
		this.coordX = x;
		this.coordY = y;
	}

	/**
	 * Returns the color of the Cell.
	 * 
	 * @return boolean Returns the color of this Cell as a boolean: white = true,
	 *         black = false
	 */
	public boolean getColour() {
		return this.colour;
	}

	/**
	 * Set the colour of the Cell.
	 * 
	 * @param colour Colour must be set as a boolean: white = true, black = false
	 */
	private void setColour(boolean colour) {
		this.colour = colour;
	}

	/**
	 * Method that indicates if some Piece is contained by the Cell
	 * 
	 * @return boolean true means that Cell contains some Piece.
	 */
	public boolean hasPiece() {
		return (this.piece != null);
	}

	/**
	 * Method that set the Piece of the Cell with a null value
	 */
	public void empty() {
		this.piece = null;
	}

	/**
	 * Returns the Piece of the Cell.
	 * 
	 * @return Piece Returns the Piece of this Cel
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Set the Piece of the Cell.
	 * 
	 * @param piece the Piece that is assigned to the Cell
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Returns cell's x coordinate
	 * 
	 * @return char Returns the x position of the cell
	 */
	public char getCoordX() {
		return this.coordX;
	}

	/**
	 * Returns cell's y coordinate
	 * 
	 * @return char Returns the y position of the cell
	 */
	public char getCoordY() {
		return this.coordY;
	}

	/**
	 * Returns the graphical representation of the Cell.
	 * 
	 * @return String Every Cell is represented by a its colour and the Piece which
	 *         contains.
	 */
	public String toString() {

		/* true = white, false = black */
		String colour = (this.colour ? white : black);
		String piece = " ";

		if (this.getPiece() != null) {
			piece = this.getPiece().toString();
		}
		return colour + piece;
	}
}
