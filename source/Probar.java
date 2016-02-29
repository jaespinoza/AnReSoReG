package pageRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;


public class Probar {
	public static void main(String[] args) throws IOException{

		//try {
			//System.out.println("Inicial: "+System.nanoTime());
			/*Calendar calendario = Calendar.getInstance();
			int hora, minutos, segundos;
			hora =calendario.get(Calendar.HOUR_OF_DAY);
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			System.out.print("Inicial: ");
			System.out.println(hora + ":" + minutos + ":" + segundos);
			String routeTxt = "web-NotreDame.txt";
			Grafo grafo = new Grafo(routeTxt);
			Calendar calendario2 = Calendar.getInstance();
			int hora1, minutos1, segundos1;
			hora1 =calendario2.get(Calendar.HOUR_OF_DAY);
			minutos1 = calendario2.get(Calendar.MINUTE);
			segundos1 = calendario2BerkStan.get(Calendar.SECOND);
			System.out.print("Final: ");
			System.out.println(hora1 + ":" + minutos1 + ":" + segundos1);
			/*FileWriter fw = new FileWriter("Files/salidaGoogle.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter salida = new PrintWriter(bw);
		//System.out.println("Final: "+System.nanoTime());
		for(int i=0;i<grafo.getGrafo().length;i++){
				salida.println("Numero nodo: "+grafo.getGrafo()[i].getID()+'\n');
				salida.println("Numero Ci: "+grafo.getGrafo()[i].getCi()+'\n');
				salida.println("Cantidad elementos de la lista: "+grafo.getGrafo()[i].getListaDeNodosEntrantes().size()+'\n');
				Iterator<NodoListaDeEnlaces> it = grafo.getGrafo()[i].getListaDeNodosEntrantes().iterator();
				salida.println("Elementos de la lista: ");
				while (it.hasNext())
					salida.print(it.next().getIdNodo()+" ; ");
				salida.println();
				salida.println();
			}
			salida.close();
		}catch(java.io.IOException ioex) {
				System.out.println("se presento el error: "+ioex.toString());
			}*/
		
		/****************************************************************************************/
		/*
		 * Prueba PageRank.
		 */
		/*String routeTxt = "web-NotreDame.txt";
		PageRank pageRank = new PageRank(0.85,routeTxt);
		double PR = pageRank.calcularPageRank(520);
		System.out.println(PR);*/
		/*******************************************************************************************/
		
		/*String routeTxt = "web-Google.txt";
		File archivoGrafo = new File( "Files/"+routeTxt);
		BufferedReader entrada ;
		try {
			entrada = new BufferedReader( new FileReader( archivoGrafo ) );
			String linea;
			int cont = 4;
			while (cont > 0){
				linea = entrada.readLine();
				cont--;
			}
			for(int i = 1;i<2486;i++){
			linea = entrada.readLine();
			}
			linea = entrada.readLine();
			System.out.println(linea);
			
		}catch (IOException e) {
			e.printStackTrace();
		}*/
		/***************************************************************************************/
		/*
		 * Crear un archivo de prueba
		 */
		FileWriter fw = new FileWriter("Files/web-ArchivoPrueba.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter salida = new PrintWriter(bw);
		salida.println("# Directed graph (each unordered pair of nodes is saved once): web-ArchivoPrueba.txt ");
		salida.println("# Webgraph from the Google programming contest, 2002");
		salida.println("# Nodes: 11 Edges: 5105039");
		salida.println("# FromNodeId	ToNodeId");
		salida.println("0"+"\t"+"1");
		salida.println("0"+"\t"+"5");
		salida.println("0"+"\t"+"6");
		salida.println("0"+"\t"+"10");
		salida.println("1"+"\t"+"0");
		salida.println("1"+"\t"+"2");	
		salida.println("1"+"\t"+"5");
		salida.println("1"+"\t"+"7");
		salida.println("1"+"\t"+"9");
		salida.println("2"+"\t"+"1");
		salida.println("2"+"\t"+"6");
		salida.println("3"+"\t"+"0");
		salida.println("3"+"\t"+"1");
		salida.println("3"+"\t"+"2");
		salida.println("3"+"\t"+"4");
		salida.println("3"+"\t"+"5");
		salida.println("4"+"\t"+"6");
		salida.println("5"+"\t"+"0");
		salida.println("5"+"\t"+"1");
		salida.println("5"+"\t"+"4");
		salida.println("5"+"\t"+"6");
		salida.println("5"+"\t"+"9");
		salida.println("5"+"\t"+"10");
		salida.println("6"+"\t"+"0");
		salida.println("6"+"\t"+"5");
		salida.println("6"+"\t"+"7");
		salida.println("6"+"\t"+"10");
		salida.println("7"+"\t"+"0");
		salida.println("7"+"\t"+"3");
		salida.println("7"+"\t"+"4");
		salida.println("7"+"\t"+"8");
		salida.println("7"+"\t"+"10");
		salida.println("8"+"\t"+"3");
		salida.println("8"+"\t"+"5");
		salida.println("8"+"\t"+"9");
		salida.println("8"+"\t"+"10");
		salida.println("9"+"\t"+"3");
		salida.println("9"+"\t"+"4");
		salida.println("10"+"\t"+"2");
		salida.println("10"+"\t"+"3");
		salida.println("10"+"\t"+"4");
		salida.println("10"+"\t"+"5");
		
		/*******************************/
		/*salida.println("0"+"\t"+"2");
		salida.println("0"+"\t"+"3");
		salida.println("0"+"\t"+"20");
		salida.println("0"+"\t"+"18");
		salida.println("1"+"\t"+"15");
		salida.println("1"+"\t"+"16");	
		salida.println("1"+"\t"+"20");
		salida.println("1"+"\t"+"8");
		salida.println("1"+"\t"+"19");
		salida.println("2"+"\t"+"17");
		salida.println("2"+"\t"+"14");
		salida.println("3"+"\t"+"15");
		salida.println("3"+"\t"+"14");
		salida.println("3"+"\t"+"12");
		salida.println("3"+"\t"+"11");
		salida.println("3"+"\t"+"21");
		salida.println("4"+"\t"+"22");
		salida.println("5"+"\t"+"23");
		salida.println("5"+"\t"+"24");
		salida.println("5"+"\t"+"25");
		salida.println("5"+"\t"+"26");
		salida.println("5"+"\t"+"27");
		salida.println("5"+"\t"+"28");
		salida.println("6"+"\t"+"29");
		salida.println("6"+"\t"+"13");
		salida.println("6"+"\t"+"11");
		salida.println("7"+"\t"+"12");
		salida.println("7"+"\t"+"13");
		salida.println("8"+"\t"+"14");
		salida.println("8"+"\t"+"15");
		salida.println("8"+"\t"+"19");
		salida.println("8"+"\t"+"16");
		salida.println("9"+"\t"+"25");
		salida.println("9"+"\t"+"29");
		salida.println("10"+"\t"+"30");
		salida.println("10"+"\t"+"15");
		salida.println("10"+"\t"+"18");
		salida.println("10"+"\t"+"19");*/
		salida.close();
		String rutaSalida = "Salida";
		String rutaEntrada = "web-ArchivoPrueba.txt";
		PageRank pageRank = new PageRank(0.85,rutaEntrada,rutaSalida);
		pageRank.calcularPageRank();
		}
	}