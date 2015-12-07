package ar.com.tovmasyanv.aterrizarsa.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ar.com.tovmasyanv.aterrizarsa.Cliente;
import ar.com.tovmasyanv.aterrizarsa.ClienteClassic;
import ar.com.tovmasyanv.aterrizarsa.ClienteGold;
import ar.com.tovmasyanv.aterrizarsa.ClientePlatinum;
import ar.com.tovmasyanv.aterrizarsa.Empresa;
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
		Cliente clientePlatinum = empresa.getClientes().get(2);
		clientePlatinum.reservarPasaje(vueloRawson, "P");
		assertEquals(vueloRawson.getPasajesReservados().get(0).getCliente(), clientePlatinum);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void buscarPasaje() {
		Empresa empresa = Empresa.getInstance();
		Cliente clienteGold = empresa.getClientes().get(1);
		clienteGold.buscarPasajes("Cordoba", 2, "E", new Date(116, 5, 15, 15, 30), new Date(116, 5, 30, 15, 30));
	}
}
