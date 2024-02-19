package sistema.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import sistema.excepciones.PersistenciaException;
import sistema.valueobjects.VORespaldo;

public class Respaldo {

	public Respaldo() {

	}

	public void respaldarSistema(VORespaldo voRespaldo) {

		try { // Abro el archivo y creo un flujo de comunicación hacia él
			String ruta = obtenerRutaRespaldo();
			FileOutputStream f = new FileOutputStream(ruta);
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Escribo el arreglo de vehículos en el archivo a través del flujo
			o.writeObject(voRespaldo);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("error respaldar");
		}

	}

	public VORespaldo recuperarSistema() {
		try { // Abro el archivo y creo un flujo de comunicación hacia él
			String ruta = obtenerRutaRespaldo();
			FileInputStream f = new FileInputStream(ruta);
			ObjectInputStream o = new ObjectInputStream(f);
			// Leo el arreglo de vehículos desde el archivo a través del flujo
			VORespaldo voRespaldo = (VORespaldo) o.readObject();
			o.close();
			f.close();
			return voRespaldo;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenciaException("error recuperar");
		}

	}

	private String obtenerRutaRespaldo() {
		String ruta = null;
		try {
			Properties p = new Properties();
			String nomArch = "config/configs.properties";
			// Abro el archivo properties y leo los datos de configuración
			p.load(new FileInputStream(nomArch));
			ruta = p.getProperty("rutaRespaldo");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ruta;
	}
}
