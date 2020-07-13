import java.util.ArrayList;

/**
 * Model object for a ChessBoard.
 *
 * @author Maximo Fernandez Riera
 *         Taller JAVA para iniciados a la programación
 *         Universitat Oberta de Catalunya (UOC)
 * @version 4.0
 */
public class ChessBoard {

	private final String horizontal = "\u2500";
	private final String vertical = "\u2502";
	private final String top = "\u252C";
	private final String bottom = "\u2534";
	private final String left = "\u251C";
	private final String right = "\u2524";
	private final String center = "\u253C";
	private final String top_left = "\u250C";
	private final String top_right = "\u2510";
	private final String bottom_left = "\u2514";
	private final String bottom_right = "\u2518";
	private final String NL = System.getProperty("line.separator");

	public final static char min_row = '1';
	public final static char max_row = '8';
	public final static char min_col = 'a';
	public final static char max_col = 'h';
	public final static int EMPTY = 0;
	public final static int OUT_OF_BOARD = 1;
	public final static int SAME_COLOUR = 2;
	public final static int OTHER_COLOUR = 3;

	private Cell[][] board;
	private ArrayList<Piece> killedWhite;
	private ArrayList<Piece> killedBlack;
	private Boolean winnerColour = null;
	public ArrayList<String> moves;
	private Boolean pendingMovesToWrite = null;

	/**
	 * Default constructor. It initializes the ChessBoard and distributes all the
	 * pieces on.
	 */
	public ChessBoard() throws CheckersException {
		board = new Cell[max_col - min_col + 1][max_row - min_row + 1];
		this.killedBlack = new ArrayList<Piece>();
		this.killedWhite = new ArrayList<Piece>();
		this.moves = new ArrayList<String>();
		this.pendingMovesToWrite = false;
		this.initializeBoard();
		this.initializePieces();
	}

	/**
	 * El método getMoves() retornará el ArrayList<String> del nuevo atributo
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getMoves() {

		return this.moves;
	}

	/**
	 * Accesor de pendingMovesToWrite
	 */
	public boolean isPendingMovesToWrite() {
		if (!this.moves.isEmpty())
			pendingMovesToWrite = true;
		return pendingMovesToWrite;
	}

	/**
	 * Accesor de pendingMovesToWrite
	 */

	public void setPendingMovesToWrite(boolean pendingMovesToWrite) {
		this.pendingMovesToWrite = pendingMovesToWrite;
	}

	/**
	 * Initialize the ChessBoard. Method that initialize an 8x8 Cell array with 32
	 * white cells and 32 black ones.
	 */
	private void initializeBoard() {

		for (char i = max_row; i >= min_row; i--) {
			for (char j = min_col; j <= max_col; j++) {
				if ((i + j) % 2 != 0)
					board[j - min_col][i - min_row] = new Cell(Cell.WHITE, null, j, i);
				else
					board[j - min_col][i - min_row] = new Cell(Cell.BLACK, null, j, i);
			}
		}
	}

	/**
	 * Initialize all the pieces and put them on their initial positions (cells).
	 * 
	 * @exception CheckersException if the initial position of the pieces are not
	 *                              valid: it means out of range [a..h][1..8]
	 */
	private void initializePieces() throws CheckersException {

		this.setPiece(new Pawn(Piece.BLACK), "b8");
		this.setPiece(new Pawn(Piece.BLACK), "d8");
		this.setPiece(new Pawn(Piece.BLACK), "f8");
		this.setPiece(new Pawn(Piece.BLACK), "h8");
		this.setPiece(new Pawn(Piece.BLACK), "a7");
		this.setPiece(new Pawn(Piece.BLACK), "c7");
		this.setPiece(new Pawn(Piece.BLACK), "e7");
		this.setPiece(new Pawn(Piece.BLACK), "g7");
		this.setPiece(new Pawn(Piece.BLACK), "b6");
		this.setPiece(new Pawn(Piece.BLACK), "d6");
		this.setPiece(new Pawn(Piece.BLACK), "f6");
		this.setPiece(new Pawn(Piece.BLACK), "h6");

		this.setPiece(new Pawn(Piece.WHITE), "a3");
		this.setPiece(new Pawn(Piece.WHITE), "c3");
		this.setPiece(new Pawn(Piece.WHITE), "e3");
		this.setPiece(new Pawn(Piece.WHITE), "g3");
		this.setPiece(new Pawn(Piece.WHITE), "b2");
		this.setPiece(new Pawn(Piece.WHITE), "d2");
		this.setPiece(new Pawn(Piece.WHITE), "f2");
		this.setPiece(new Pawn(Piece.WHITE), "h2");
		this.setPiece(new Pawn(Piece.WHITE), "a1");
		this.setPiece(new Pawn(Piece.WHITE), "c1");
		this.setPiece(new Pawn(Piece.WHITE), "e1");
		this.setPiece(new Pawn(Piece.WHITE), "g1");

	}

