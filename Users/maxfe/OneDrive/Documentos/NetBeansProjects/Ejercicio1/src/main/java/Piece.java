
/**
 * Model object for a ChessBoard.
 *
 * @author  Jordi Blasco Planesas<br>
 * Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public abstract class Piece {

    public static final Boolean WHITE = true;
    public static final Boolean BLACK =false;
    protected Boolean color;
    

    public Piece(Boolean col) {
        this.color = col;
    }

    public Boolean getColour() {
        return color;
    }

    private void setColor(Boolean col) {
        this.color = col;
    }

}
