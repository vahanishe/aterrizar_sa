package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

public class EstadoEnCurso implements EstadoVuelo {
	
	private final String NOMBRE_ESTADO = "en curso";

	public void enviarAviso(String codigoVuelo, List<Pasaje> pasajesVendidos) {
		for(Pasaje pasaje : pasajesVendidos) {
			pasaje.getCliente().getMedioComunicacion().enviarAvisoCambioEstadoVuelo(codigoVuelo, NOMBRE_ESTADO);
		}		
	}

}
