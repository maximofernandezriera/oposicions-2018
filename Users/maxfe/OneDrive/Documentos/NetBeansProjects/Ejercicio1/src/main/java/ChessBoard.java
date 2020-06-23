
/**
 * Esta clase contendrá el tablero de las damas
 *
 * @author MÁXIMO FERNÁNDEZ RIERA
 */
public class ChessBoard {

    /**
     * Definimos las Constantes del tablero La celda (casilla) es de un tamaño
     * de 8x8.
     */
    final static int CELL = 8;
    private final String[][] board;

    /**
     * Clase que implementa el tablero
     *
     * To-do El último caracter "|" queda ligeramente descuadrado
     */
    public ChessBoard() {
        this.board = new String[CELL][CELL];
        initializeBoard();
    }

    /**
     * Método que inicializa el tablero
     */
    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //Si el módulo de la suma de las filas y columnas es 0 pintamos la casilla en blanco
                //Sino la pintamos en negro
                board[i][j] = (i + j) % 2 == 0 ? "\u2588" + " " : "\u2591" + " ";
            }
        }
    }

    /**
     * El método toString() de la clase ChessBoard muestra por pantalla el
     * tablero del juego
     *
     * @return el tablero en formato string
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
        for (int i = 0; i < board.length; i++) {
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
        for (int i = (board[0].length - 1); i >= 0; i--) {
            builder.append(i + 1);
            for (int j = 0; j < board.length; j++) {
                builder.append(wall);
                builder.append(board[j][i]);
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
            for (int j = 0; j < board.length; j++) {
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
}
