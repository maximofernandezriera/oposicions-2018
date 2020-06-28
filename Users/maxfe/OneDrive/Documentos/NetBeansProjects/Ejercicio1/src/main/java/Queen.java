
public class Queen extends Piece {

    //contendrá dos constantes con su representación gráfica en blanco y en negro.
    private static final String WHITE_QUEEN = "\u25CE";
    private static final String BLACK_QUEEN = "\u25C9";

    public Queen(Boolean color) {

        super(color);
    }

    @Override
    public String toString() {
        if (this.getColour().equals(Queen.WHITE)) {
            return WHITE_QUEEN;
        } else {
            return BLACK_QUEEN;
        }
    }

}
