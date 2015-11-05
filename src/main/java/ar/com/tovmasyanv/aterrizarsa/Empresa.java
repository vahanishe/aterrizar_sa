package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;

public class Empresa {

	private List<Cliente> clientes;
	private List<Vuelo> vuelos;

	public void venderPasajePrimeraVez(Vuelo vuelo, String tipo, DatosClienteDTO datos) {
		
	}
	
	private void agregarCliente(DatosClienteDTO cliente, Pasaje p) {
		
	}
	
	private Boolean existeCliente(Cliente cliente) {
		return false;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
}
