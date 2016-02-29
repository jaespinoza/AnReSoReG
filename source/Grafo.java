package pageRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
 * Se considera que si un usuario ingresa a una pagina sin enlasarce lo que hara  sera navegar aleatoriamente,
 * lo que equivale a suponer que una pagina sin enlaces salientes tiene enlaces a todas las paginas de internet.
 * Se consideraran para que lograr que la suma de pagerank de igual a uno.
 */

public class Grafo {

	private NodoGrafo [] representacionGrafo;
	private int cantidadDeNodos;
	private ArrayList <Integer> listaNodosAislados;

	/*
	 * La formula usada es la normalizada para que la suma de PageRank de todos los elementos sea 1
	 * 
	 * PageRank = (1-d)/N + d * suma (PR(t1)+......+PR(tm))
	 * 
	 * donde N es la cantidad total de nodos
	 * t1....tm son nodos desde donde llegan aristas.
	 * d es un factor de amortiguación que tiene un valor entre 0 y 1. 
	 * 
	 * Segun especificaciones de google sobre el algoritmo de pagerank para aquellas paginas que 
	 * se enlasan a si mismas se ignora dicho enlase.
	 * 
	 */

	public Grafo(String routeTxt){
		this.cantidadDeNodos = 0;
		File archivoGrafo = new File( "Files/"+routeTxt);
		BufferedReader entrada ;
		try {
			entrada = new BufferedReader( new FileReader( archivoGrafo ) );
			String linea;
			/*Voy a la linea tres donde esta la cantidad de nodos*/
			int cont = 2;
			while (cont > 0){
				linea = entrada.readLine();
				cont--;
			}
			linea = entrada.readLine();
			linea = linea.substring(9, 11); //Cambiar 10 por 15
			linea.trim();
			this.cantidadDeNodos = Integer.parseInt(linea);
			/******************************************/
			//System.out.println("Cantidad de nodos: "+this.cantidadDeNodos);
			/******************************************/
			this.representacionGrafo = new NodoGrafo[this.cantidadDeNodos+1];
			for (int i=0;i<cantidadDeNodos+1;i++){
				this.representacionGrafo[i] = new NodoGrafo(i);
			}
			/******************************************/
			//System.out.println("Tamaño del vector: "+this.representacionGrafo.length);
			/******************************************/
			/*Ahora proceso todos las aristas*/
			linea = entrada.readLine();
			cont = 1;
			while(entrada.ready()){
				linea = entrada.readLine();
				int indexOf = linea.lastIndexOf('\t'); 
				if(indexOf>0){
					String salida = linea.substring(0, indexOf);
					String llegada = linea.substring(indexOf+1);
					int nodoSalida = Integer.parseInt(salida);
					int nodoLlegada= Integer.parseInt(llegada);
					// Si destino igual a origen lo ignora
					//System.out.print("Salida: "+salida+" Llegada: "+llegada+" ; ");
					if(nodoSalida != nodoLlegada){
						this.actualizarGrafo(nodoSalida, nodoLlegada);
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		/*************************************************************************************/
		/*for (int k = 0;k<=this.cantidadDeNodos;k++){
			System.out.print("Ci del nodo "+k+" : "+this.representacionGrafo[k].getCi()+" ; ");		
		}
		System.out.println(" ");
		for (int j = 0; j<=this.cantidadDeNodos;j++){
			Iterator<NodoListaDeEnlaces> it = this.representacionGrafo[j].getListaDeNodosEntrantes().iterator();
			while(it.hasNext()){
				NodoListaDeEnlaces nodo = it.next();
				System.out.print("Nodo: "+j+" Numero de nodo q llega: "+nodo.getIdNodo());
			}
			System.out.println(" ");
		}*/
		
		/*************************************************************************************/

		/*
		 * Una vez creado el grafo verifico aquellos nodos que son aislados, o sea aquellos desde lo cuales no 
		 * salen enlaces ni tampoco llegan, considerando que estos nodos enlazan entonces a todos los nodos.
		 * Por lo cual se considera que existe al menos un nodo aislado por lo que no quedan nodos a los cuales 
		 * no llegue ningun enlace.
		 * 
		 * Recorro el vector buscando los nodos aislados, creo una lista. diche lista tiene todos los 
		 * nodos aislados y sera teniada en cuanta al calcular el pagerank.
		 * Un nodo aislado le llegan las aristas de todos los demas nodos aislados.
		 */
		listaNodosAislados = new ArrayList<Integer>();
		for (int i = 0;i<=this.cantidadDeNodos;i++){
			//Si es un nodo aislado
			if( (this.getGrafo()[i].getListaDeNodosEntrantes().isEmpty()) && (this.getGrafo()[i].getCi()==0) ){
				listaNodosAislados.add(this.getGrafo()[i].getID());
			}
		}
		/*for(int i = 0;i<=this.cantidadDeNodos;i++){
			Iterator<NodoListaDeEnlaces> it2 = this.getGrafo()[i].getListaDeNodosEntrantes().iterator();
			while(it2.hasNext()){
				System.out.print((int)it2.next().getIdNodo()+" ; ");
			}
			System.out.println(" ");
		}*/
		/*Iterator<Integer> it4 = listaNodosAislados.iterator();
		System.out.println("cantidad de elementos aislados: "+listaNodosAislados.size());
		while(it4.hasNext()){
			System.out.println((Integer)it4.next());
		}*/
		Iterator<Integer> it = listaNodosAislados.iterator();
		System.out.println(listaNodosAislados.size());
		while(it.hasNext()){ //agrego a cada nodo un enlace de llegada desde los nodos aislados
			int actual = (Integer)it.next();
			System.out.println(actual);
			this.getGrafo()[actual].setEsAislado(true);//Aclaro que el nodo es aislado
			for(int i = 0; i<=this.cantidadDeNodos;i++){
				NodoListaDeEnlaces nodo = new NodoListaDeEnlaces(actual,true); //nodo q se agrega a la lista de enlaces q llegan,TRUE indica que el enlace es virtual, o sea de un nodo aislado
				if(actual!=i){
					this.getGrafo()[i].getListaDeNodosEntrantes().add(nodo);//agrego a la lista del nodo i el enlace de llegada del nodo aislado
					this.getGrafo()[actual].setCi(this.getGrafo()[actual].getCi()+1);//Sumo 1 al Ci del nodo aislado
				}
			}
		}
		for(int i=0;i<=this.getCantidadDeNodos();i++){
			System.out.println("Para nodo i: "+i+" PageActual: "+this.getGrafo()[i].getPageRack());
		}
		
		Iterator<NodoListaDeEnlaces> it3 = this.getGrafo()[1].getListaDeNodosEntrantes().iterator();
		while(it3.hasNext()){
			System.out.println((int)it3.next().getIdNodo()+" ; ");
		}
	}
	/*
	 * El grafo es un grafo invertido, dado que lo que nos intereza es los link que llegan a 
	 * nuestras paginas, por lo cual al actulizar se "cambiara el sentido" de la arista, solo
	 * actualizando para el nodo salida la cantidad de aristas salientes.
	 */

	private void actualizarGrafo(int nodoSalida, int nodoLlegada) {
		this.representacionGrafo[nodoSalida].setCi(this.representacionGrafo[nodoSalida].getCi()+1);
		NodoListaDeEnlaces nodoAinsertar = new NodoListaDeEnlaces(nodoSalida,false);
		this.representacionGrafo[nodoLlegada].getListaDeNodosEntrantes().add(nodoAinsertar);
	}

	NodoGrafo [] getGrafo(){
		return this.representacionGrafo;
	}

	int getCantidadDeNodos(){
		return this.cantidadDeNodos;
	}

	public void setListaNodosAislados(ArrayList <Integer> listaNodosAislados) {
		this.listaNodosAislados = listaNodosAislados;
	}

	public List <Integer> getListaNodosAislados() {
		return listaNodosAislados;
	}

}