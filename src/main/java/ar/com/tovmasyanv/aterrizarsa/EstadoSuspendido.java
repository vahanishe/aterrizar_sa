package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

public class EstadoSuspendido implements EstadoVuelo {
	
	private final String NOMBRE_ESTADO = "suspendido";

	public void enviarAviso(String codigoVuelo, List<Pasaje> pasajesVendidos) {
		for(Pasaje pasaje : pasajesVendidos) {
			pasaje.getCliente().getMedioComunicacion().enviarAvisoCambioEstadoVuelo(codigoVuelo, NOMBRE_ESTADO);
		}
	}


}
