package pancakes;

public class pancake {

	private int valor;
	private boolean revisado;
	
	public pancake(int valor, boolean revisado) {
		this.valor = valor;
		this.revisado = revisado;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public boolean getRevisado() {
		return this.revisado;
	}
	
}
