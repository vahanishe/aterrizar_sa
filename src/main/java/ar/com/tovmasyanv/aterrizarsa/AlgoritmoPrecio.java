package ar.com.tovmasyanv.aterrizarsa;

public class AlgoritmoPrecio extends SumadorPuntosTemplate {

	@Override
	public void sumarPuntos(Vuelo v, Pasaje p, Cliente c) {
		c.setPuntos(c.getPuntos() + (int)(p.getPrecio() * PORCENTAJE/100));
	}

	@Override
	public void restarPuntos(Vuelo v, Pasaje p, Cliente c) {
		c.setPuntos(c.getPuntos() - (int)(p.getPrecio() * PORCENTAJE/100));
	}


}
