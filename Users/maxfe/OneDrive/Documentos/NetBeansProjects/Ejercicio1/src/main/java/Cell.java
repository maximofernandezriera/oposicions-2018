
import java.util.Objects;

/**
 * Model object for a ChessBoard.
 *
 * @author Jordi Blasco Planesas<br>
 * Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public class Cell {

    static final Boolean WHITE = true;
    static final Boolean BLACK = false;

    private Boolean colour;
    private Piece piece;

    public Cell(Boolean col, Piece pie) {

        if (col == Cell.BLACK) {
            this.setColour(BLACK);
        } else {
            this.setColour(WHITE);
        }

        if (piece == null) {
            this.empty();
        } else {
            this.setPiece(pie);
        }
    }

    public boolean hasPiece() {
        if (this.piece != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.piece != null) {   //        &&  (piece instanceof Pawn) {   
            return this.getColour()+ piece.toString();
        } else {
            return this.toString() + "  ";
        }
    }

    private void empty() {
        this.piece = null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece pie) {
        this.piece = pie;
    }

    public Boolean getColour() {
        return piece.getColour();
    }

    private void setColour(Boolean col) {
        this.colour = col;
    }

}
