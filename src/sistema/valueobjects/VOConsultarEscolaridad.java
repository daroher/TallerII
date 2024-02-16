package sistema.valueobjects;

import sistema.utilidades.TipoListado;

public class VOConsultarEscolaridad {
	
	private int cedula;
	private TipoListado modoListado;

	public VOConsultarEscolaridad(int ced, TipoListado modoListado) {
		this.cedula = ced;
		this.modoListado = modoListado;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public TipoListado getModoListado() {
		return modoListado;
	}

	public void setModoListado(TipoListado modoListado) {
		this.modoListado = modoListado;
	}
}
