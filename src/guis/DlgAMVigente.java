package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloAlumnos;
import clases.Alumno;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DlgAMVigente extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAMVigente dialog = new DlgAMVigente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAMVigente() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Reporte | Alumnos con matr\u00EDcula vigente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAMVigente.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 755, 486);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		{
			lblNewLabel = new JLabel("San Francis");
			lblNewLabel.setIcon(new ImageIcon(DlgAMVigente.class.getResource("/img/logo s.jpeg")));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblNewLabel.setBounds(240, 0, 232, 42);
			getContentPane().add(lblNewLabel);
		}
		
		listar();
	}
	
	//M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	void listar() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		txtS.setText("");
		for(int i=0; i<aa.tamano(); i++){
			a = aa.obtener(i);
			if(a.getEstado()==1){
				imprimir("C�digo del alumno :  " + a.getCodAlumno());
				imprimir("Nombres           :  " + a.getNombres());
				imprimir("Apellidos         :  " + a.getApellidos());
				imprimir("DNI               :  " + a.getDni());
				imprimir("Edad              :  " + a.getEdad());
				imprimir("Celular           :  " + a.getCelular());
				imprimir();
			}
			else
				imprimir();
		}
	}
		
	//M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
