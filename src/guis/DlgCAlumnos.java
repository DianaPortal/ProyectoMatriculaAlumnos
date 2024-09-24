package guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatriculas;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import libreria.Lib;
import javax.swing.ImageIcon;

public class DlgCAlumnos extends JDialog implements ActionListener, KeyListener {
	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCdigoDelAlumno;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JButton btnConsultar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCAlumnos dialog = new DlgCAlumnos();
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
	public DlgCAlumnos() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Alumnos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCAlumnos.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 762, 480);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 729, 332);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 43, 729, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCdigoDelAlumno = new JLabel("C\u00F3digo del Alumno:");
		lblCdigoDelAlumno.setBounds(10, 14, 123, 14);
		panel.add(lblCdigoDelAlumno);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(136, 11, 123, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		soloNumeros(txtCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setBounds(596, 10, 123, 23);
		panel.add(btnConsultar);
		
		lblNewLabel = new JLabel("San Francis");
		lblNewLabel.setIcon(new ImageIcon(DlgCAlumnos.class.getResource("/img/logo s.jpeg")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(263, 0, 234, 45);
		getContentPane().add(lblNewLabel);
		btnConsultar.addActionListener(this);
	}

	//Declaración global
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	private JLabel lblNewLabel;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}	

	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int codigoAlumno = leerCodigoAlumno();
		Alumno a = aa.buscar(codigoAlumno);
		if(a != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un CODIGO válido", txtCodigo);
	}
	
	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Alumno a = aa.buscar(leerCodigoAlumno());
		imprimir("Alumno               : " + a.getCodAlumno());
		imprimir("Nombres              : " + a.getNombres());
		imprimir("Apellidos            : " + a.getApellidos());
		imprimir("DNI                  : " + a.getDni());
		imprimir("Edad                 : " + a.getEdad());
		imprimir("Celular              : " + a.getCelular());
		imprimir("Estado               : " + Lib.estadosalumnos[a.getEstado()]);
		Matricula m = am.buscarAlumno(leerCodigoAlumno());
		Curso c = ac.buscar(m.getCodCurso());
		imprimir("Asignatura           : " + c.getAsignatura());
		imprimir("Ciclo                : " + Lib.ciclocursos[c.getCiclo()]);
		imprimir("Cantidad de créditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}
	
	//Métodos tipo void (con parámetros)
	void imprimir(String s){
		txtS.append(s + "\n"); 
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	//Métodos que retornan valor (sin parámetros)
	int leerCodigoAlumno(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	//Métodos que validan los caracteres ingresados
	public void soloNumeros(JTextField a){
		a.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isDigit(c)){
					e.consume();
				}
			}
		});
	}
	
	public void keyPressed(KeyEvent arg0) {
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}
	
	protected void keyTypedTxtCodigo(KeyEvent arg0) {
		if(txtCodigo.getText().length() >= 9){
			arg0.consume();
		}
	}
}
