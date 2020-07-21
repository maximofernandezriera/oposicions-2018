package escacs;

public class Escacs {
	
	private TCassella[][] taulell;
	
	  public TCassella getCassella(TPosicio posicio) {
	        return this.taulell[posicio.fila][posicio.columna];
	    }
	

}
