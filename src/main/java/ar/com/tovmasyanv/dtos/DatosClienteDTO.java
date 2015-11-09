package ar.com.tovmasyanv.dtos;

import java.io.Serializable;

import ar.com.tovmasyanv.aterrizarsa.MedioComunicacion;
import ar.com.tovmasyanv.aterrizarsa.SumadorPuntosTemplate;

public class DatosClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String numeroDocumento;
	private String tipoDocumento;
	private MedioComunicacion medioComunicacion;
	private String email;
	private String telefonoCelular;
	private SumadorPuntosTemplate tipoSumador;
	
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
