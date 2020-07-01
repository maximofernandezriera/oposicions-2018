@SuppressWarnings("serial")
public class CheckersException extends Exception {

	
	public CheckersException(String incorrectMove) {
		// TODO Auto-generated constructor stub
	}

	public static final String INCORRECT_MOVE_VALUE = "Cannot Move a piece Without a player or an origin or destination square name.;";
	public static final String INCORRECT_CELL_SELECTION = null;
	public static final String NO_STARTED_GAME = "Cannot start a game without its initialization";
	public static final String INCORRECT_OPTION = null;
	
}