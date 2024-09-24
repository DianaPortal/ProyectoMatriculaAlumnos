package guis;

import java.awt.Color;
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

public class DlgCMatriculas extends JDialog implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNmeroDeMatrcula;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTextField txtNumero;
	private JButton btnConsultar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCMatriculas dialog = new DlgCMatriculas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCMatriculas() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Matr\u00EDculas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCMatriculas.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 755, 485);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 729, 338);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 47, 729, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setBounds(146, 11, 116, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		soloNumeros(txtNumero);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(615, 10, 104, 23);
		panel.add(btnConsultar);
		
		lblNmeroDeMatrcula = new JLabel("N\u00FAmero de Matr\u00EDcula:");
		lblNmeroDeMatrcula.setBounds(10, 14, 126, 14);
		panel.add(lblNmeroDeMatrcula);
		
		lblNewLabel = new JLabel("San Francis");
		lblNewLabel.setIcon(new ImageIcon(DlgCMatriculas.class.getResource("/img/logo s.jpeg")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(262, 0, 232, 45);
		getContentPane().add(lblNewLabel);
		btnConsultar.addActionListener(this);
	}
	
	//Declaración global
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	private JLabel lblNewLabel;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}

	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int numeroMatricula = leerNumeroMatricula();
		Matricula m = am.buscar(numeroMatricula);
		if(m != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un código válido", txtNumero);
	}
	
	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Matricula m = am.buscar(leerNumeroMatricula());
		Alumno a = aa.buscar(m.getCodAlumno());
		Curso c = ac.buscar(m.getCodCurso());
		imprimir("Matrícula            : " + m.getNumMatricula());
		imprimir("Estado de matrícula  : " + Lib.estadosmatricula[m.getEstado()]);
		imprimir();
		imprimir("Alumno               : " + a.getCodAlumno());
		imprimir("Nombres              : " + a.getNombres());
		imprimir("Apellidos            : " + a.getApellidos());
		imprimir("DNI                  : " + a.getDni());
		imprimir("Edad                 : " + a.getEdad());
		imprimir("Celular              : " + a.getCelular());
		imprimir();
		imprimir("Curso                : " + c.getCodCurso());
		imprimir("Asignatura           : " + c.getAsignatura());
		imprimir("Ciclo                : " + Lib.ciclocursos[c.getCiclo()]);
		imprimir("Cantidad de créditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}
	
	//Métodos tipo void (con parámetros)
	void imprimir(String s) {
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
	int leerNumeroMatricula(){
		return Integer.parseInt(txtNumero.getText().trim());
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
	
	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNumero) {
			keyTypedTxtNumero(e);
		}
	}
	protected void keyTypedTxtNumero(KeyEvent e) {
		if(txtNumero.getText().length() >= 6){
			e.consume();
		}
	}
}
