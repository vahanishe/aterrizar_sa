package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;
import ar.com.tovmasyanv.exceptions.AterrizarException;

public class ClienteGold extends Cliente {
	
	private final Integer RESERVA_ANTICIPACION = 8;
	private final Integer DIAS_CANCELACION_CAMBIO = 14;

	public ClienteGold(DatosClienteDTO datos) {
		super(datos);
	}

	@Override
	public void reservarPasaje(Vuelo vuelo, String tipo) throws AterrizarException {
		long diasConverter = 1000L*60L*60L*24L*30L;
		Date fechaActual = new Date();
		long fechasDiferencia = vuelo.getHoraSalida().getTime() - fechaActual.getTime();
		if( fechasDiferencia/diasConverter < RESERVA_ANTICIPACION) {
			int indexPasaje = vuelo.getPrimerMatch(tipo);
			Pasaje pasaje = vuelo.getPasajesDisponibles().remove(indexPasaje);
			pasaje.setCliente(this);
			vuelo.getPasajesReservados().add(pasaje);
		}
		else
			throw new AterrizarException("Usted puede reservar con el máximo de " + RESERVA_ANTICIPACION + " meses de antipacion");
	}

	@Override
	public void cancelarReserva(Vuelo vuelo, String tipo) throws AterrizarException {
		Date fechaActual = new Date();
		int index = 0;
		long fechasDiferencia = vuelo.getHoraSalida().getTime() - fechaActual.getTime();
		if(fechasDiferencia/(1000*60*60*24) > DIAS_CANCELACION_CAMBIO) {
			boolean pasajeEncontrado = false;
			for(Pasaje pasaje : vuelo.getPasajesReservados()) {
				if(pasaje.getCliente().equals(this) && pasaje.getTipo().equalsIgnoreCase(tipo)) {
					index = vuelo.getPasajesReservados().indexOf(pasaje);
					pasajeEncontrado = true;
					break;
				}
			}
			if(pasajeEncontrado)
				vuelo.getPasajesReservados().remove(index);
			else
				throw new AterrizarException("No se encontró el pasaje a cancelar");
		}
		else 
			throw new AterrizarException("Usted puede cancelar la reserva con el máximo de " + DIAS_CANCELACION_CAMBIO + " dias de antipacion");
	}

	@Override
	public void cambiarPasaje(Vuelo vueloViejo, Vuelo vueloNuevo, String tipo) throws AterrizarException {
		Date fechaActual = new Date();
		int index = 0;
		long fechasDiferencia = vueloViejo.getHoraSalida().getTime() - fechaActual.getTime();
		if(fechasDiferencia/(1000*60*60*24) > DIAS_CANCELACION_CAMBIO) {
			boolean pasajeEncontrado = false;
			for(Pasaje pasaje : vueloViejo.getPasajesVendidos()) {
				if(pasaje.getCliente().equals(this) && pasaje.getTipo().equalsIgnoreCase(tipo)) {
					index = vueloViejo.getPasajesVendidos().indexOf(pasaje);
					pasajeEncontrado = true;
					break;
				}
			}
			if(pasajeEncontrado)
				vueloViejo.getPasajesVendidos().remove(index);
			else
				throw new AterrizarException("No se encontró el pasaje a cambiar");
			
			int indexPasaje = vueloNuevo.getPrimerMatch(tipo);
			Pasaje pasajeNuevo = vueloNuevo.getPasajesDisponibles().get(indexPasaje);
			AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
			aerolineasFacade.cambiarPasaje(vueloViejo.getCodigoVuelo(), vueloNuevo.getCodigoVuelo(), tipo);
			vueloNuevo.getPasajesDisponibles().remove(indexPasaje);
			pasajeNuevo.setCliente(this);
			vueloNuevo.getPasajesVendidos().add(pasajeNuevo);
		}
	}

}
