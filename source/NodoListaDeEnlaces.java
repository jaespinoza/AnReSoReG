package pageRank;

public class NodoListaDeEnlaces {
	
	private int IdNodo;
	private boolean enlaceVirtual;
	
	NodoListaDeEnlaces(int Id,boolean esVirtual){
		this.setEnlaceVirtual(esVirtual);
		this.setIdNodo(Id);
	}

	public void setEnlaceVirtual(boolean enlaceVirtual) {
		this.enlaceVirtual = enlaceVirtual;
	}

	public boolean isEnlaceVirtual() {
		return enlaceVirtual;
	}

	public void setIdNodo(int idNodo) {
		IdNodo = idNodo;
	}

	public int getIdNodo() {
		return IdNodo;
	}

}