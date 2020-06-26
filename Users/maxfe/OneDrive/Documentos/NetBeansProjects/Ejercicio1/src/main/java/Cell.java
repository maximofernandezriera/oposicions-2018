
/**
 * Model object for a ChessBoard.
 *
 * @author  Jordi Blasco Planesas<br>
 * Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public class Cell {

    private static final Boolean BLACK = false;
    private static final Boolean WHITE = true;

    private Piece piece;

    public Cell(Boolean col, Piece p) {

        if (col = WHITE) {
            this.setColour(WHITE);
        } else {
            this.setColour(BLACK);
        }

        if (p != null) {
            this.empty();
        }

        this.setPiece(p);
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
        if (piece == null) {
            return "  ";
        }
        return piece.toString();
    }

    private void empty() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Boolean getColour() {
        return piece.getColour();
    }

    private void setColour(Boolean col) {
        piece.color = col;
    }

}
