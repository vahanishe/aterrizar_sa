package ar.com.tovmasyanv.aterrizarsa;

public class AlgoritmoDistancia extends SumadorPuntosTemplate {

	@Override
	public void sumarPuntos(Vuelo v, Pasaje p, Cliente c) {
		c.setPuntos(c.getPuntos() + (int)(v.getDistancia() * PORCENTAJE/100));
	}

	@Override
	public void restarPuntos(Vuelo v, Pasaje p, Cliente c) {
		c.setPuntos(c.getPuntos() - (int)(v.getDistancia() * PORCENTAJE/100));
	}

}
