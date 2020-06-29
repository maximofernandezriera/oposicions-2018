/**
 * Model object for ChessPlayer.
 *
 * @author Máximo Fernández Riera<br
 * Taller de Java para programadores<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public class Pawn extends Piece {

    //contendrá dos constantes con su representación gráfica en blanco y en negro.
    private static final String WHITE_PAWN = "\u25CB";
    private static final String BLACK_PAWN = "\u25CF";

    public Pawn(Boolean color) {

        super(color);
    }

    @Override
    public String toString() {
        if (this.getColour().equals(Pawn.WHITE)) {
            return WHITE_PAWN;
        } else {
            return BLACK_PAWN;
        }
    }
}
