package ar.com.tovmasyanv.aterrizarsa.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import ar.com.tovmasyanv.aterrizarsa.AerolineasFacade;
import ar.com.tovmasyanv.aterrizarsa.Cliente;
import ar.com.tovmasyanv.aterrizarsa.ClienteClassic;
import ar.com.tovmasyanv.aterrizarsa.ClienteGold;
import ar.com.tovmasyanv.aterrizarsa.ClientePlatinum;
import ar.com.tovmasyanv.aterrizarsa.Empresa;
import ar.com.tovmasyanv.aterrizarsa.Vuelo;
import ar.com.tovmasyanv.exceptions.AterrizarException;


public class ClienteTest extends BaseTest {
	
	@Test
	public void generacionCliente() {
		Empresa empresa = Empresa.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "E", sebasGonzalez);
		empresa.venderPasajePrimeraVez(vueloCordoba, "B", aleRodriguez);
		empresa.venderPasajePrimeraVez(vueloCordoba, "P", rodriPerez);
		assertEquals(ClienteClassic.class, empresa.getClientes().get(0).getClass());
		assertEquals(ClienteGold.class, empresa.getClientes().get(1).getClass());
		assertEquals(ClientePlatinum.class, empresa.getClientes().get(2).getClass());
	}
	
	@Test
	public void reservarPasaje() throws AterrizarException {
		Empresa empresa = Empresa.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "P", rodriPerez);
		Cliente clientePlatinum = empresa.getClientes().get(0);
		clientePlatinum.reservarPasaje(vueloRawson, "P");
		assertEquals(clientePlatinum, vueloRawson.getPasajesReservados().get(0).getCliente());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void buscarPasaje() {
		Empresa empresa = Empresa.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "B", aleRodriguez);
		Cliente clienteGold = empresa.getClientes().get(0);
		List<Vuelo> vuelosDisponibles = clienteGold.buscarPasajes("Cordoba", 2, "E", new Date(116, 5, 15, 15, 30), new Date(116, 5, 30, 15, 30));
		assertEquals(2, vuelosDisponibles.size());
	}
	
	@Test
	public void comprarPasaje() {
		Empresa empresa = Empresa.getInstance();
		AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "P", rodriPerez);
		Cliente clientePlatinum = empresa.getClientes().get(0);
		clientePlatinum.comprarPasaje("LAN-304", "B");
		assertEquals(clientePlatinum, aerolineasFacade.buscarVuelo("LAN-304").getPasajesVendidos().get(0).getCliente());
		assertEquals("B", aerolineasFacade.buscarVuelo("LAN-304").getPasajesVendidos().get(0).getTipo());
	}
	
	@Test
	public void cancelarReserva() throws AterrizarException {
		Empresa empresa = Empresa.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "P", rodriPerez);
		Cliente clientePlatinum = empresa.getClientes().get(0);
		clientePlatinum.reservarPasaje(vueloRawson, "P");
		assertEquals(clientePlatinum, vueloRawson.getPasajesReservados().get(0).getCliente());
		clientePlatinum.cancelarReserva(vueloRawson, "P");
		assertEquals(0, vueloRawson.getPasajesReservados().size());
	}
	
	@After
	public void cleanStaticClasses() {
		AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
		aerolineasFacade.getAerolineas().clear();
		Empresa empresa = Empresa.getInstance();
		empresa.getClientes().clear();
	}
}
