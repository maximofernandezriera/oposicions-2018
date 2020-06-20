public class ChessBoard {

    final static int CELL = 8;
    private final String[][] board;

    public ChessBoard() {
        this.board = new String[CELL][CELL];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = (i + j) % 2 == 0 ? "\u2588" + " " : "\u2591" + " " ;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String wall = "\u2502";
        builder.append(" ");
        builder.append(" ");
        builder.append(" ");
        
        for (char c = 'a'; c <= 'h'; c++) {
            builder.append(" ").append(c).append(" ");
        }
        builder.append(newLine);
        builder.append(" ");
        builder.append("\u250C");

        for (int i = 0; i < board.length; i++) {
                builder.append("\u2500").append("\u2500").append("\u2500").append("\u252C");
        }
        builder.append(newLine);

        for (int i = (board[0].length - 1); i >= 0; i--) {
            builder.append(i+1);
            for (int j = 0; j < board.length; j++) {
                builder.append(wall);
                builder.append(board[j][i]);
            }
            builder.append(wall);
            builder.append(newLine);
            builder.append(" ");
            builder.append("\u251C");
            for (int j = 0; j < board.length; j++) {             
                builder.append("\u2500").append("\u2500").append("\u2500").append("\u253C");
            }
            builder.append(newLine);
        }

        return builder.toString();
    }
}
