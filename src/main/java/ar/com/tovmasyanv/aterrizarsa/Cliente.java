package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

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
	
	public List<Vuelo> buscarPasajes(String destino, int cantidadPasajes, String tipoPasaje, Date fechaIda, Date fechaVuelta) {
		// TODO Implementar el metodo
		return null;		
	}
	
	public abstract void comprarPasaje(Vuelo vuelo, String tipo);
	
	public abstract void reservarPasaje(Vuelo vuelo, String tipo);
	
	public abstract void cancelarReserva(Vuelo vuelo, String tipo);
	
	public abstract void cambiarPasaje(Vuelo vueloViejo, Vuelo vueloNuevo, String tipo);

	
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
