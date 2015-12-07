package ar.com.tovmasyanv.aterrizarsa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Aerolinea {
	
	protected String name;
	protected List<Vuelo> vuelos;

	protected Aerolinea(String name) {
		this.name = name;
		this.vuelos = new ArrayList<Vuelo>();
	}
	
	public abstract void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew, Date fechaHoraLlegadaNew);
	
	public abstract List<Vuelo> buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta);
	
	public abstract void comprarPasaje(String codigoVuelo, String tipo);
	
	public abstract void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo, String tipo);
	
	protected int pasajesDisponiblesPorTipo(Vuelo vuelo, String tipo) {
		int contador = 0;
		for(Pasaje pasaje : vuelo.getPasajesDisponibles()) {
			if(pasaje.getTipo().equalsIgnoreCase(tipo))
				contador++;
		}
		return contador;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
}
