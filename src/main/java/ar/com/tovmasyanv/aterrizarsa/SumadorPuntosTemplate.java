package ar.com.tovmasyanv.aterrizarsa;

public abstract class SumadorPuntosTemplate {

	protected final Integer porcentaje = 10;
	
	public abstract void sumarPuntos(Vuelo v, Pasaje p);
	
	public abstract void restarPuntos(Vuelo v, Pasaje p);
	
}
