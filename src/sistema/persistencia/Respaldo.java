package sistema.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sistema.excepciones.PersistenciaException;
import sistema.utilidades.GetProperties;
import sistema.valueobjects.VORespaldo;

public class Respaldo {

	public Respaldo() {
	}

	public void respaldarSistema(VORespaldo voRespaldo) {
		try {
			String rutaArchivo = GetProperties.getInstancia().getString("rutaRespaldo");
			
			FileOutputStream f = new FileOutputStream(rutaArchivo);
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(voRespaldo);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("Ha habido un error al respaldar.");
		}
	}

	public VORespaldo recuperarSistema() {
		try {
			String rutaArchivo = GetProperties.getInstancia().getString("rutaRespaldo");
			
			FileInputStream f = new FileInputStream(rutaArchivo);
			ObjectInputStream o = new ObjectInputStream(f);
			
			VORespaldo voRespaldo = (VORespaldo) o.readObject();
			
			o.close();
			f.close();
			
			return voRespaldo;
		}catch (FileNotFoundException ex) {
			throw new PersistenciaException("No se ha recuperado la informacion porque no existe el archivo de respaldo.");
		}catch (IOException | ClassNotFoundException e) {
			throw new PersistenciaException("Ha habido un error al recuperar la informacion.");
		}
	}
}
