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
    private final String white_cell = "\u2591";
    private final String black_cell = "\u2588";

    private Boolean colour;
    private Piece piece;

    public Cell(Boolean col, Piece pie) {

        if (col == Cell.BLACK) {
            this.setColour(BLACK);
        } else {
            this.setColour(WHITE);
        }

        if (this.getPiece() != null) {
            this.setPiece(pie);
        } else {
            this.empty();
        }
    }

    public boolean hasPiece() {
        if (this.getPiece() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.getPiece() != null) {
            if (this.getColour() == WHITE) {
                sb.append(white_cell + this.getPiece());
            } else {
                sb.append(black_cell + this.getPiece());
            }
        } else {
            if (this.getColour() == WHITE) {
                sb.append(white_cell).append("");
            } else {
                sb.append(black_cell).append("");
            }
        }
        return sb.toString();
    }

    private void empty() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece pie) {
        this.piece = pie;
    }

    public Boolean getColour() {
        return this.colour;
    }

    private void setColour(Boolean col) {
        this.colour = col;
    }

}