	/**
	 * Returns the Cell of the ChessBoard located at position indicated.
	 * 
	 * @param position the position of the Cell on ChessBoard.
	 * @return Cell Returns the Cell located at position mentioned.
	 * @exception CheckersException if the position is not valid.
	 */
	public Cell getCell(String position) throws CheckersException {

		char x = getX(position);
		char y = getY(position);

		if ((x < min_col) || (x > max_col)) {
			throw new CheckersException(CheckersException.INCORRECT_CELL_SELECTION);
		}
		if ((y < min_row) || (y > max_row)) {
			throw new CheckersException(CheckersException.INCORRECT_CELL_SELECTION);
		}
		return board[x - min_col][y - min_row];
	}

	/**
	 * Set the Piece on a position of the ChessBoard
	 * 
	 * @param piece    The Piece to be set
	 * @param position The position where the Piece is located
	 * @exception CheckersException if the position is not valid
	 */
	private void setPiece(Piece piece, String position) throws CheckersException {
		Cell cell = this.getCell(position);
		cell.setPiece(piece);
		piece.setCell(cell);
	}

	/**
	 * Method which move a Piece from an initial position to a final position. The
	 * initial position on ChessBoard will be empty after the moving. This method
	 * also checks if the desired move is into the ArrayList of possible positions,
	 * returned by the Piece. In case of killing opponent piece, it will be moved to
	 * the corresponding killed-pieces ArrayList.
	 * 
	 * @param initialPosition The initial position where the Piece resides.
	 * @param finalPosition   The final position where the Piece will be moved.
	 * @exception CheckersException in the following cases : - initialPosition or
	 *                              finalPosition are wrong - if initialPosition is
	 *                              empty - if player is not moving his pieces - if
	 *                              the player tries to do an ilegal move.
	 */
	public boolean movePiece(String initialPosition, String finalPosition, boolean player) throws CheckersException {

		boolean returnValue = true;
		// Check if the cell has a piece on it
		Cell initialCell = getCell(initialPosition);
		Cell finalCell = getCell(finalPosition);
		// para que cada vez que se haga un movimiento correcto, este se añada al nuevo
		// atributo ArrayList.
		this.moves.add(initialPosition + " " + finalPosition + "\n");
		this.pendingMovesToWrite = true;

		if (!initialCell.hasPiece()) {
			throw new CheckersException(CheckersException.NO_PIECE_ON_CELL, initialPosition);
		}
		Piece initialPiece = initialCell.getPiece();

		// Check if the player is moving any of his pieces
		if (player != initialPiece.getColour()) {
			throw new CheckersException(CheckersException.PLAYER_MUST_MOVE_HIS_PIECES, player ? "WHITE" : "BLACK");
		}

		ArrayList<Cell> posiblePositions = initialPiece.getMoves(this);
		if (posiblePositions.contains(finalCell)) {
			Cell previousCell = this.getPreviousCell(initialPosition, finalPosition);
			if (previousCell != null && previousCell.hasPiece()) {

				// kill white piece
				if (previousCell.getPiece().getColour() == Piece.WHITE) {
					killedWhite.add(previousCell.getPiece());
					previousCell.empty();

					// kill black piece
				} else {
					killedBlack.add(previousCell.getPiece());
					previousCell.empty();
				}

				if (this.killedBlack.size() == Piece.TOTAL_BLACK_PIECES) {
					this.winnerColour = new Boolean(Piece.WHITE);
					returnValue = false;

				} else if (this.killedWhite.size() == Piece.TOTAL_BLACK_PIECES) {
					this.winnerColour = new Boolean(Piece.BLACK);
					returnValue = false;
				}

			}

			initialPiece.move(finalCell);
			if (finalCell.getCoordY() == '1') {
				finalCell.setPiece(new Queen(Piece.BLACK));
			} else if (finalCell.getCoordY() == '8') {
				finalCell.setPiece(new Queen(Piece.WHITE));
			} else {
				finalCell.setPiece(initialPiece);
			}

			initialCell.empty();
		} else {
			throw new CheckersException(CheckersException.ILEGAL_MOVE);
		}
		return returnValue;
	}

