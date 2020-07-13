import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Maximo Fernandez Riera
 *         Taller JAVA para iniciados a la programación
 *         Universitat Oberta de Catalunya (UOC)
 * @version 4.0
 *
 */

public class CheckersIO {

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public BufferedWriter out;

	public void setInputFile(String inputFile) throws IOException {
		this.in = new BufferedReader(new FileReader(inputFile));
	}

	public void setOutputFile(String outputFile) throws IOException {
		try {
			this.out = new BufferedWriter(new FileWriter(outputFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(ArrayList<String> moves) throws IOException {
		if (!moves.isEmpty()) {
			for (int i = 0; i < moves.size(); i++) {
				this.out.write(moves.get(i));
			}
		}
		this.out.close();
	}

	public ArrayList<String> read() throws CheckersException, IOException {
		ChessBoard chessBoard = new ChessBoard();
		String line = this.in.readLine();
		while (line != null) {
			chessBoard.moves.add(line);
			line = this.in.readLine();
		}
		this.in.close();
		return chessBoard.moves;
	}
}