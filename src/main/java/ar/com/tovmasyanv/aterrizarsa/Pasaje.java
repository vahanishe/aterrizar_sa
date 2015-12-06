package ar.com.tovmasyanv.aterrizarsa;

public class Pasaje {
	
	private Float precio;
	private String tipo;
	private Cliente cliente;
	
	public Pasaje(Float precio, String tipo) {
		this.precio = precio;
		this.tipo = tipo;
		this.cliente = null;
	}
	
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
