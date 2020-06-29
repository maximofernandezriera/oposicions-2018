import java.util.Objects;

/**
 * Model object for ChessPlayer.
 *
 * @author Máximo Fernández Riera<br
 * Taller de Java para programadores<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public abstract class Piece {

    public static final Boolean WHITE = true;
    public static final Boolean BLACK = false;
    protected Boolean color;

    public Piece(Boolean col) {
        if (Objects.equals(col, WHITE)) {
            this.setColor(WHITE);
        } else {
            this.setColor(BLACK);
        }
    }

    public Boolean getColour() {
        return color;
    }

    private void setColor(Boolean col) {
        this.color = col;
    }

}
