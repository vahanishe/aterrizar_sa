package ar.com.tovmasyanv.aterrizarsa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.exceptions.AterrizarException;

public class AerolineasFacade {
	
	private List<Aerolinea> aerolineas;
	
	private static AerolineasFacade instance = new AerolineasFacade();
	
	private AerolineasFacade() {
		aerolineas = new ArrayList<Aerolinea>();
	}

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
	
	public List<Vuelo> buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		for(Aerolinea aerolinea : this.getAerolineas()) {
			List<Vuelo> vuelosAerolineas = new ArrayList<Vuelo>();
			vuelosAerolineas = aerolinea.buscarPasajes(destino, cantidadPasajes, tipoPasaje, fechaIda, fechaVuelta);
			vuelos.addAll(vuelosAerolineas);
		}
		return vuelos;
	}
	
	public void comprarPasaje(Vuelo vuelo, String tipo) throws AterrizarException {
		Aerolinea aerolinea = this.matchearAerolinea(vuelo.getAerolinea());
		aerolinea.comprarPasaje(vuelo.getCodigoVuelo(), tipo);
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

	public static AerolineasFacade getInstance() {
		return instance;
	}
	
	public List<Aerolinea> getAerolineas() {
		return aerolineas;
	}

	public void setAerolineas(List<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}
	
}
