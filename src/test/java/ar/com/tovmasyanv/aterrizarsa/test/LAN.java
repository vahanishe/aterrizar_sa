package ar.com.tovmasyanv.aterrizarsa.test;

import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.aterrizarsa.Aerolinea;
import ar.com.tovmasyanv.aterrizarsa.Vuelo;

public class LAN extends Aerolinea {

	protected LAN(String name) {
		super(name);
	}

	@Override
	public void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew,
			Date fechaHoraLlegadaNew) {
		System.out.println("LAN:");
		System.out.println("Cambios en el vuelo " + codigoVuelo);
		System.out.println("Vieja hora de salida: " + fechaHoraSalidaNew.toString());
		System.out.println("Nueva hora de salida: " + fechaHoraLlegadaNew.toString());
	}

	@Override
	public List<Vuelo> buscarPasajes(String destino, int cantidadPasajes,
			String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		System.out.println("LAN:");
		System.out.println("Buscando vuelos a " + destino);
		System.out.println("Cantidad de pasajes: " + cantidadPasajes);
		System.out.println("Tipo de pasajes: " + tipoPasaje);
		System.out.println("Fecha de ida: " + fechaIda.toString());
		System.out.println("Fecha de vuelta: " + fechaVuelta.toString());
		return null;
	}

	@Override
	public void comprarPasaje(String codigoVuelo, String tipo) {
		System.out.println("LAN:");
		System.out.println("Compra de pasaje para el vuelo " + codigoVuelo);
		System.out.println("Tipo de pasaje: " + tipo);
	}

	@Override
	public void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo,
			String tipo) {
		System.out.println("LAN:");
		System.out.println("Cambio de pasaje " + codigoVueloViejo);
		System.out.println("Vuelo nuevo: " + codigoVueloNuevo);
	}

}
