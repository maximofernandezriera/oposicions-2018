
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

    private static final Boolean WHITE = true;
    private static final Boolean BLACK = false;

    private Boolean colour;
    private Piece piece;

    public Cell(Boolean col, Piece pie) {

        if (col == Cell.BLACK) {
            this.setColour(BLACK);
        } else {
            setColour(WHITE);
        }

        if (pie == null) {
            this.empty();
        }
        this.setPiece(pie);
    }

    public boolean hasPiece() {
        if (piece != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.piece != null) {
            return colour.toString() + piece.toString();
        } else {
            return "  ";
        }
    }

    private void empty() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    protected void setPiece(Piece pie) {
        this.piece = pie;
    }

    public Boolean getColour() {
        return piece.getColour();
    }

    private void setColour(Boolean col) {
        piece.color = col;
    }

}
