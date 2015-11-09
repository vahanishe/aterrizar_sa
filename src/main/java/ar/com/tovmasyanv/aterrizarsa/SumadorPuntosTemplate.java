package ar.com.tovmasyanv.aterrizarsa;

public abstract class SumadorPuntosTemplate {

	protected final Integer PORCENTAJE = 10;
	
	public abstract void sumarPuntos(Vuelo v, Pasaje p, Cliente c);
	
	public abstract void restarPuntos(Vuelo v, Pasaje p, Cliente c);
	
}
