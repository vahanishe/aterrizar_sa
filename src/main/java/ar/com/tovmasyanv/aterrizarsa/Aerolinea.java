package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;

public interface Aerolinea {

	public void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew, Date fechaHoraLlegadaNew);
	
	public void buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta);
	
	public void comprarPasaje(String codigoVuelo, String tipo);
	
	public void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo, String tipo);
	
}
