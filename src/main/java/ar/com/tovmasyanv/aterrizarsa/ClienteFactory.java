package ar.com.tovmasyanv.aterrizarsa;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;

public class ClienteFactory {

	public Cliente getClienteNuevo(Pasaje p, DatosClienteDTO datos) {
		if(p.getPrecio() >= 5000)
			return new ClientePlatinum(datos);
		else if(p.getPrecio() >= 2000)
			return new ClienteGold(datos);
		else return new ClienteClassic(datos);
	}
	
}
