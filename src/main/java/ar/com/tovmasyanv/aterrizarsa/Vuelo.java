package ar.com.tovmasyanv.aterrizarsa;

import java.util.Date;
import java.util.List;

public class Vuelo {

	private String codigoVuelo;
	private String aerolinea;
	private List<Pasaje> pasajesDisponibles;
	private List<Pasaje> pasajesVendidos;
	private Date horaSalida;
	private Date horaLlegada;
	private String destino;
	private EstadoVuelo estado;
	
	public void setEstadoState (EstadoVuelo estado) {
		// TODO Implementar patron State
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
	
}
