package sistema.valueobjects;

public class VOEscolaridadCompleta extends VOEscolaridad {
	
	private float montoBase;
	
	public VOEscolaridadCompleta(int num, String nom, int anio, int calif, float montoBase) {
		super(num, nom, anio, calif);
		this.montoBase = montoBase;
	}

	public float getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(float montoBase) {
		this.montoBase = montoBase;
	}
}
