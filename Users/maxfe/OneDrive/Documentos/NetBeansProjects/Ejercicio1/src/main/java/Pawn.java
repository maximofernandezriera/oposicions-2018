
public class Pawn extends Piece {

    //contendrá dos constantes con su representación gráfica en blanco y en negro.
    private static final String WHITE = "\u25CB";
    private static final String BLACK = "\u25CF";

    public Pawn(Boolean color) {

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
