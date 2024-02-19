package sistema.logica.asignatura;

import java.util.ArrayList;

import sistema.valueobjects.VOAsignatura;


public class Asignaturas {

	private ArrayList <Asignatura> Asignaturas;

	
	public Asignaturas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asignaturas(ArrayList<Asignatura> asignaturas) {
		super();
		Asignaturas = asignaturas;
	}

	public boolean member(String cod) 
	{
		boolean esta= false; 
		int i=0;
		while ((i< Asignaturas.size()) && !esta)
		{
		   String codigoiterado= Asignaturas.get(i).getCodigo();
		   if (codigoiterado.equals(cod))
			   esta=true;
		   i++;
		}		
		return esta;		
	}
	

	public void insert (Asignatura a) {
			Asignaturas.add(a);
	}
	
	public Asignatura find (String cod)
	{
		boolean esta= false; 
		int i=0;
		while ((i< Asignaturas.size()) && !esta)
		{
		   String codigoiterado= Asignaturas.get(i).getCodigo();
		   if (codigoiterado.equals(cod))
			   esta=true;
		   i++;
		}		
		return Asignaturas.get(i-1);
	}
	

	public boolean empty() {
		return Asignaturas.isEmpty();
	}

	public int Largo () {
		return Asignaturas.size();
	}


	public Asignatura kesimo (int index) {
		return Asignaturas.get(index);
	}

	
	public boolean estaLleno () {
		return (Asignaturas.size()==10);
	}
	
	
	// Muy probable que no vaya esto, se resuelve directamente con la primitiva de insert.
	public void registrarAsignatura (Asignatura a) {
		
	}
	
	
	public VOAsignatura[] listarAsignaturas() {
		return null;
	}
	
	
	
	
}
