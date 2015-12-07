package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

public abstract class Aerolinea {
	
	protected String name;

	protected Aerolinea(String name) {
		this.name = name;
	}
	
	public abstract void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew, Date fechaHoraLlegadaNew);
	
	public abstract List<Vuelo> buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta);
	
	public abstract void comprarPasaje(String codigoVuelo, String tipo);
	
	public abstract void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo, String tipo);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
