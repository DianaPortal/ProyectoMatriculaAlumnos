package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import clases.*;
import arreglos.*;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DlgAMCurso extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAMCurso dialog = new DlgAMCurso();
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
	public DlgAMCurso() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Reporte | Alumnos matriculados por curso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAMCurso.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 755, 483);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		{
			lblNewLabel = new JLabel("San Francis");
			lblNewLabel.setIcon(new ImageIcon(DlgAMCurso.class.getResource("/img/logo s.jpeg")));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblNewLabel.setBounds(249, 0, 232, 44);
			getContentPane().add(lblNewLabel);
		}
		
		listar();
	}
		
	//M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	
	void listar(){
		ArregloMatriculas am = new ArregloMatriculas();
		ArregloAlumnos aa = new ArregloAlumnos();
		ArregloCursos ac = new ArregloCursos();
		Matricula m;
		Alumno a;
		Curso c;
		txtS.setText("");
		for(int i=0; i<am.tamano(); i++){
			if(am.tamano()==0){
				imprimir();
			}
			else {
				m = am.obtener(i);
				a = aa.buscar(m.getCodAlumno());
				c = ac.buscar(m.getCodCurso());
				imprimir("N�mero de matr�cula : " + m.getNumMatricula());
				imprimir("Nombres             : " + a.getNombres());
				imprimir("Apellidos           : " + a.getApellidos());
				imprimir("Curso               : " + c.getAsignatura());
				imprimir();
			}
		}
			
	}	
	
	//M�todos tipo void (con par�metros)
	void imprimir(String s){
		txtS.append(s + "\n");
	}
}
