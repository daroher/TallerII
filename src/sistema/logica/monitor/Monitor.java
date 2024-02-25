package sistema.logica.monitor;

public class Monitor {
	
	private static int lectores=0;
	private static boolean escribiendo=false;
	private static int maxLect = 10;
	private static Monitor instancia;
	
	private Monitor() {	
	}
		
	public static Monitor getInstancia() {
		if (instancia == null) {
			instancia = new Monitor ();
		}			
		return instancia;
	}

	public synchronized void comenzarLectura () {
		
		if (escribiendo || lectores >= maxLect)
		{
			try	{
				wait();
			}
			catch (InterruptedException e) {				
			}
		}
		lectores ++;					
		}	
	
	public synchronized void terminarLectura () {
		
		lectores--;
		notify();
				
		}		
	
	public synchronized void comenzarEscritura () {
		
		if (escribiendo)
		{
			try	{
				wait();
			}
			catch (InterruptedException e) {				
			}
		}
		escribiendo=true;					
		}	
	
	public synchronized void terminarEscritura () {
		
		escribiendo=false;
		notify();
				
		}			
	
}






