package escacs;

public class TCassella {
	
	private TPesa pesa;
	private TColor color;
	
	public TCassella (TColor col, TPesa pes) {
		this.setColour(col);
		this.setPesa(pes);
	}

	public TColor getColor() {
		return this.color;
	}
	
	private void setColour(TColor color) {
		this.color = color;
	}
	
	public TPesa getPesa() {
		return this.pesa;
	}
	
	public void setPesa(TPesa pesa) {
		this.pesa = pesa;
	}
}


