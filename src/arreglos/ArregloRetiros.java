package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Retiro;

public class ArregloRetiros {
	
	//Atributo
	private ArrayList <Retiro> retiro;

	//Constructor
	public ArregloRetiros() {
		retiro = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	
	//Operaciones p�blicas b�sicas
	public void adicionar(Retiro x) {
		retiro.add(x);
		grabarRetiros();
	}
	
	public int tamano() {
		return retiro.size();
	}
	
	public Retiro obtener(int i) {
		return retiro.get(i);
	}
	
	public Retiro buscar(int numeroRetiro) {
		for (int i=0; i<tamano(); i++)
			if (obtener(i).getNumRetiro() == numeroRetiro)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Retiro x) {
		retiro.remove(x);
		grabarRetiros();
	}
	
	public void actualizarArchivo() {
		grabarRetiros();
	}
	
	//guardar o escribir el txt
	private void grabarRetiros() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			pw = new PrintWriter(new FileWriter("retiros.txt"));
			for (int i=0; i<tamano(); i++) {
				x = obtener(i);
				linea =	x.getNumRetiro() + ";" +
						x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	//abrir o leer el txt
	public void cargarRetiros() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numeroRetiro, numeroMatricula;
			br = new BufferedReader(new FileReader("retiros.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				numeroRetiro = Integer.parseInt(s[0].trim());
				numeroMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(numeroRetiro, numeroMatricula, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

	
	//Operaciones p�blicas complementarias
	public int codigoCorrelativo() {
		if (tamano() == 0)
			return 200001;
		else
			return obtener(tamano()-1).getNumRetiro() + 1;
	}
}