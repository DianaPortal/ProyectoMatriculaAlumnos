package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.*;
import libreria.Fecha;
import libreria.Lib;
import arreglos.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class DlgMatricula extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNmeroDeMatrcula;
	private JLabel lblCdigoAlumno;
	private JLabel lblCdigoCurso;
	private JLabel lblNombresYApellidos;
	private JLabel lblAsignatura;
	private JTextField txtNumero;
	private JTextField txtCodigoAlumno;
	private JTextField txtCodigoCurso;
	private JTextField txtAlumno;
	private JTextField txtAsignatura;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JTable tblMatricula;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatricula dialog = new DlgMatricula();
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
	public DlgMatricula() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setResizable(false);
		setTitle("Registro | Matr\u00EDcula");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMatricula.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 729, 512);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 705, 241);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.addKeyListener(this);
		tblMatricula.addMouseListener(this);
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N�MERO");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("CURSO");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("FECHA");
		modelo.addColumn("HORA");
		modelo.addColumn("ESTADO");
		tblMatricula.setModel(modelo);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 26, 410, 167);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNmeroDeMatrcula = new JLabel("N\u00FAmero de Matr\u00EDcula:");
		lblNmeroDeMatrcula.setBounds(10, 14, 125, 14);
		panel.add(lblNmeroDeMatrcula);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(142, 11, 86, 20);
		panel.add(txtNumero);
		txtNumero.addKeyListener(this);
		txtNumero.setColumns(10);
		
		txtNumero.setEditable(false);
				
		soloNumeros(txtNumero);
				
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setBounds(142, 42, 86, 20);
		panel.add(txtCodigoAlumno);
		txtCodigoAlumno.addKeyListener(this);
		txtCodigoAlumno.setColumns(10);
		soloNumeros(txtCodigoAlumno);
				
		lblCdigoAlumno = new JLabel("C\u00F3digo Alumno:");
		lblCdigoAlumno.setBounds(10, 45, 125, 14);
		panel.add(lblCdigoAlumno);
		
		lblCdigoCurso = new JLabel("C\u00F3digo Curso:");
		lblCdigoCurso.setBounds(10, 76, 125, 14);
		panel.add(lblCdigoCurso);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setBounds(142, 73, 86, 20);
		panel.add(txtCodigoCurso);
		txtCodigoCurso.addKeyListener(this);
		txtCodigoCurso.setColumns(10);
		soloNumeros(txtCodigoCurso);
				
		txtAlumno = new JTextField();
		txtAlumno.setBounds(142, 104, 255, 20);
		panel.add(txtAlumno);
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
				
		lblNombresYApellidos = new JLabel("Alumno:");
		lblNombresYApellidos.setBounds(10, 107, 125, 14);
		panel.add(lblNombresYApellidos);
				
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(10, 138, 125, 14);
		panel.add(lblAsignatura);
				
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(142, 135, 255, 20);
		panel.add(txtAsignatura);
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
				
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(238, 41, 89, 23);
		panel.add(btnAceptar);
				
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(238, 10, 89, 23);
		panel.add(btnBuscar);
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
				
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(557, 26, 137, 149);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
				
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 11, 116, 23);
		panel_1.add(btnAdicionar);
		btnAdicionar.setForeground(new Color(0, 0, 0));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(10, 45, 116, 23);
		panel_1.add(btnConsultar);
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 79, 116, 23);
		panel_1.add(btnModificar);
		btnModificar.setForeground(new Color(0, 0, 0));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 113, 116, 23);
		panel_1.add(btnEliminar);
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DlgMatricula.class.getResource("/img/WhatsApp Image 2021-11-29 at 12.09.48 AM.jpeg")));
		lblNewLabel.setBounds(446, 42, 90, 121);
		getContentPane().add(lblNewLabel);
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.addActionListener(this);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	
	//Declaramos variables globales
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			BtnAceptar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			BtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			BtnEliminar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			BtnConsultar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			BtnModificar(arg0);
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
		txtNumero.setText("" + am.codigoCorrelativo());
		limpiar();
		txtCodigoAlumno.requestFocus();
	}
	
	//Modificar
	protected void BtnModificar(ActionEvent arg0) {
		habilitarBotones(true);
		btnModificar.setEnabled(false);
		if (am.tamano() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen matr�culas");	
		}
		else {
			habilitarBotones(true);
			habilitarEntradas(false);
			habilitarBusqueda(true);
			btnModificar.setEnabled(false);
			limpiar();
			txtNumero.setText("");
			txtNumero.requestFocus();
		}
	}
	
	//Consultar
	protected void BtnConsultar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(false);
		habilitarBusqueda(true);
		btnConsultar.setEnabled(false);
		limpiar();
		txtNumero.setText("");
		txtNumero.requestFocus();
	}
	
	//Eliminar
	protected void BtnEliminar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarBusqueda(true);
		btnAceptar.setEnabled(false);
		if (am.tamano() == 0)
			mensaje("No hay alumnos matriculados");
		else{
			habilitarEntradas(false);
			try{
				int numeroMatricula = leerNumeroMatricula();
				Matricula m = am.buscar(numeroMatricula);
				Alumno x = aa.buscar(m.getCodAlumno());
				if (x.getEstado() == 0 || x.getEstado() == 1){
					habilitarBusqueda(false);
					int ok = confirmar("�Desea eliminar el registro?");
					if(ok == 0){
						am.eliminar(am.buscar(leerNumeroMatricula()));
						x.setEstado(0);
						listar();
						editarFila();
					}
				}
				else
					mensaje("El alumno se ha retirado");
					habilitarBusqueda(false);
			}
			catch(Exception e){
				txtNumero.requestFocus();
			}
		}
	}
	
	//Buscar
	protected void BtnBuscar(ActionEvent arg0) {
		try{
			int numMatricula = leerNumeroMatricula();
			Matricula m = am.buscar(numMatricula);
			Alumno a = aa.buscar(m.getCodAlumno());
			Curso c = ac.buscar(m.getCodCurso());
			if(btnModificar.isEnabled()==false){
				if(m != null){
					txtCodigoAlumno.setText("" + m.getCodAlumno());
					txtCodigoCurso.setText("" + m.getCodCurso());
					txtAlumno.setText("" + a.getNombres()+" "+ a.getApellidos());
					txtAsignatura.setText("" + c.getAsignatura());
					habilitarEntradas(true);
					txtCodigoAlumno.setEditable(false);
					btnModificar.setEnabled(false);
					habilitarBusqueda(false);
				}
			}
			else{
				if(m != null){
					txtCodigoAlumno.setText("" + m.getCodAlumno());
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
			error("Ingrese N�MERO v�lido", txtNumero);
		}
	}
	
	//Aceptar
	protected void BtnAceptar(ActionEvent arg0) {
		int numMatricula = leerNumeroMatricula();
		try{
			int codAlumno = leerCodigoAlumno();
			try{
				int codCurso = leerCodigoCurso();
				if(btnAdicionar.isEnabled() == false){
					Alumno a = aa.buscar(codAlumno);
					Curso c = ac.buscar(codCurso);
					Matricula m = am.buscarAlumno(codAlumno);
					if(a!=null && c!=null){
						if(m==null){
							int ok = confirmar(obtenerDatosAlumno() + "\n\n" + obtenerDatosCurso(), "� Desea matricular al alumno ?");
							if (ok == 0){
								Matricula nuevo = new Matricula(numMatricula, codAlumno, codCurso, Fecha.fechaActual(), Fecha.horaActual(),0);
								am.adicionar(nuevo);
								btnAdicionar.setEnabled(true);
								a.setEstado(1);
								aa.actualizarArchivo();
								btnAdicionar.setEnabled(true);
								habilitarEntradas(false);
							}
							limpiar();
							btnAdicionar.setEnabled(true);
						}
						else{
							mensaje("El alumno ya ha sido matriculado");
							limpiar();
							btnAdicionar.setEnabled(true);
						}
					}
					else{
						error("El c�digo del alumno o curso no ha sido registrado", txtCodigoAlumno);
						limpiar();
						btnAdicionar.setEnabled(false);
					}	
				}
				if(btnModificar.isEnabled() == false){
					Curso c = ac.buscar(codCurso);
					if(c!=null){
						Matricula m = am.buscar(numMatricula);
						m.setCodAlumno(codAlumno);
						m.setCodCurso(codCurso);
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
				error("Ingrese el C�DIGO del curso",txtCodigoCurso);
			}
		}
		catch(Exception e){
			error("Ingrese el C�DIGO del alumno",txtCodigoAlumno);
		}
		
	}
	
	public void keyPressed(KeyEvent arg0) {
	}
	
	public void keyReleased(KeyEvent arg0) {		
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodigoCurso) {
			keyTypedTxtCodigoCurso(arg0);
		}
		if (arg0.getSource() == txtCodigoAlumno) {
			keyTypedTxtCodigoAlumno(arg0);
		}
		if (arg0.getSource() == txtNumero) {
			keyTypedTxtNumeroMatricula(arg0);
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblMatricula) {
			mouseClickedTblMatricula(arg0);
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
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
		if (arg0.getSource() == tblMatricula) {
			mouseEnteredTblMatricula(arg0);
		}
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	protected void mouseClickedTblMatricula(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		btnBuscar.setEnabled(false);
		editarFila();
	}
	
	protected void mouseEnteredTblMatricula(MouseEvent arg0) {
		tblMatricula.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnConsultar(MouseEvent arg0) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		TableColumnModel tcm = tblMatricula.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(4));  // numMatr�cula
		tcm.getColumn(1).setPreferredWidth(anchoColumna(6));  // codAlumno
		tcm.getColumn(2).setPreferredWidth(anchoColumna(3));  // codCurso
		tcm.getColumn(3).setPreferredWidth(anchoColumna(16));  // alumno
		tcm.getColumn(4).setPreferredWidth(anchoColumna(16));  // curso
		tcm.getColumn(5).setPreferredWidth(anchoColumna(5));  // fecha
		tcm.getColumn(6).setPreferredWidth(anchoColumna(3));  // hora
		tcm.getColumn(7).setPreferredWidth(anchoColumna(6));  // estado
	}
	
	void listar(){
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblMatricula.getSelectedRow();
		if (modelo.getRowCount() == am.tamano() - 1)
			posFila = am.tamano() - 1;
		if (posFila == am.tamano())
			posFila --;
		modelo.setRowCount(0);
		Matricula m;
		for (int j=0; j<am.tamano(); j++) {
			m = am.obtener(j);
			Alumno a=aa.buscar(m.getCodAlumno());
			Curso c=ac.buscar(m.getCodCurso());
			Object[] fila = { m.getNumMatricula(),
					          m.getCodAlumno(),
					          m.getCodCurso(),
					          a.getNombres()+" "+a.getApellidos(),
					          c.getAsignatura(),
					          m.getFecha(),
					          m.getHora(),
					          Lib.estadosmatricula[m.getEstado()]};
								
			modelo.addRow(fila);
		}
		if (am.tamano() > 0)
			tblMatricula.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila(){
		if (am.tamano() == 0)
			txtNumero.setText("" + am.codigoCorrelativo());
		else {
			Matricula m = am.obtener(tblMatricula.getSelectedRow());
			txtNumero.setText("" + m.getNumMatricula());
			txtCodigoAlumno.setText("" + m.getCodAlumno());
			txtCodigoCurso.setText("" + m.getCodCurso());
		}
	}
	
	void limpiar(){
		txtCodigoAlumno.setText("");
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
		txtCodigoAlumno.setEditable(sino);
		txtCodigoCurso.setEditable(sino);
		btnAceptar.setEnabled(sino);	
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	void habilitarBusqueda(boolean sino){
		btnBuscar.setEnabled(sino);
		txtNumero.setEditable(sino);
	}
	
	//M�todos que retornan valor sin par�metros
	String obtenerDatosAlumno() {
	    Alumno a = aa.buscar(leerCodigoAlumno());
	    return "Nombres :  " + a.getNombres() + "\n" +
		       "Apellidos :  " + a.getApellidos();
	}
	
	String obtenerDatosCurso() {
	    Curso c = ac.buscar(leerCodigoCurso());
	    return "Asignatura :  " + c.getAsignatura();
	}
	
	int leerNumeroMatricula(){
		return Integer.parseInt(txtNumero.getText().trim());
	}
	
	int leerCodigoAlumno(){
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
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
	
	protected void keyTypedTxtNumeroMatricula(KeyEvent arg0) {
		if(txtNumero.getText().length() >= 6){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtCodigoAlumno(KeyEvent arg0) {
		if(txtCodigoAlumno.getText().length() >= 9){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtCodigoCurso(KeyEvent arg0) {
		if(txtCodigoCurso.getText().length() >= 4){
			arg0.consume();
		}
	}
}
