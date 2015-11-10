package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

public interface EstadoVuelo {
	
	public void enviarAviso(String codigoVuelo, List<Pasaje> pasajesVendidos);
	
}
