package ar.com.tovmasyanv.aterrizarsa.test;

import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.aterrizarsa.Aerolinea;
import ar.com.tovmasyanv.aterrizarsa.Vuelo;

public class LAN extends Aerolinea {

	@Override
	public void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew,
			Date fechaHoraLlegadaNew) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vuelo> buscarPasajes(String destino, int cantidadPasajes,
			String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void comprarPasaje(String codigoVuelo, String tipo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo,
			String tipo) {
		// TODO Auto-generated method stub

	}

}
