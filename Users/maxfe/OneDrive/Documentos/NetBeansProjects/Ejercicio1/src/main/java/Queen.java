
public class Queen extends Piece {

    //contendrá dos constantes con su representación gráfica en blanco y en negro.
    private static final String WHITE = "\u25CE";
    private static final String BLACK = "\u25C9";

    public Queen(Boolean color) {

        super(color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queen q = new Queen(true);
        if (q.getColour().equals(Piece.WHITE)) {
            sb.append(WHITE);
        } else {
            sb.append(BLACK);
        }
        return sb.toString();
    }

}
