
/**
 * Model object for a ChessBoard.
 *
 * @author Jordi Blasco Planesas<br>
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
        StringBuilder builder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        // El string wall contiene el código utf8 del carácter 2502: |
        String wall = "\u2502";
        builder.append(" ");
        builder.append(" ");
        builder.append(" ");
        //Pintamos las letras de la 'a' a la 'h'
        for (char c = 'a'; c <= 'h'; c++) {
            builder.append(" ").append(c).append(" ");
        }
        builder.append(newLine);
        builder.append(" ");
        //Añadimos el carácter 250C: ┌
        builder.append("\u250C");
        //Bucle que recorre el tablero
        for (int i = 0; i < cells.length; i++) {
            if (i != 7) {
                //Si no es la última casilla pintamos: - y ┬
                builder.append("\u2500").append("\u2500").append("\u2500").append("\u252C");
            } else {
                //Si lo es pintamos - y ┐
                builder.append("\u2500").append("\u2500").append("\u2500").append("\u2510");
            }
        }
        builder.append(newLine);

        //Recorremos el tablero y vamos pintando los caracteres necesarios
        for (int i = (cells[0].length - 1); i >= 0; i--) {
            builder.append(i + 1);
            for (int j = 0; j < cells.length; j++) {
                builder.append(wall);
                builder.append(cells[j][i]);
            }
            builder.append(wall);
            builder.append(newLine);
            builder.append(" ");
            //Pintamos el caracter ├ si no es la última casilla
            if (i != 0) {
                builder.append("\u251C");
            } else {
                //si es la última casilla pintamos "└" 
                builder.append("\u2514");
            }
            //Seguimos pintando los caracteres necesarios
            for (int j = 0; j < cells.length; j++) {
                //Si no es el principio ni el final pintamos "-" y "┘"
                if (j == 7 && i == 0) {
                    builder.append("\u2500").append("\u2500").append("\u2500").append("\u2518");
                } else {
                    //En caso contrario pintamos "-" y  "┼"
                    builder.append("\u2500").append("\u2500").append("\u2500").append("\u253C");
                }
            }
            builder.append(newLine);

        }
        //Devolvemos el tablero como una cadena
        return builder.toString();
    }

    private void initializeBoard() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if ((j % 2) == 0) {
                    cells[i][j] = new Cell(Cell.BLACK, null);
                } else {
                    cells[i][j] = new Cell(Cell.WHITE, null);
                }
            }
        }
    }

    public int getX(String position) {
        int x = 0;
        switch (position.substring(0, 1)) {
            case "a":
                x = 0;
                break;
            case "b":
                x = 1;
                break;
            case "c":
                x = 2;
                break;
            case "d":
                x = 3;
                break;
            case "e":
                x = 4;
                break;
            case "f":
                x = 5;
                break;
            case "g":
                x = 6;
                break;
            case "h":
                x = 7;
                break;
        }
        return x;
    }

    public int getY(String position) {
        int y = 0;
        switch (position.substring(1, 2)) {
            case "1":
                y = 0;
                break;
            case "2":
                y = 1;
                break;
            case "3":
                y = 2;
                break;
            case "4":
                y = 3;
                break;
            case "5":
                y = 4;
                break;
            case "6":
                y = 5;
                break;
            case "7":
                y = 6;
                break;
            case "8":
                y = 7;
                break;
        }
        return y;
    }

    private void setPiece(Piece piece, String position) {
        //recupera la celda identificada por position y le asigna la Piece facilitada
        this.getCell(position).setPiece(piece);
    }

//El método setPiece(Piece piece, String position) recupera la celda identificada por position y le asigna la Piece facilitada. Ejemplos de posiciones: a2, b4, c3, f7, etc
    private void initializePieces() {

        // Se instancian y añaden los peones blancos
        this.setPiece(new Pawn(Piece.WHITE), "a3");
        this.setPiece(new Pawn(Piece.WHITE), "c3");
        this.setPiece(new Pawn(Piece.WHITE), "e3");
        this.setPiece(new Pawn(Piece.WHITE), "g3");
        // ...
        this.setPiece(new Pawn(Piece.WHITE), "b2");
        this.setPiece(new Pawn(Piece.WHITE), "d2");
        this.setPiece(new Pawn(Piece.WHITE), "f2");
        this.setPiece(new Pawn(Piece.WHITE), "h2");
        // ...
        this.setPiece(new Pawn(Piece.WHITE), "a1");
        this.setPiece(new Pawn(Piece.WHITE), "c1");
        this.setPiece(new Pawn(Piece.WHITE), "e1");
        this.setPiece(new Pawn(Piece.WHITE), "g1");

        // Se instancian y añaden los peones negros
        this.setPiece(new Pawn(Piece.BLACK), "b8");
        this.setPiece(new Pawn(Piece.BLACK), "d8");
        this.setPiece(new Pawn(Piece.BLACK), "f8");
        this.setPiece(new Pawn(Piece.BLACK), "h8");
        // ...
        this.setPiece(new Pawn(Piece.BLACK), "a7");
        this.setPiece(new Pawn(Piece.BLACK), "c7");
        this.setPiece(new Pawn(Piece.BLACK), "e7");
        this.setPiece(new Pawn(Piece.BLACK), "g7");
        // ...
        this.setPiece(new Pawn(Piece.BLACK), "b6");
        this.setPiece(new Pawn(Piece.BLACK), "d6");
        this.setPiece(new Pawn(Piece.BLACK), "f6");
        this.setPiece(new Pawn(Piece.BLACK), "h6");
    }

    //El método getCell(String position) retorna la Cell ubicada en la position indicada
    public Cell getCell(String position) {
        positionX = getX(position);
        positionY = getY(position);
        return this.cells[positionX][positionY];
    }

    public void movePiece(String initialPosition, String finalPosition) {
        if (!this.getCell(finalPosition).hasPiece()) {
            this.setPiece(this.getCell(initialPosition).getPiece(), finalPosition);
        }
    }

}
