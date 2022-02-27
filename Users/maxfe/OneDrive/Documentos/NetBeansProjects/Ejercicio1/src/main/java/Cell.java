/**
 * Model object for ChessPlayer.
 *
 * @author Máximo Fernández Riera<br
 * Taller de Java para programadores<br>
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
        return this.getPiece() != null;
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

    public void empty() {
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
