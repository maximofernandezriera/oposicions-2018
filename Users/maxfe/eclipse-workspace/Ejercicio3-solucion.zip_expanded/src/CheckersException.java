/**
 * Model object for the own exception of the game: CheckersException.
 *
 * @author Maximo Fernandez Riera
 *         Taller JAVA para iniciados a la programación
 *         Universitat Oberta de Catalunya (UOC)
 * @version 4.0
 */
public class CheckersException extends Exception {

	private static final long serialVersionUID = -7050888282833067214L;

	public final static String NO_STARTED_GAME = ">> The game is not started";
	public final static String INCORRECT_OPTION = ">> The selected option is not available";
	public final static String INCORRECT_CELL_SELECTION = ">> The selected cell is out of bounds";
	public final static String INCORRECT_MOVE_VALUE = ">> The move has an incorrect format";
	public final static String NO_PIECE_ON_CELL = ">> There´s no piece on initial position - ";
	public final static String PLAYER_MUST_MOVE_HIS_PIECES = ">> Player only can move his pieces - Its turn for ";
	public final static String ILEGAL_MOVE = ">> The move is ilegal";
	public final static String GAME_STILL_IN_PLAY = ">> The game is still in play, there's no winner yet";

	/**
	 * CheckersException's constructor, with no param
	 */
	public CheckersException() {
		super();
	}

	/**
	 * CheckersException's constructor. It set its message attribute.
	 * 
	 * @param message the message of the CheckersException
	 */
	public CheckersException(String message) {
		super(message);
	}

	/**
	 * CheckersException's constructor. It set its message and info attributes.
	 * 
	 * @param message the message of the CheckersException
	 * @param info    the info of the CheckersException
	 */
	public CheckersException(String message, String info) {
		super(message + info);
	}
}
