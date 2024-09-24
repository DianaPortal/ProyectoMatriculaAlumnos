package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

import clases.Alumno;
import arreglos.ArregloAlumnos;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DlgAMPendiente extends JDialog {
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAMPendiente dialog = new DlgAMPendiente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgAMPendiente() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setTitle("Reporte | Alumnos con matr\u00EDculas pendientes ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAMPendiente.class.getResource("/img/SAN.png")));
		setResizable(false);
		setBounds(100, 100, 755, 484);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		{
			lblNewLabel = new JLabel("San Francis");
			lblNewLabel.setIcon(new ImageIcon(DlgAMPendiente.class.getResource("/img/logo s.jpeg")));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblNewLabel.setBounds(233, 0, 232, 42);
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
			if(a.getEstado()==0){
				imprimir("C�digo del alumno :  " + a.getCodAlumno());
				imprimir("Nombres           :  " + a.getNombres());
				imprimir("Apellidos         :  " + a.getApellidos());
				imprimir("DNI               :  " + a.getDni());
				imprimir("Edad              :  " + a.getEdad());
				imprimir("Celular           :  " + a.getCelular());
				imprimir();
			}
		}
	}
	
	//M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
