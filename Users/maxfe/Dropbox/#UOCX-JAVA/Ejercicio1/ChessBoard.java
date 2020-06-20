/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxfe
 */
public class ChessBoard {

    final static int ROWS = 8;
    final static int COLS = 8;

//    @Override
//    public String toString() {
//        String brdStr = "";
//        brdStr += " ";
//        
//        for (char c = 'a'; c <= 'h'; c++) {
//            brdStr += " " + c + "\u250C";
//        }
//        brdStr += "\n";
//        for (int row = ROWS; row >= 1; row--) {
//            brdStr += row + "";
//            brdStr += "\u250C";
//            for (int col = 1; col <= COLS; col++) {
//                brdStr += "\u2502"; 
//                brdStr += (col + row) % 2 == 0 ? "\u2588" : "\u2591";
//                brdStr += "\u2502";                
//            }
//            brdStr += "\n";
//        }
//        return brdStr;
//    }
    @Override
    public String toString() {
        String brdStr = "";
        for (char c = 'a'; c <= 'h'; c++) {
            brdStr += "--------------------------------";
        }

        for (int column = 0; column < COLS; column++) {
            brdStr += ("| " +  " " + " ");
        }
        brdStr += ("|");
        brdStr += ("");
        brdStr += ("---------------------------------");
        return brdStr;
    }
}