	/**
	 * Method which get the Cell located between initialPosition and finalPosition.
	 * 
	 * @param initialPosition The initial position where the Piece resides.
	 * @param finalPosition   The final position where the Piece will be moved.
	 * @return Cell Returns the Cell located located between both positions.
	 * @exception CheckersException is throwed by getCell(position) method.
	 */
	private Cell getPreviousCell(String initialPosition, String finalPosition) throws CheckersException {

		char initialX = this.getX(initialPosition);
		char initialY = this.getY(initialPosition);
		char finalX = this.getX(finalPosition);
		char finalY = this.getY(finalPosition);

		if (finalX - initialX == 2 && finalY - initialY == 2) {

			char auxX = (char) (finalX - 1);
			char auxY = (char) (finalY - 1);
			String auxPosition = auxX + "" + auxY + "";
			return this.getCell(auxPosition);

		} else if (finalX - initialX == 2 && finalY - initialY == -2) {

			char auxX = (char) (finalX - 1);
			char auxY = (char) (finalY + 1);
			String auxPosition = auxX + "" + auxY;
			return this.getCell(auxPosition);

		} else if (finalX - initialX == -2 && finalY - initialY == 2) {

			char auxX = (char) (finalX + 1);
			char auxY = (char) (finalY - 1);
			String auxPosition = auxX + "" + auxY;
			return this.getCell(auxPosition);

		} else if (finalX - initialX == -2 && finalY - initialY == -2) {

			char auxX = (char) (finalX + 1);
			char auxY = (char) (finalY + 1);
			String auxPosition = auxX + "" + auxY;
			return this.getCell(auxPosition);
		}

		return null;
	}

	/**
	 * This method analyze the next possible move of a Piece, and returns an integer
	 * depending on some situations.
	 * 
	 * @param newX          the x-coord where we want to move our Piece
	 * @param newY          the y-coord where we want to move our Piece
	 * @param currentColour the colour of current Piece we want to move
	 * @return int according to next situations : 0 : destination position is empty.
	 *         1 : destination position out of board. 2 : destination position
	 *         contains a same colour Piece. 3 : destination position contains an
	 *         another colour Piece.
	 * @exception CheckersException if the position, composed by newX and newY, is
	 *                              not valid
	 */
	public int nextMove(char newX, char newY, boolean currentColour) throws CheckersException {

		if ((newX <= max_col) && (newY <= max_row) && (newX >= min_col) && (newY >= min_row)) {
			if (this.getCell("" + newX + newY).hasPiece()) {
				if (currentColour != this.getCell("" + newX + newY).getPiece().getColour()) {
					return OTHER_COLOUR;
				} else
					return SAME_COLOUR;
			} else
				return EMPTY;
		}
		return OUT_OF_BOARD;
	}

	/**
	 * Returns the x-axis of a position on ChessBoard.
	 * 
	 * @param position a position on ChessBoard.
	 * @return int Returns the x-axis of a position.
	 */
	private char getX(String position) {
		return position.charAt(0);
	}

	/**
	 * Returns the y-axis of a position on ChessBoard.
	 * 
	 * @param position a position on ChessBoard.
	 * @return int Returns the y-axis of a position.
	 */
	private char getY(String position) {
		return position.charAt(1);
	}

	/**
	 * Returns the graphical representation of the ChessBoard.
	 * 
	 * @return String with the graphical representation of a ChessBoard.
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder(478);
		StringBuilder line_letters = new StringBuilder(2);
		StringBuilder line_top = new StringBuilder(27);
		StringBuilder line_middle = new StringBuilder(28);
		StringBuilder line_bottom = new StringBuilder(27);
		StringBuilder lines = new StringBuilder(252);

		line_letters.append("   ");
		for (char i = min_col; i <= max_col; i++) {
			line_letters.append(i).append("  ");
		}
		line_letters.append(" Killed pieces").append(NL);

		line_top.append(" ").append(top_left);
		for (int i = min_col; i < max_col; i++) {
			line_top.append(horizontal).append(horizontal).append(top);
		}
		line_top.append(horizontal).append(horizontal).append(top_right).append(NL);

		line_middle.append(" ").append(left);
		for (int i = min_col; i < max_col; i++) {
			line_middle.append(horizontal).append(horizontal).append(center);
		}
		line_middle.append(horizontal).append(horizontal).append(right).append(NL);

		line_bottom.append(" ").append(bottom_left);
		for (int i = min_col; i < max_col; i++) {
			line_bottom.append(horizontal).append(horizontal).append(bottom);
		}
		line_bottom.append(horizontal).append(horizontal).append(bottom_right).append(NL);

		for (int i = max_row; i >= min_row; i--) {
			lines.append(i - min_row + 1);
			for (int x = min_col; x <= max_col; x++) {
				lines.append(vertical).append(this.board[x - min_col][i - min_row].toString());
			}
			lines.append(vertical).append(i - min_row + 1);
			if (i == max_row) {
				lines.append(" ").append(killedBlack.toString());
			}
			if (i == min_row) {
				lines.append(" ").append(killedWhite.toString());
			}
			lines.append(NL);
			if (i != min_row) {
				lines.append(line_middle);
			}
		}

		sb.append(line_letters).append(line_top).append(lines).append(line_bottom).append(line_letters);

		return sb.toString();
	}

	/**
	 * This method checks if a winner exists and returns his colour
	 * 
	 * @return boolean the colour pieces of the winner
	 * @exception CheckersException if the game is still in play
	 */
	public boolean getWinnerColour() throws CheckersException {
		if (this.winnerColour == null) {
			throw new CheckersException(CheckersException.GAME_STILL_IN_PLAY);
		}
		return winnerColour.booleanValue();
	}
}
