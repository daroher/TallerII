package sistema.valueobjects;

import java.io.Serializable;

import sistema.utilidades.TipoListado;

public class VOListarEgresados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
