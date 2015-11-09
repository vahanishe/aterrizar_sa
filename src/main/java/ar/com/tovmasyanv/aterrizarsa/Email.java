package ar.com.tovmasyanv.aterrizarsa;

public class Email implements MedioComunicacion {

	public void enviarMensaje(Vuelo vuelo) {
		System.out.println("Email : Modificaciones del vuelo " + vuelo.getCodigoVuelo());
		System.out.println("Email : Horario de la salida " + vuelo.getHoraSalida());
		System.out.println("Email : Horario de la llegada " + vuelo.getHoraLlegada());
	}

}
