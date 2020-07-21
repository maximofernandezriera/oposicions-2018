package escacs;

public class TAlfil extends TPesa {

	/*
	 * @Override public boolean pucmoure(TPosicio origen, TPosicio desti) { return
	 * false; }
	 */

	/*
	 * @Override public boolean mou(TPosicio origen, TPosicio desti) { return false;
	 * }
	 */

	@Override
	public boolean pucmoure(TPosicio origen, TPosicio desti) {
		if (Math.abs(origen.fila - desti.fila) == Math.abs(origen.columna - desti.columna)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mou(TPosicio origen, TPosicio desti, TCassella casella, Escacs escacs) {
		if (pucmoure(origen, desti)) {
			casella.setPesa(escacs.getCassella(desti).getPesa());
			return true;
		} else {
			return false;
		}
	}

}
