package ar.com.tovmasyanv.aterrizarsa;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;

public class ClienteClassic extends Cliente {

	public ClienteClassic(DatosClienteDTO datos) {
		super(datos);
	}

	@Override
	public void reservarPasaje(Vuelo vuelo, String tipo) {
		
	}

	@Override
	public void cancelarReserva(Vuelo vuelo, String tipo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarPasaje(Vuelo vueloViejo, Vuelo vueloNuevo, String tipo) {
		// TODO Auto-generated method stub

	}

}
