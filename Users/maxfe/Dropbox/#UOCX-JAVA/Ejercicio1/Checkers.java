import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Model object for ChessPlayer.
 *
 * @author  Jordi Blasco Planesas<br>
 *          Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 *          Universitat Oberta de Catalunya (UOC)
 * @version  2.0
 */
public class Checkers {

   /**
    * Main method creates a ChessBoard object and prints it
    * using its toString() method
    * @param args Unused.
    * @return Nothing.
    * @exception UnsupportedEncodingException On encoding error.
    */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		ChessBoard cb = new ChessBoard();
		out.println(cb.toString());
	}
}