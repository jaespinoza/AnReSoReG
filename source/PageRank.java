package pageRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class PageRank {

	private double d;
	private Grafo grafo;
	private String rutaEntrada,rutaSalida;
	FileWriter fw;
	private double [] Errores;
	//double Error;
	//ArrayList<NodoError> tablaError;

	public PageRank(double factorDeAmortiguacion,String nombreArchivo,String nombreArchivoSalida ){
		this.d = factorDeAmortiguacion;
		this.rutaEntrada = nombreArchivo;
		this.grafo = new Grafo(this.rutaEntrada);
		this.rutaSalida = nombreArchivoSalida;
		this.Errores = new double[this.grafo.getCantidadDeNodos()+1];
		//this.Error = 0;
		//tablaError = new ArrayList<NodoError>();
	}
	/*
	 * Al inicializar los PageRank con el valor 1 se considera como una semilla para comenzar a calcular
	 * el PageRank buscado, en caso de ya haber buscado un PageRank para un nodo este reemplazará el valor 1
	 * dado que la proxima vez q se use se utilizará dicho valor como semilla.
	 * Para resolver el sistema de ecuaciones se utiliza el metodo de gauss seidel, dado que permite tener
	 * una convergencia mas rapido o a lo sumo tan lenta como jacobi en el peor de los casos.
	 * 
	 * El grafo contiene la lista de nodos aislados, los cuales se enlasaran a todos los nodos, pero solo 
	 * seran enlasados por otros nodos aislados.
	 */

	void calcularPageRank() throws IOException{
		FileWriter fw = new FileWriter("Files/"+this.rutaSalida);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter salida = new PrintWriter(bw);
		for(int j =0;j<=this.grafo.getCantidadDeNodos();j++){
			this.Errores[j]=0;
		}
		double Error = 0;
		double errorAux;
		//int cont = 0;
		do{
			/*if(cont ==100){
				System.out.print("");
			}*/
			for(int i = 0;i<=this.grafo.getCantidadDeNodos();i++){
				this.calcularPageRankDeNodoi(i);
			}
			/*for(int w=0;w<=this.grafo.getCantidadDeNodos();w++){
				System.out.println("Para nodo i: "+w+" PageActual: "+this.grafo.getGrafo()[w].getPageRack());
			}*/
			//cont++;
			/* CALCULAR EL ERROR */
			Error = 0;
			for(int k =0;k<=this.grafo.getCantidadDeNodos();k++){
				errorAux = this.Errores[k]-this.grafo.getGrafo()[k].getPageRack();
				if(errorAux<0) errorAux = errorAux*-1;
				if(Error < errorAux) Error = errorAux; 
			}
		}while(Error > 0.0001);
		double auxiliarSacar =0;
		for(int w=0;w<=this.grafo.getCantidadDeNodos();w++){
			salida.println("Numero nodo: "+w+" PageRank: "+this.grafo.getGrafo()[w].getPageRack());
			auxiliarSacar = auxiliarSacar + this.grafo.getGrafo()[w].getPageRack();
		}
		System.out.println("Suma de todos los PR: "+auxiliarSacar);
		salida.close();
	}

	private void calcularPageRankDeNodoi(int idNodo){
		//System.out.println("aca");
		double sumaPR = 0;
		double PR = 0;
		NodoListaDeEnlaces actual;

		Iterator<NodoListaDeEnlaces> it = this.grafo.getGrafo()[idNodo].getListaDeNodosEntrantes().iterator();
		//Pagerank de cada nodo que enlasa al nodo pedido
		while( it.hasNext()){
			actual = (NodoListaDeEnlaces)it.next();
			//System.out.println("Actual: "+actual.getIdNodo());
			Iterator<NodoListaDeEnlaces> it2 = this.grafo.getGrafo()[actual.getIdNodo()].getListaDeNodosEntrantes().iterator();
			while (it2.hasNext()){//Esto es la sumatoria
				NodoListaDeEnlaces actual2 = (NodoListaDeEnlaces)it2.next();
				//System.out.println("Actual2"+actual2.getIdNodo());
				sumaPR = sumaPR + this.grafo.getGrafo()[actual2.getIdNodo()].getPageRack()/this.grafo.getGrafo()[actual2.getIdNodo()].getCi();
				//System.out.println("sumaPR parcial: "+sumaPR);
			}
			//System.out.println("sumaPR valor final: "+sumaPR);
			PR = (double) (((1-this.d)/this.grafo.getCantidadDeNodos()) + this.d*(sumaPR));
			//NodoError nodo = new NodoError (actual.getIdNodo(),this.grafo.getGrafo()[actual.getIdNodo()].getPageRack());
			//listaErrores.add(nodo);
			this.Errores[actual.getIdNodo()]=this.grafo.getGrafo()[actual.getIdNodo()].getPageRack();
			this.grafo.getGrafo()[actual.getIdNodo()].setPageRack(PR);
			sumaPR=0;
		}
		//PageRank pedido
		it = this.grafo.getGrafo()[idNodo].getListaDeNodosEntrantes().iterator();
		while (it.hasNext()){//Esto es la sumatoria
			actual = (NodoListaDeEnlaces)it.next();
			sumaPR =  sumaPR + this.grafo.getGrafo()[actual.getIdNodo()].getPageRack()/this.grafo.getGrafo()[actual.getIdNodo()].getCi();
		}
		PR = (double) (((1-this.d)/this.grafo.getCantidadDeNodos()) + this.d*(sumaPR));
		//NodoError nodo = new NodoError (idNodo,this.grafo.getGrafo()[idNodo].getPageRack());
		//listaErrores.add(nodo);
		this.Errores[idNodo]=this.grafo.getGrafo()[idNodo].getPageRack();
		this.grafo.getGrafo()[idNodo].setPageRack(PR);
		//System.out.println("Para nodo i: "+idNodo+" PR: "+PR);
		//sumaPR = 0;
		/*Ahora calculo el error*/
		/*Iterator<NodoError> itErrores = listaErrores.iterator();
		while(itErrores.hasNext()){
			NodoError nodoMinimoError = (NodoError)itErrores.next();
			double errorAux = nodoMinimoError.getPageRank()-this.grafo.getGrafo()[nodoMinimoError.getID()].getPageRack();//Error actial del elemento i
			if(errorAux<0) errorAux = errorAux * -1;
			if(errorAux>error){listaErrores
				error = errorAux;
			}
		}*/
		/****************************************************************************/
		/*for(int i=0;i<=this.grafo.getCantidadDeNodos();i++){
				System.out.println("Para nodo i: "+i+" PageActual: "+this.grafo.getGrafo()[i].getPageRack());
			}*/
		/****************************************************************************/
	}

}