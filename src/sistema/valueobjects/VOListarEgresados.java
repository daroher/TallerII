package sistema.valueobjects;

import sistema.utilidades.TipoListado;

public class VOListarEgresados {

	private TipoListado modoListado;	
	
	public VOListarEgresados (TipoListado modoListado) {
		this.modoListado = modoListado;
	}

	public TipoListado getModoListado() {
		return modoListado;
	}

	public void setModoListado(TipoListado modoListado) {
		this.modoListado = modoListado;
	}
}
