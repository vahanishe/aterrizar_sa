package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

public class AerolineasFacade {

	public void avisarCambiosVuelo(String codigoVuelo, Date fechaHoraSalidaNew, Date fechaHoraLlegadaNew) {
		Empresa empresa = Empresa.getInstance();
		List<Vuelo> vuelos = empresa.getVuelos();
		
		for(Vuelo vuelo : vuelos) {
			if(codigoVuelo.equalsIgnoreCase(vuelo.getCodigoVuelo())) {
				vuelo.setHoraSalida(fechaHoraSalidaNew);
				vuelo.setHoraLlegada(fechaHoraLlegadaNew);
				for(Pasaje pasaje : vuelo.getPasajesVendidos()) {
					pasaje.getCliente().getMedioComunicacion().enviarMensaje(vuelo);
				}
				break;
			}
		}
	}
	
	public void buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		
	}
	
	public void comprarPasaje(String codigoVuelo, String tipo) {
		
	}
	
	public void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo, String tipo) {
		
	}
	private Aerolinea matchearAerolinea(String aerolinea) {
		return null;
	}
	
}
