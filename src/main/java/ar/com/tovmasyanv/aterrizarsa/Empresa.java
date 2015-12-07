package ar.com.tovmasyanv.aterrizarsa;

import java.util.List;

import ar.com.tovmasyanv.dtos.DatosClienteDTO;
import ar.com.tovmasyanv.exceptions.AterrizarException;

public class Empresa {

	private List<Cliente> clientes;
	private List<Vuelo> vuelos;
	
	private static Empresa instance = new Empresa();
	
	private Empresa() {}

	public void venderPasajePrimeraVez(Vuelo vuelo, String tipo, DatosClienteDTO datos) {
		Pasaje pasaje = null;
		try {
			AerolineasFacade aerolineasFacade = new AerolineasFacade();
			aerolineasFacade.comprarPasaje(vuelo, tipo);

			int indexPasaje = vuelo.getPrimerMatch(tipo);
			pasaje = vuelo.getPasajesDisponibles().remove(indexPasaje);
			Cliente cliente = this.agregarCliente(datos, pasaje);
			pasaje.setCliente(cliente);

			vuelo.getPasajesVendidos().add(pasaje);
			cliente.getTipoSumador().sumarPuntos(vuelo, pasaje, cliente);
		} catch (AterrizarException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private Cliente agregarCliente(DatosClienteDTO cliente, Pasaje p) {
		try {
			this.existeCliente(cliente.getEmail());
			ClienteFactory factory = new ClienteFactory();
			Cliente clienteNuevo = factory.getClienteNuevo(p, cliente);
			this.getClientes().add(clienteNuevo);
			return clienteNuevo;
		}
		catch(AterrizarException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private void existeCliente(String email) throws AterrizarException {
		boolean existe = false;
		for(Cliente c : this.getClientes()) {
			if(c.getEmail().equals(email)) {
				existe = true;
				break;
			}
		}
		if(existe)
			throw new AterrizarException("El cliente ya existe en la base");
	}
	
	public Vuelo buscarVuelo(String codigoVuelo) throws AterrizarException {
		for(Vuelo vuelo : this.getVuelos()) {
			if(vuelo.getCodigoVuelo().equalsIgnoreCase(codigoVuelo))
				return vuelo;
		}
		
		throw new AterrizarException("No se encontro el vuelo");
	}
	
	public static Empresa getInstance() {
		return instance;
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
