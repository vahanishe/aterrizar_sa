package ar.com.tovmasyanv.aterrizarsa;

public class SMS implements MedioComunicacion {

	public void enviarMensaje(Vuelo vuelo) {
		System.out.println("SMS : Modificaciones del vuelo " + vuelo.getCodigoVuelo());
		System.out.println("SMS : Horario de la salida " + vuelo.getHoraSalida());
		System.out.println("SMS : Horario de la llegada " + vuelo.getHoraLlegada());
	}

	public void enviarAvisoCambioEstadoVuelo(String codigoVuelo, String estado) {
		System.out.println("SMS : el vuelo " + codigoVuelo + " esta " + estado);		
	}

}
