package ar.com.tovmasyanv.aterrizarsa.test;

import java.util.Date;

import org.junit.Test;

import ar.com.tovmasyanv.aterrizarsa.AerolineasFacade;
import ar.com.tovmasyanv.aterrizarsa.Empresa;

public class AvisosTest extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test
	public void avisarCambiosVuelo() {
		Empresa empresa = Empresa.getInstance();
		empresa.venderPasajePrimeraVez(vueloCordoba, "E", sebasGonzalez);
		empresa.venderPasajePrimeraVez(vueloCordoba, "B", aleRodriguez);
		empresa.venderPasajePrimeraVez(vueloCordoba, "P", rodriPerez);
		AerolineasFacade aerolineasFacade = AerolineasFacade.getInstance();
		aerolineasFacade.avisarCambiosVuelo(vueloCordoba.getCodigoVuelo(), 
				new Date(116, 5, 15, 20, 30), new Date(116, 5, 15, 23, 30));
	}
	
}
