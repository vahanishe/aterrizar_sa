package ar.com.tovmasyanv.aterrizarsa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.tovmasyanv.exceptions.AterrizarException;

public class Vuelo {

	private String codigoVuelo;
	private String aerolinea;
	private List<Pasaje> pasajesDisponibles;
	private List<Pasaje> pasajesVendidos;
	private List<Pasaje> pasajesReservados;
	private Date horaSalida;
	private Date horaLlegada;
	private String destino;
	private Integer distancia;
	private EstadoVuelo estado;
	
	public Vuelo(String codigoVuelo, String aerolinea, Date horaSalida,
			Date horaLlegada, String destino, Integer distancia, List<Pasaje> pasajesDisponibles) {
		this.codigoVuelo = codigoVuelo;
		this.aerolinea = aerolinea;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.destino = destino;
		this.distancia = distancia;
		this.pasajesDisponibles = pasajesDisponibles;
		this.pasajesReservados = new ArrayList<Pasaje>();
		this.pasajesVendidos = new ArrayList<Pasaje>();
	}
	
	public Integer getPrimerMatch(String tipo) throws AterrizarException {
		int contador = 0;
		for(Pasaje pasaje : this.getPasajesDisponibles()) {
			if(pasaje.getTipo().equalsIgnoreCase(tipo))
				return contador;
			contador++;
		}

		throw new AterrizarException("No quedan mas pasajes de este tipo");
	}

	public void setEstadoState (EstadoVuelo estado) {
		this.estado = estado;
		this.estado.enviarAviso(this.getCodigoVuelo(), this.getPasajesVendidos());
	}
	
	public EstadoVuelo getEstadoState() {
		return this.estado;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public List<Pasaje> getPasajesDisponibles() {
		return pasajesDisponibles;
	}
	public void setPasajesDisponibles(List<Pasaje> pasajesDisponibles) {
		this.pasajesDisponibles = pasajesDisponibles;
	}
	public List<Pasaje> getPasajesVendidos() {
		return pasajesVendidos;
	}
	public void setPasajesVendidos(List<Pasaje> pasajesVendidos) {
		this.pasajesVendidos = pasajesVendidos;
	}
	public Date getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	public Date getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public EstadoVuelo getEstado() {
		return estado;
	}
	public void setEstado(EstadoVuelo estado) {
		this.estado = estado;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public List<Pasaje> getPasajesReservados() {
		return pasajesReservados;
	}

	public void setPasajesReservados(List<Pasaje> pasajesReservados) {
		this.pasajesReservados = pasajesReservados;
	}
	
}
