package ar.com.tovmasyanv.aterrizarsa;

public interface MedioComunicacion {
	
	public void enviarMensaje(Vuelo vuelo);
	
	public void enviarAvisoCambioEstadoVuelo(String codigoVuelo, String estado);
	
}
