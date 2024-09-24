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

import arreglos.ArregloCursos;
import clases.Curso;
import libreria.Lib;
import javax.swing.ImageIcon;

public class DlgCCursos extends JDialog implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCdigoDelCurso;
	private JButton btnConsultar;
	private JTextField txtCodigo;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCCursos dialog = new DlgCCursos();
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
	public DlgCCursos() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Cursos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCCursos.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 755, 480);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 47, 729, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(135, 11, 115, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		soloNumeros(txtCodigo);
		
		lblCdigoDelCurso = new JLabel("C\u00F3digo del Curso:");
		lblCdigoDelCurso.setBounds(10, 14, 115, 14);
		panel.add(lblCdigoDelCurso);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(604, 10, 115, 23);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 729, 331);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		lblNewLabel = new JLabel("San Francis");
		lblNewLabel.setIcon(new ImageIcon(DlgCCursos.class.getResource("/img/logo s.jpeg")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(276, 0, 232, 44);
		getContentPane().add(lblNewLabel);
	}
	
	//Declaración global
	ArregloCursos ac = new ArregloCursos();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}

	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int codigoCurso = leerCodigoCurso();
		Curso c = ac.buscar(codigoCurso);
		if(c != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un código válido", txtCodigo);
	}

	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Curso c = ac.buscar(leerCodigoCurso());
		imprimir("Curso                : " + c.getCodCurso());
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
	int leerCodigoCurso() {
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
	
	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodigo) {
			keyTypedTxtCodigo(e);
		}
	}
	
	protected void keyTypedTxtCodigo(KeyEvent e) {
		if(txtCodigo.getText().length() >= 4){
			e.consume();
		}
	}
}
