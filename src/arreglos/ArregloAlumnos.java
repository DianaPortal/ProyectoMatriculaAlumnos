package arreglos;

import clases.Alumno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloAlumnos {

    //Atributos
    private ArrayList<Alumno> alumno;

    //Constructor
    public ArregloAlumnos() {
        alumno = new ArrayList<Alumno>();
        cargarAlumnos();
    }

    //Operaciones públicas básicas
    public void adicionar(Alumno x) {
        alumno.add(x);
        grabarAlumnos();
    }

    public int tamano() {
        return alumno.size();
    }

    public Alumno obtener(int i) {
        return alumno.get(i);
    }

    public Alumno buscar(int codAlumno) {
        for (int i = 0; i < tamano(); i++)
            if (obtener(i).getCodAlumno() == codAlumno)
                return obtener(i);
        return null;
    }

    public Alumno buscarDNI(String dni) {
        Alumno x;
        for (int i = 0; i < tamano(); i++) {
            x = obtener(i);
            if (x.getDni().equals(dni))
                return x;
        }
        return null;
    }

    public void eliminar(Alumno x) {
        alumno.remove(x);
        grabarAlumnos();
    }

    public void actualizarArchivo() {
        grabarAlumnos();
    }

    //guardar o escribir el txt
    private void grabarAlumnos() {
        try {
            PrintWriter pw;
            String linea;
            Alumno x;
            pw = new PrintWriter(new FileWriter("alumnos.txt"));
            for (int i = 0; i < tamano(); i++) {
                x = obtener(i);
                linea = x.getCodAlumno() + ";" +
                        x.getNombres() + ";" +
                        x.getApellidos() + ";" +
                        x.getDni() + ";" +
                        x.getEdad() + ";" +
                        x.getCelular() + ";" +
                        x.getEstado();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }

    //abrir o leer el txt
    private void cargarAlumnos() {
        try {
            BufferedReader br;
            String linea;
            String[] s;
            int codAlumno, edad, celular, estado;
            String nombres, apellidos, dni;
            br = new BufferedReader(new FileReader("alumnos.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codAlumno = Integer.parseInt(s[0].trim());
                nombres = s[1].trim();
                apellidos = s[2].trim();
                dni = s[3].trim();
                edad = Integer.parseInt(s[4].trim());
                celular = Integer.parseInt(s[5].trim());
                estado = Integer.parseInt(s[6].trim());
                adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
            }
            br.close();
        } catch (Exception e) {
        }
    }

    //Operaciones Complementarias
    public int numeroCorrelativo() {
        if (tamano() == 0)
            return 202010001;
        else
            return obtener(tamano() - 1).getCodAlumno() + 1;
    }
}
