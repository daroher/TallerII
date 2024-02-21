package sistema.logica.asignatura;

import java.util.ArrayList;

import sistema.valueobjects.VOAsignatura;

public class Asignaturas {

	private ArrayList<Asignatura> asignaturas;

	public Asignaturas() {
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public boolean member(String cod) {
		boolean esta = false;
		int i = 0;

		while ((i < asignaturas.size()) && !esta) {
			String codigoiterado = asignaturas.get(i).getCodigo();

			if (codigoiterado.equals(cod)) {
				esta = true;
			}

			i++;
		}

		return esta;
	}

	public void insert(Asignatura a) {
		asignaturas.add(a);
	}

	public Asignatura find(String cod) {
		boolean esta = false;
		int i = 0;

		while ((i < asignaturas.size()) && !esta) {
			String codigoiterado = asignaturas.get(i).getCodigo();

			if (codigoiterado.equals(cod)) {
				esta = true;
			}

			i++;
		}

		return asignaturas.get(i - 1);
	}

	public boolean empty() {
		return asignaturas.isEmpty();
	}

	public int largo() {
		return asignaturas.size();
	}

	public Asignatura ksimo(int index) {
		return asignaturas.get(index);
	}

	public boolean estaLleno() {
		return (asignaturas.size() == 10);
	}

	public VOAsignatura[] listarAsignaturas() {
		VOAsignatura[] voAsignaturas = new VOAsignatura[this.asignaturas.size()];

		for (int i = 0; i < voAsignaturas.length; i++) {
			Asignatura asignaturaIterada = this.asignaturas.get(i);

			voAsignaturas[i] = new VOAsignatura(asignaturaIterada.getCodigo(), asignaturaIterada.getNombre(), asignaturaIterada.getDescripcion());
		}

		return voAsignaturas;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
}
