package sistema.valueobjects;

import java.io.Serializable;

public class VOMontoRecaudado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float montoRecaudado;
	
	public VOMontoRecaudado (float montoRecaudado) {
		
		this.montoRecaudado = montoRecaudado;
	}

	public float getMontoRecaudado() {
		return montoRecaudado;
	}

	public void setMontoRecaudado(float montoRecaudado) {
		this.montoRecaudado = montoRecaudado;
	}



}