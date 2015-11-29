package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.exceptions.AterrizarException;

public class AerolineasFacade {
	
	private List<Aerolinea> aerolineas;

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
	
	public void cambiarPasaje(String codigoVueloViejo, String codigoVueloNuevo, String tipo) throws AterrizarException {
		Empresa empresa = Empresa.getInstance();
		List<Vuelo> vuelos = empresa.getVuelos();
		
		for(Vuelo vuelo : vuelos) {
			if(codigoVueloViejo.equalsIgnoreCase(vuelo.getCodigoVuelo()))
				matchearAerolinea(vuelo.getAerolinea()).cambiarPasaje(codigoVueloViejo, codigoVueloNuevo, tipo);
		}
	}
	
	private Aerolinea matchearAerolinea(String aerolinea) throws AterrizarException {
		for(Aerolinea aerolineaCheck : this.getAerolineas()) {
			if(aerolinea.equalsIgnoreCase(aerolineaCheck.getName()))
				return aerolineaCheck;
		}
		throw new AterrizarException("No se encuentra la aviolínea buscada");
	}

	public List<Aerolinea> getAerolineas() {
		return aerolineas;
	}

	public void setAerolineas(List<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}
	
}
