package escacs;

public abstract class TPesa {

	private TColor color;

	// El constructor per asignar color a la peça
	public TPesa() {
		this.setColor(color);
	}

	private void setColor(TColor color) {
		this.color = color;
	}

	private TColor getColor() {
		return this.color;
	}

	/*
	 * public boolean escac(TPosicio origen, TPosicio desti) { if (origen != null &&
	 * desti != null) { return true; } else { return false; }
	 * 
	 * }
	 */

	public boolean escac(TPosicio origen, TPosicio desti, Escacs escacs) {

		boolean check = false;
		if (this.pucmoure(origen, desti) && this.getColor() == TColor.BLANC)
			return escacs.getCassella(desti).getPesa() instanceof TRei;
		return check;

	}

	// dos metodes abstarctes
	public abstract boolean pucmoure(TPosicio origen, TPosicio desti);

	public abstract boolean mou(TPosicio origen, TPosicio desti, TCassella casella, Escacs escacs);

}
