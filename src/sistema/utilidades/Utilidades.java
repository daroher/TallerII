package sistema.utilidades;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Utilidades {

	public static String convertirTextoAFormatoMoneda(String texto) {
	        DecimalFormat formatter = new DecimalFormat("$#,##0.00"); 
	        BigDecimal amt = new BigDecimal(texto); 

	        return formatter.format(amt); 
	}
}
