package ar.com.tovmasyanv.aterrizarsa;

public class Whatsapp implements MedioComunicacion {

	public void enviarMensaje(Vuelo vuelo) {
		System.out.println("Whatsapp : Modificaciones del vuelo " + vuelo.getCodigoVuelo());
		System.out.println("Whatsapp : Horario de la salida " + vuelo.getHoraSalida());
		System.out.println("Whatsapp : Horario de la llegada " + vuelo.getHoraLlegada());
	}

	public void enviarAvisoCambioEstadoVuelo(String codigoVuelo, String estado) {
		System.out.println("Whatsapp : el vuelo " + codigoVuelo + " esta " + estado);		
	}

}
