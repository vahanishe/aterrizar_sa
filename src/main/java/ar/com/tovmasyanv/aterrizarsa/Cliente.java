package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;
import ar.com.tovmasyanv.exceptions.AterrizarException;

public abstract class Cliente {
	
	protected Integer puntos;
	protected String nombre;
	protected String apellido;
	protected String numeroDocumento;
	protected String tipoDocumento;
	protected MedioComunicacion medioComunicacion;
	protected String email;
	protected String telefonoCelular;
	protected SumadorPuntosTemplate tipoSumador;
	
	protected Integer RESERVA_ANTICIPACION;
	
	public Cliente(DatosClienteDTO datos) {
		this.nombre = datos.getNombre();
		this.apellido = datos.getApellido();
		this.numeroDocumento = datos.getNumeroDocumento();
		this.tipoDocumento = datos.getTipoDocumento();
		this.medioComunicacion = datos.getMedioComunicacion();
		this.email = datos.getEmail();
		this.telefonoCelular = datos.getTelefonoCelular();
		this.tipoSumador = datos.getTipoSumador();
		this.puntos = 0;
	}

	public List<Vuelo> buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
		List<Vuelo> vuelosDisponibles = aerolineasFacade.buscarPasajes(destino, cantidadPasajes, tipoPasaje, fechaIda, fechaVuelta);
		return vuelosDisponibles;		
	}

	public void comprarPasaje(String codigoVuelo, String tipo) {
		Empresa empresa = Empresa.getInstance();
		Vuelo vuelo = null;
		Pasaje pasaje = null;
		int indexPasaje = 0;
		try {
			AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
			vuelo = aerolineasFacade.buscarVuelo(codigoVuelo);
			aerolineasFacade.comprarPasaje(vuelo, tipo);	
			
			pasaje = buscarPasajeReservado(vuelo, this);
			if(pasaje == null) {
				indexPasaje = vuelo.getPrimerMatch(tipo);
				pasaje = vuelo.getPasajesDisponibles().remove(indexPasaje);
				pasaje.setCliente(this);
			}
			
			vuelo.getPasajesVendidos().add(pasaje);
			this.getTipoSumador().sumarPuntos(vuelo, pasaje, this);
		}
		catch(AterrizarException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private Pasaje buscarPasajeReservado(Vuelo vuelo, Cliente cliente) {
		for(Pasaje pasaje : vuelo.getPasajesReservados()) {
			if(pasaje.getCliente().equals(cliente)) {
				vuelo.getPasajesReservados().remove(pasaje);
				return pasaje;
			}	
		}
		return null;
	}

	public abstract void reservarPasaje(Vuelo vuelo, String tipo) throws AterrizarException;

	public abstract void cancelarReserva(Vuelo vuelo, String tipo) throws AterrizarException;

	public abstract void cambiarPasaje(Vuelo vueloViejo, Vuelo vueloNuevo, String tipo) throws AterrizarException;


	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public MedioComunicacion getMedioComunicacion() {
		return medioComunicacion;
	}
	public void setMedioComunicacion(MedioComunicacion medioComunicacion) {
		this.medioComunicacion = medioComunicacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public SumadorPuntosTemplate getTipoSumador() {
		return tipoSumador;
	}
	public void setTipoSumador(SumadorPuntosTemplate tipoSumador) {
		this.tipoSumador = tipoSumador;
	}

}
