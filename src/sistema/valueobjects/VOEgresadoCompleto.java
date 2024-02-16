package sistema.valueobjects;

public class VOEgresadoCompleto extends VOEgresado {

	private float promedioTotal;
	private float promedioAprobadas;

	public VOEgresadoCompleto(int cedula, String nombre, String apellido, float promTotal, float promAprobadas) {
		super(cedula, nombre, apellido);
		this.promedioTotal = promTotal;
		this.promedioAprobadas = promAprobadas;
	}

	public float getPromedioTotal() {
		return promedioTotal;
	}

	public void setPromedioTotal(float promedioTotal) {
		this.promedioTotal = promedioTotal;
	}

	public float getPromedioAprobadas() {
		return promedioAprobadas;
	}

	public void setPromedioAprobadas(float promedioAprobadas) {
		this.promedioAprobadas = promedioAprobadas;
	}
}
