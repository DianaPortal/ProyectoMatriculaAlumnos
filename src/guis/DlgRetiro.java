package guis;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clases.*;
import libreria.Fecha;
import arreglos.*;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class DlgRetiro extends JDialog implements ActionListener, MouseListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNumeroRetiro;
	private JLabel lblNumeroMatricula;
	private JLabel lblCurso;
	private JLabel lblAlumno;
	private JLabel lblAsignatura;
	private JTextField txtNumeroRetiro;
	private JTextField txtNumeroMatricula;
	private JTextField txtCodigoCurso;
	private JTextField txtAlumno;
	private JTextField txtAsignatura;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblRetiro;
	private DefaultTableModel modelo;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgRetiro dialog = new DlgRetiro();
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
	public DlgRetiro() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Registro | Retiro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgRetiro.class.getResource("/img/logo s.jpeg")));
		setBounds(100, 100, 705, 517);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 679, 239);
		getContentPane().add(scrollPane);
		
		tblRetiro = new JTable();
		tblRetiro.addKeyListener(this);
		tblRetiro.addMouseListener(this);
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N�MERO");
		modelo.addColumn("MATRICULA");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		tblRetiro.setModel(modelo);
		
		panel = new JPanel();
		panel.setBounds(519, 30, 156, 151);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setForeground(new Color(0, 0, 0));
		btnAdicionar.setBounds(10, 11, 136, 23);
		panel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setForeground(new Color(0, 0, 0));
		btnModificar.setBounds(10, 45, 136, 23);
		panel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setBounds(10, 79, 136, 23);
		panel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setBounds(10, 113, 136, 23);
		panel.add(btnEliminar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 22, 372, 175);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 139, 90, 14);
		panel_1.add(lblAsignatura);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(10, 107, 90, 14);
		panel_1.add(lblAlumno);
		
		lblCurso = new JLabel("Codigo curso");
		lblCurso.setBounds(10, 76, 90, 14);
		panel_1.add(lblCurso);
		
		lblNumeroMatricula = new JLabel("No. Matr\u00EDcula");
		lblNumeroMatricula.setBounds(10, 45, 90, 14);
		panel_1.add(lblNumeroMatricula);
		
		lblNumeroRetiro = new JLabel("No. Retiro\r\n");
		lblNumeroRetiro.setBounds(10, 14, 90, 14);
		panel_1.add(lblNumeroRetiro);
		
		txtNumeroRetiro = new JTextField();
		txtNumeroRetiro.setBounds(110, 11, 115, 20);
		panel_1.add(txtNumeroRetiro);
		txtNumeroRetiro.addKeyListener(this);
		txtNumeroRetiro.setColumns(10);
		
		txtNumeroRetiro.setEditable(false);
		
		soloNumeros(txtNumeroRetiro);
		
		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setBounds(110, 42, 115, 20);
		panel_1.add(txtNumeroMatricula);
		txtNumeroMatricula.addKeyListener(this);
		txtNumeroMatricula.setColumns(10);
		soloNumeros(txtNumeroMatricula);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setBounds(110, 73, 115, 20);
		panel_1.add(txtCodigoCurso);
		txtCodigoCurso.addKeyListener(this);
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setColumns(10);
		soloNumeros(txtCodigoCurso);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(110, 104, 248, 20);
		panel_1.add(txtAlumno);
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(110, 135, 248, 22);
		panel_1.add(txtAsignatura);
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setBounds(235, 41, 123, 23);
		panel_1.add(btnAceptar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setBounds(235, 10, 123, 23);
		panel_1.add(btnBuscar);
		btnBuscar.addActionListener(this);
		btnBuscar.addMouseListener(this);
		btnBuscar.setEnabled(false);
		
		label = new JLabel("\r\n");
		label.setIcon(new ImageIcon(DlgRetiro.class.getResource("/img/WhatsApp Image 2021-11-29 at 12.09.48 AM.jpeg")));
		label.setBounds(411, 45, 89, 140);
		getContentPane().add(label);
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	
	//Declaraci�n de variables globales
	ArregloRetiros ar = new ArregloRetiros(); 
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	private JLabel label;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			BtnBuscar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			BtnConsultar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			BtnModificar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			BtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			BtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			BtnAdicionar(arg0);
		}
	}

	//Adicionar
	protected void BtnAdicionar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(true);
		habilitarBusqueda(false);
		btnAdicionar.setEnabled(false);
		txtCodigoCurso.setEditable(false);
		txtNumeroRetiro.setText("" + ar.codigoCorrelativo());
		limpiar();
		txtNumeroMatricula.requestFocus();
	}
	
	//Modificar
	protected void BtnModificar(ActionEvent arg0) {
		habilitarBotones(true);
		btnBuscar.setEnabled(false);
		btnModificar.setEnabled(false);
		if (ar.tamano() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen retiros");	
		}
		else {
			habilitarBotones(true);
			habilitarEntradas(false);
			habilitarBusqueda(true);
			btnModificar.setEnabled(false);
			limpiar();
			txtNumeroRetiro.setText("");
			txtNumeroRetiro.requestFocus();
		}
	}
	
	//Consultar
	protected void BtnConsultar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(false);
		habilitarBusqueda(true);
		btnConsultar.setEnabled(false);
		limpiar();
		txtNumeroRetiro.setText("");
		txtNumeroRetiro.requestFocus();
	}
	
	//Eliminar
	protected void BtnEliminar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarBusqueda(true);
		btnAceptar.setEnabled(false);
		if(ar.tamano()==0)
			mensaje("No hay registro de retiros");
		else{
			habilitarEntradas(false);
			try{
				int numeroRetiro = leerNumeroRetiro();
				Retiro r = ar.buscar(numeroRetiro);
				Matricula m = am.buscar(r.getNumMatricula());
				Alumno a = aa.buscar(m.getCodAlumno());
				if (a.getEstado() == 2){
					int ok = confirmar("�Desea eliminar el registro?");
					if(ok == 0){
						ar.eliminar(ar.buscar(leerNumeroRetiro()));
						m.setEstado(0);
						am.actualizarArchivo();
						a.setEstado(1);
						aa.actualizarArchivo();
						listar();
						limpiar();
						habilitarBusqueda(false);
						editarFila();
					}
				}
				else{
					mensaje("El alumno no est� retirado");
				}
				txtNumeroRetiro.setText("");
			}
			catch(Exception e){
				txtNumeroRetiro.setText("");
				txtNumeroRetiro.requestFocus();
			}
		}
	}
	
	//Aceptar
	protected void BtnAceptar(ActionEvent arg0) {
		int numeroRetiro = leerNumeroRetiro();
		try{
			int numeroMatricula = leerNumeroMatricula();
			if(btnAdicionar.isEnabled() == false){
				Matricula m = am.buscar(numeroMatricula);
				if(m != null){
					int ok=confirmar(obtenerDatosAlumno() + "\n\n" + obtenerDatosCurso(), "� Desea retirar al alumno ?");
					if(ok == 0){
						Retiro nuevo = new Retiro(numeroRetiro, numeroMatricula, Fecha.fechaActual(), Fecha.horaActual());
						ar.adicionar(nuevo);
						btnAdicionar.setEnabled(true);
						//Se desactiva la matr�cula
						m.setEstado(1);
						am.actualizarArchivo();
						//Se cambia el estado a "Retirado"
						Alumno a = aa.buscar(m.getCodAlumno());
						a.setEstado(2);
						aa.actualizarArchivo();
						listar();
						habilitarEntradas(false);
					}
					limpiar();
					btnAdicionar.setEnabled(true);
				}
			}
			if(btnModificar.isEnabled()==false){
				Curso c = ac.buscar(leerCodigoCurso());
				if(c != null){
					Matricula m = am.buscar(numeroMatricula);
					m.setCodCurso(leerCodigoCurso());
					txtAsignatura.setText("" + c.getAsignatura());
					am.actualizarArchivo();
					habilitarEntradas(false);
					btnModificar.setEnabled(true);
				}
				else{
					error("Ingrese c�digo de curso v�lido",txtCodigoCurso);
					btnModificar.setEnabled(false);
				}
			}
			listar();
		}
		catch(Exception e){
			error("Ingrese un N�MERO v�lido", txtNumeroMatricula);
		}
	}
	
	//Buscar
	protected void BtnBuscar(ActionEvent arg0) {
		try{
			int numeroRetiro = leerNumeroRetiro();
			Retiro r = ar.buscar(numeroRetiro);
			Matricula m = am.buscar(r.getNumMatricula());
			Curso c = ac.buscar(m.getCodCurso());
			Alumno a = aa.buscar(m.getCodAlumno());
			if(btnModificar.isEnabled() == false){
				if(r != null){
					txtNumeroMatricula.setText("" + r.getNumMatricula());
					txtCodigoCurso.setText("" + m.getCodCurso());
					txtAlumno.setText("" + a.getNombres()+" "+ a.getApellidos());
					txtAsignatura.setText("" + c.getAsignatura());
					habilitarEntradas(true);
					txtNumeroMatricula.setEditable(false);
					btnModificar.setEnabled(false);
					habilitarBusqueda(false);
				}
			}
			else{
				if(r != null){
					txtNumeroMatricula.setText("" + r.getNumMatricula());
					txtCodigoCurso.setText("" + m.getCodCurso());
					txtAlumno.setText("" + a.getNombres()+" "+ a.getApellidos());
					txtAsignatura.setText("" + c.getAsignatura());
					habilitarEntradas(false);
					habilitarBotones(true);
					habilitarBusqueda(false);
				}
			}
		}
		catch (Exception e){
			error("Ingrese N�MERO v�lido", txtNumeroRetiro);
		}
	}
		
	public void keyPressed(KeyEvent arg0) {
	}
	
	public void keyReleased(KeyEvent arg0) {	
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtNumeroRetiro) {
			keyTypedTxtNumeroRetiro(arg0);
		}
		if (arg0.getSource() == txtNumeroMatricula) {
			keyTypedTxtNumeroMatricula(arg0);
		}
		if (arg0.getSource() == txtCodigoCurso) {
			keyTypedTxtCodigoCurso(arg0);
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblRetiro) {
			mouseClickedTblRetiro(arg0);
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseEnteredBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(arg0);
		}
		if (arg0.getSource() == tblRetiro) {
			mouseEnteredTblRetiro(arg0);
		}
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	protected void mouseClickedTblRetiro(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	protected void mouseEnteredTblRetiro(MouseEvent arg0) {
		tblRetiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnConsultar(MouseEvent arg0) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnBuscar(MouseEvent arg0) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	//M�todos tipo void (sin par�metros)
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tblRetiro.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(9));  	// numRetiro
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10));  	// numMatricula
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  	// alumno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  	// asignatura
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  	// fecha
		tcm.getColumn(5).setPreferredWidth(anchoColumna(9));	// hora
	}
	
	void listar(){
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblRetiro.getSelectedRow();
		if (modelo.getRowCount() == ar.tamano() - 1)
			posFila = ar.tamano() - 1;
		if (posFila == ar.tamano())
			posFila --;
		modelo.setRowCount(0);
		Retiro r;
		for (int j=0; j<ar.tamano(); j++) {
			r = ar.obtener(j);
			Matricula m = am.buscar(r.getNumMatricula());
			Alumno a = aa.buscar(m.getCodAlumno());
			Curso c = ac.buscar(m.getCodCurso());
			Object[] fila = { r.getNumRetiro(),
					          r.getNumMatricula(),
					          a.getNombres()+" "+a.getApellidos(),
					          c.getAsignatura(),
					          r.getFecha(),
					          r.getHora()};
								
			modelo.addRow(fila);
		}
		if (ar.tamano() > 0)
			tblRetiro.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void editarFila(){
		if (ar.tamano() == 0)
			txtNumeroRetiro.setText("" + ar.codigoCorrelativo());
		else {
			Retiro r = ar.obtener(tblRetiro.getSelectedRow());
			Matricula m = am.buscar(r.getNumMatricula());
			Alumno a = aa.buscar(m.getCodAlumno());
			Curso c = ac.buscar(m.getCodCurso());
			txtNumeroRetiro.setText("" + r.getNumRetiro());
			txtNumeroMatricula.setText("" + r.getNumMatricula());
			txtCodigoCurso.setText("" + m.getCodCurso());
			txtAlumno.setText("" + a.getNombres()+" "+a.getApellidos());
			txtAsignatura.setText(""+c.getAsignatura());
		}
	}
	
	void limpiar(){
		txtNumeroMatricula.setText("");
		txtCodigoCurso.setText("");
		txtAlumno.setText("");
		txtAsignatura.setText("");
	}
	
	//M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void mensaje(String s1, String s2) {
		JOptionPane.showMessageDialog(this, s1, s2, 1);
	}
	
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtCodigoCurso.setEditable(sino);
		txtNumeroMatricula.setEditable(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	void habilitarBusqueda(boolean sino){
		btnBuscar.setEnabled(sino);
		txtNumeroRetiro.setEditable(sino);
	}
	
	//M�todos que retornan valor (sin par�metros)
	String obtenerDatosAlumno() {
		Matricula m = am.buscar(leerNumeroMatricula());
	    Alumno a = aa.buscar(m.getCodAlumno());
	    return "Nombres :  " + a.getNombres() + "\n" +
		       "Apellidos :  " + a.getApellidos();
	}
	
	String obtenerDatosCurso() {
		Matricula m = am.buscar(leerNumeroMatricula());
	    Curso c = ac.buscar(m.getCodCurso());
	    return "Asignatura :  " + c.getAsignatura();
	}
	
	int leerNumeroRetiro(){
		return Integer.parseInt(txtNumeroRetiro.getText().trim());
	}
	
	int leerNumeroMatricula(){
		return Integer.parseInt(txtNumeroMatricula.getText().trim());
	}
	
	int leerCodigoCurso(){
		return Integer.parseInt(txtCodigoCurso.getText().trim());
	}
	
	//M�todos que retornan valor (con par�metros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	int confirmar(String s1, String s2) {
		return JOptionPane.showConfirmDialog(this, s1, s2, 0, 1, null);
	}
	
	//M�todos que validan los caracteres ingresados
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
		
	protected void keyTypedTxtNumeroRetiro(KeyEvent arg0) {
		if(txtNumeroRetiro.getText().length() >= 6){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtNumeroMatricula(KeyEvent arg0) {
		if(txtNumeroMatricula.getText().length() >= 6){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtCodigoCurso(KeyEvent arg0) {
		if(txtCodigoCurso.getText().length() >= 4){
			arg0.consume();
		}
	}
}
