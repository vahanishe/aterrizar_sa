package ar.com.tovmasyanv.aterrizarsa.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;

import ar.com.tovmasyanv.aterrizarsa.Aerolinea;
import ar.com.tovmasyanv.aterrizarsa.AerolineasFacade;
import ar.com.tovmasyanv.aterrizarsa.AlgoritmoDistancia;
import ar.com.tovmasyanv.aterrizarsa.AlgoritmoPrecio;
import ar.com.tovmasyanv.aterrizarsa.Email;
import ar.com.tovmasyanv.aterrizarsa.Pasaje;	
import ar.com.tovmasyanv.aterrizarsa.SMS;
import ar.com.tovmasyanv.aterrizarsa.Vuelo;
import ar.com.tovmasyanv.aterrizarsa.Whatsapp;
import ar.com.tovmasyanv.dtos.DatosClienteDTO;

public class BaseTest {
	
	protected Vuelo vueloSantaFe;
	protected Vuelo vueloCordoba;
	protected Vuelo vueloCordoba2;
	protected Vuelo vueloRio;
	protected Vuelo vueloRawson;
	
	protected DatosClienteDTO sebasGonzalez;
	protected DatosClienteDTO aleRodriguez;
	protected DatosClienteDTO rodriPerez;
	
	@SuppressWarnings({ "deprecation", "unused" })
	@Before
	public void setUp() throws Exception {
		Pasaje pasaje1 = new Pasaje(new Float(1500), "E");
		Pasaje pasaje2 = new Pasaje(new Float(1500), "E");
		Pasaje pasaje3 = new Pasaje(new Float(1500), "E");
		Pasaje pasaje4 = new Pasaje(new Float(1600), "E");
		Pasaje pasaje5 = new Pasaje(new Float(1600), "E");
		Pasaje pasaje6 = new Pasaje(new Float(1800), "E");
		Pasaje pasaje7 = new Pasaje(new Float(1800), "E");
		Pasaje pasaje8 = new Pasaje(new Float(1900), "E");
		Pasaje pasaje9 = new Pasaje(new Float(1900), "E");
		Pasaje pasaje10 = new Pasaje(new Float(3500), "B");
		Pasaje pasaje11 = new Pasaje(new Float(3500), "B");
		Pasaje pasaje12 = new Pasaje(new Float(4000), "B");
		Pasaje pasaje13 = new Pasaje(new Float(4000), "B");
		Pasaje pasaje14 = new Pasaje(new Float(4500), "B");
		Pasaje pasaje15 = new Pasaje(new Float(4500), "B");
		Pasaje pasaje16 = new Pasaje(new Float(5500), "P");
		Pasaje pasaje17 = new Pasaje(new Float(5500), "P");
		Pasaje pasaje18 = new Pasaje(new Float(6000), "P");
		Pasaje pasaje19 = new Pasaje(new Float(6000), "P");
		Pasaje pasaje20 = new Pasaje(new Float(7000), "P");
		Pasaje pasaje21 = new Pasaje(new Float(8000), "P");

		
		List<Pasaje> pasajesSantaFe = new ArrayList<Pasaje>();
		pasajesSantaFe.add(pasaje1);
		pasajesSantaFe.add(pasaje2);
		pasajesSantaFe.add(pasaje5);
		pasajesSantaFe.add(pasaje8);
		pasajesSantaFe.add(pasaje10);
		pasajesSantaFe.add(pasaje11);
		pasajesSantaFe.add(pasaje16);
		pasajesSantaFe.add(pasaje17);
		vueloSantaFe = new Vuelo("LAN-304", "LAN", new Date(116, 6, 30, 23, 30),
				new Date(116, 7, 1, 2, 30), "Santa Fe", 1200, pasajesSantaFe);
		
		List<Pasaje> pasajesCordoba = new ArrayList<Pasaje>();
		pasajesCordoba.add(pasaje2);
		pasajesCordoba.add(pasaje3);
		pasajesCordoba.add(pasaje4);
		pasajesCordoba.add(pasaje5);
		pasajesCordoba.add(pasaje10);
		pasajesCordoba.add(pasaje11);
		pasajesCordoba.add(pasaje20);
		vueloCordoba = new Vuelo("AA-1000", "Aerolineas Argentinas", new Date(116, 5, 15, 15, 30),
				new Date(116, 5, 15, 18, 30), "Cordoba", 1800, pasajesCordoba);
		
		List<Pasaje> pasajesCordoba2 = new ArrayList<Pasaje>();
		pasajesCordoba2.add(pasaje6);
		pasajesCordoba2.add(pasaje7);
		pasajesCordoba2.add(pasaje9);
		pasajesCordoba2.add(pasaje8);
		pasajesCordoba2.add(pasaje12);
		pasajesCordoba2.add(pasaje13);
		pasajesCordoba2.add(pasaje18);
		pasajesCordoba2.add(pasaje19);
		vueloCordoba2 = new Vuelo("LAN-468", "LAN", new Date(116, 5, 15, 20, 30),
				new Date(116, 5, 15, 23, 30), "Cordoba", 1800, pasajesCordoba2);
		
		List<Pasaje> pasajesRio = new ArrayList<Pasaje>();
		pasajesRio.add(pasaje6);
		pasajesRio.add(pasaje7);
		pasajesRio.add(pasaje9);
		pasajesRio.add(pasaje8);
		pasajesRio.add(pasaje12);
		pasajesRio.add(pasaje13);
		pasajesRio.add(pasaje18);
		pasajesRio.add(pasaje19);
		vueloRio = new Vuelo("TAM-4618", "TAM", new Date(116, 3, 10, 10, 0),
				new Date(116, 3, 10, 18, 0), "Rio de Janeiro", 3500, pasajesRio);
		
		List<Pasaje> pasajesRawson = new ArrayList<Pasaje>();
		pasajesRawson.add(pasaje4);
		pasajesRawson.add(pasaje5);
		pasajesRawson.add(pasaje6);
		pasajesRawson.add(pasaje7);
		pasajesRawson.add(pasaje14);
		pasajesRawson.add(pasaje15);
		pasajesRawson.add(pasaje16);
		pasajesRawson.add(pasaje17);
		vueloRawson = new Vuelo("AA-1089", "Aerolineas Argentinas", new Date(116, 3, 10, 10, 0),
				new Date(116, 3, 10, 18, 0), "Rawson", 3500, pasajesRawson);
		
		
		sebasGonzalez = new DatosClienteDTO();
		sebasGonzalez.setApellido("Gonzalez");
		sebasGonzalez.setEmail("sebasgonzales@gmail.com");
		sebasGonzalez.setMedioComunicacion(new SMS());
		sebasGonzalez.setNombre("Sebastian");
		sebasGonzalez.setNumeroDocumento("35132546");
		sebasGonzalez.setTelefonoCelular("1557213456");
		sebasGonzalez.setTipoDocumento("DNI");
		sebasGonzalez.setTipoSumador(new AlgoritmoPrecio());
		
		aleRodriguez = new DatosClienteDTO();
		aleRodriguez.setApellido("Rodriguez");
		aleRodriguez.setEmail("alerodriguez@gmail.com");
		aleRodriguez.setMedioComunicacion(new Email());
		aleRodriguez.setNombre("Alejandro");
		aleRodriguez.setNumeroDocumento("34785655");
		aleRodriguez.setTelefonoCelular("1512349785");
		aleRodriguez.setTipoDocumento("DNI");
		aleRodriguez.setTipoSumador(new AlgoritmoDistancia());
		
		rodriPerez = new DatosClienteDTO();
		rodriPerez.setApellido("Perez");
		rodriPerez.setEmail("rodriperez@gmail.com");
		rodriPerez.setMedioComunicacion(new Whatsapp());
		rodriPerez.setNombre("Rodrigo");
		rodriPerez.setNumeroDocumento("30112457");
		rodriPerez.setTelefonoCelular("1595216555");
		rodriPerez.setTipoDocumento("DNI");
		rodriPerez.setTipoSumador(new AlgoritmoDistancia());
		
		Aerolinea tam = new TAM("TAM");
		Aerolinea lan = new LAN("LAN");
		Aerolinea aeroArgentinas = new AerolineasArgentinas("Aerolineas Argentinas");
		
		tam.getVuelos().add(vueloRio);
		lan.getVuelos().add(vueloSantaFe);
		lan.getVuelos().add(vueloCordoba2);
		aeroArgentinas.getVuelos().add(vueloCordoba);
		aeroArgentinas.getVuelos().add(vueloRawson);
		
		AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
		aerolineasFacade.getAerolineas().add(tam);
		aerolineasFacade.getAerolineas().add(lan);
		aerolineasFacade.getAerolineas().add(aeroArgentinas);
	}
	
}
