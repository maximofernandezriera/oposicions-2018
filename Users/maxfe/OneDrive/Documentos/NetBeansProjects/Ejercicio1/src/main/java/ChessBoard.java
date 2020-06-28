
/**
 * Model object for a ChessBoard.
 *
 * @author  Jordi Blasco Planesas<br>
 * Capacitaci&oacute; digital. Web 2.0 i xarxes socials.<br>
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0
 */
public class ChessBoard {

    private final String horizontal = "\u2500";
    private final String vertical = "\u2502";
    private final String top = "\u252C";
    private final String bottom = "\u2534";
    private final String left = "\u251C";
    private final String right = "\u2524";
    private final String center = "\u253C";
    private final String top_left = "\u250C";
    private final String top_right = "\u2510";
    private final String bottom_left = "\u2514";
    private final String bottom_right = "\u2518";
    private final String NL = System.getProperty("line.separator");
    private final String space = " ";

    private final String white_cell = "\u2591";
    private final String black_cell = "\u2588";

    private int rows = 8;
    private char cols = 'a';
    private final Cell[][] cells = new Cell[8][8];
    int positionX;
    int positionY;

    //inicializará el array bidimensional, creará el tablero y dispondrá todas las piezas en su posición inicial 
    public ChessBoard() {
        initializeBoard();
        initializePieces();
    }

    /**
     * Returns the graphical representation of the ChessBoard.
     *
     * @return String with the graphical representation of a ChessBoard.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(486);

        StringBuilder cols_top = new StringBuilder(26);
        cols_top.append(space);
        for (int i = 0; i < 8; i++) {
            cols_top.append(space).append(cols).append(space);
            cols++;
        }
        cols_top.append(NL);

        StringBuilder line_top = new StringBuilder(27);
        line_top.append(space).append(top_left).append(horizontal).append(horizontal).append(top).append(horizontal).append(horizontal)
                .append(top).append(horizontal).append(horizontal).append(top).append(horizontal).append(horizontal)
                .append(top).append(horizontal).append(horizontal).append(top).append(horizontal).append(horizontal)
                .append(top).append(horizontal).append(horizontal).append(top).append(horizontal).append(horizontal)
                .append(top_right).append(NL);

        StringBuilder line_middle = new StringBuilder(27);
        line_middle.append(space).append(left).append(horizontal).append(horizontal).append(center).append(horizontal).append(horizontal)
                .append(center).append(horizontal).append(horizontal).append(center).append(horizontal).append(horizontal)
                .append(center).append(horizontal).append(horizontal).append(center).append(horizontal).append(horizontal)
                .append(center).append(horizontal).append(horizontal).append(center).append(horizontal).append(horizontal)
                .append(right).append(NL);

        StringBuilder line_bottom = new StringBuilder(27);
        line_bottom.append(space).append(bottom_left).append(horizontal).append(horizontal).append(bottom).append(horizontal).append(horizontal)
                .append(bottom).append(horizontal).append(horizontal).append(bottom).append(horizontal).append(horizontal)
                .append(bottom).append(horizontal).append(horizontal).append(bottom).append(horizontal).append(horizontal)
                .append(bottom).append(horizontal).append(horizontal).append(bottom).append(horizontal).append(horizontal)
                .append(bottom_right).append(NL);

        sb.append(cols_top);
        sb.append(line_top);

        for (int i = 0; i < 4; i++) {
            sb.append(rows);
            rows--;
            for (int j = 0; j < 4; j++) {
                sb.append(vertical).append(white_cell).append(space).append(vertical).append(black_cell).append(space);
            }

            sb.append(vertical).append(NL).append(line_middle);

            sb.append(rows);
            rows--;
            for (int j = 0; j < 4; j++) {
                sb.append(vertical).append(black_cell).append(space).append(vertical).append(white_cell).append(space);
            }

            sb.append(vertical).append(NL);

            if (i != 3) {
                sb.append(line_middle);
            }
        }

        sb.append(line_bottom).append(NL);

        return sb.toString();
    }

    private void initializeBoard() {

        for (int i = 0; i != cells.length; i = i + 1) {
            for (int j = 0; j != cells.length; j = j + 1) {
                cells[i][j] = null;
            }
        }
        //White pawns
        Pawn pawn = new Pawn(true);
        for (int i = 0; i < cells.length; i++) {
            cells[1][i] = new Cell(true, pawn);
        }

        // Black pawns
        for (int j = 0; j < cells.length; j++) {
            cells[6][j] = new Cell(true, pawn);
        }
//

    }

    private void initializePieces() {
        cells[2][0].setPiece(new Pawn(true));
        cells[5][0].setPiece(new Pawn(true));
        cells[1][0].setPiece(new Pawn(true));
        cells[6][0].setPiece(new Pawn(true));
        cells[0][0].setPiece(new Pawn(true));
        cells[7][0].setPiece(new Pawn(true));
        cells[3][0].setPiece(new Pawn(true));
        cells[4][0].setPiece(new Pawn(true));
        cells[0][1].setPiece(new Pawn(true));
        cells[1][1].setPiece(new Pawn(true));
        cells[2][1].setPiece(new Pawn(true));
        cells[3][1].setPiece(new Pawn(true));
        cells[4][1].setPiece(new Pawn(true));
        cells[5][1].setPiece(new Pawn(true));
        cells[6][1].setPiece(new Pawn(true));
        cells[7][1].setPiece(new Pawn(true));
        cells[2][7].setPiece(new Pawn(false));
        cells[5][7].setPiece(new Pawn(false));
        cells[1][7].setPiece(new Pawn(false));
        cells[6][7].setPiece(new Pawn(false));
        cells[0][7].setPiece(new Pawn(false));
        cells[7][7].setPiece(new Pawn(false));
        cells[3][7].setPiece(new Pawn(false));
        cells[4][7].setPiece(new Pawn(false));
    }

    //El método getCell(String position) retorna la Cell ubicada en la position indicada
    public Cell getCell(String position) {
        positionX = (char) position.toCharArray()[0] - 97;
        positionY = Integer.parseInt(position.substring(1, 2)) - 1;
        return cells[positionX][positionY];
    }

    public void movePiece(String initP, String finalP) {

    }

}
