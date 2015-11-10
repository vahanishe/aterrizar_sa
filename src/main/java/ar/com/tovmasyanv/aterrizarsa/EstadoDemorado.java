package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

public class EstadoDemorado implements EstadoVuelo {
	
	private final String NOMBRE_ESTADO = "demorado";

	public void enviarAviso(String codigoVuelo, List<Pasaje> pasajesVendidos) {
		for(Pasaje pasaje : pasajesVendidos) {
			pasaje.getCliente().getMedioComunicacion().enviarAvisoCambioEstadoVuelo(codigoVuelo, NOMBRE_ESTADO);
		}
	}

}
