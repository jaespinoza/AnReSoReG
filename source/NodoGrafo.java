package pageRank;

import java.util.ArrayList;


public class NodoGrafo {
	
	private int Ci;
	private double PageRack;
	private int ID;
	private ArrayList <NodoListaDeEnlaces> listaDeNodosEntrantes;
	private boolean esAislado;
	
	public NodoGrafo(int id){
		this.Ci = 0;
		this.ID = id;
		this.PageRack = 1;
		this.listaDeNodosEntrantes = new ArrayList<NodoListaDeEnlaces>();
		this.esAislado = false;
	}

	public void setPageRack(double pageRack) {
		PageRack = pageRack;
	}

	public double getPageRack() {
		return PageRack;
	}

	public void setCi(int ci) {
		Ci = ci;
	}

	public int getCi() {
		return Ci;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setListaDeNodosEntrantes(ArrayList <NodoListaDeEnlaces> listaDeNodosEntrantes) {
		this.listaDeNodosEntrantes = listaDeNodosEntrantes;
	}

	public ArrayList <NodoListaDeEnlaces> getListaDeNodosEntrantes() {
		return listaDeNodosEntrantes;
	}

	public void setEsAislado(boolean esAislado) {
		this.esAislado = esAislado;
	}

	public boolean isEsAislado() {
		return esAislado;
	}
	
}