package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import clases.*;
import arreglos.*;
import libreria.Lib;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class DlgCurso extends JDialog implements ActionListener, KeyListener, MouseListener  {
	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCdigo;
	private JLabel lblNewLabel;
	private JLabel lblCiclo;
	private JLabel lblNoCrditos;
	private JLabel lblCantHoras;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JComboBox<String> cboCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblCurso;
	private DefaultTableModel modelo;
	private JButton btnConsultar;
	private JButton btnBuscar;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCurso dialog = new DlgCurso();
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
	public DlgCurso() {
		getContentPane().setBackground(new Color(204, 204, 204));
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Curso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCurso.class.getResource("/img/SAN.png")));
		setBounds(100, 100, 662, 533);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 636, 256);
		getContentPane().add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�DIGO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("CICLO");
		modelo.addColumn("CR�DITOS");
		modelo.addColumn("HORAS");
		tblCurso.setModel(modelo);
		
		panel = new JPanel();
		panel.setBounds(459, 27, 166, 152);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(0, 0, 0));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(10, 11, 143, 23);
		panel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 0, 0));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(10, 45, 143, 23);
		panel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(10, 79, 143, 23);
		panel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(10, 113, 143, 23);
		panel.add(btnEliminar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 27, 320, 173);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(92, 11, 86, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.addKeyListener(this);
		txtCodigo.setColumns(10);
		
		soloNumeros(txtCodigo);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 14, 94, 14);
		panel_1.add(lblCdigo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(92, 42, 215, 20);
		panel_1.add(txtAsignatura);
		txtAsignatura.addKeyListener(this);
		txtAsignatura.setColumns(10);
		
		lblNewLabel = new JLabel("Asignatura:");
		lblNewLabel.setBounds(10, 45, 94, 14);
		panel_1.add(lblNewLabel);
		
		cboCiclo = new JComboBox<String>();
		cboCiclo.setBounds(92, 73, 86, 20);
		panel_1.add(cboCiclo);
		cboCiclo.setModel(new DefaultComboBoxModel<String>(Lib.ciclocursos));
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(10, 76, 94, 14);
		panel_1.add(lblCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(92, 104, 86, 20);
		panel_1.add(txtCreditos);
		txtCreditos.addKeyListener(this);
		txtCreditos.setColumns(10);
		soloNumeros(txtCreditos);
		
		lblNoCrditos = new JLabel("No. Cr\u00E9ditos:");
		lblNoCrditos.setBounds(10, 107, 94, 14);
		panel_1.add(lblNoCrditos);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(188, 10, 89, 23);
		panel_1.add(btnBuscar);
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		
		
		txtHoras = new JTextField();
		txtHoras.setBounds(92, 135, 86, 20);
		panel_1.add(txtHoras);
		txtHoras.addKeyListener(this);
		txtHoras.setColumns(10);
		soloNumeros(txtHoras);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(188, 134, 119, 23);
		panel_1.add(btnAceptar);
		
		lblCantHoras = new JLabel("Cant. Horas:");
		lblCantHoras.setBounds(10, 138, 94, 14);
		panel_1.add(lblCantHoras);
		
		label_1 = new JLabel("\r\n");
		label_1.setIcon(new ImageIcon(DlgCurso.class.getResource("/img/WhatsApp Image 2021-11-29 at 12.09.48 AM.jpeg")));
		label_1.setBounds(359, 43, 90, 136);
		getContentPane().add(label_1);
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	
	//Declaraci�n global
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	private JLabel label_1;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			BtnBuscar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			BtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			BtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			BtnEliminar(arg0);
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
		btnAdicionar.setEnabled(false);
		limpiar();
		txtCodigo.setEditable(true);
		txtCodigo.setText("");
		txtCodigo.requestFocus();
	}
	
	//Modificar
	protected void BtnModificar(ActionEvent arg0) {
		habilitarBotones(true);
		btnModificar.setEnabled(false);
		try{
			if (ac.tamano() == 0) {
				btnAceptar.setEnabled(false);
				habilitarEntradas(false);
				mensaje("No existen alumnos");	
			}
			else{
				habilitarBotones(true);
				habilitarEntradas(false);
				habilitarBusqueda(true);
				btnModificar.setEnabled(false);
				limpiar();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
		catch(Exception e){
			txtCodigo.requestFocus();
		}
	}

	//Consultar
	protected void BtnConsultar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(false);
		habilitarBusqueda(true);
		btnConsultar.setEnabled(false);
		limpiar();
		txtCodigo.requestFocus();
	}
	
	//Eliminar
	protected void BtnEliminar(ActionEvent arg0) {
		habilitarBotones(true);
		if (ac.tamano() == 0)
			mensaje("No existen cursos registrados");
		else{
			habilitarEntradas(false);
			try{
				int codigoCurso = leerCodigoCurso();
				Matricula m = am.buscarCurso(codigoCurso);
				if(m == null){
					int ok = confirmar("� Esta seguro de eliminar el registro ?");
					if (ok == 0) {
						ac.eliminar(ac.buscar(codigoCurso));
						listar();
						editarFila();
					}
				}
				else
					mensaje("Existen alumnos matriculados en este curso");
			}
			catch(Exception e){
				txtCodigo.requestFocus();
			}
		}
	}
	
	//Aceptar
	protected void BtnAceptar(ActionEvent arg0) {
		try{
			int codigoCurso = leerCodigoCurso();
			String asignatura = leerAsignaturaCurso();
			if (asignatura.length() > 0){
				int ciclo = leerCicloCurso();
				try{
					int creditos = leerCreditosCurso();
					try{
						int horas = leerHorasCurso();
							if (btnAdicionar.isEnabled() == false) {
								Curso c = ac.buscar(codigoCurso);
								if(c == null){
								Curso nuevo = new Curso(codigoCurso, asignatura, ciclo, creditos, horas);
								ac.adicionar(nuevo);
								limpiar();
								txtCodigo.setEditable(false);
								btnAdicionar.setEnabled(true);
								}
								else{
									mensaje("El c�digo ya existe");
									limpiar();
									txtCodigo.setEditable(false);
									btnAdicionar.setEnabled(true);
								}
							}
							if (btnModificar.isEnabled() == false) {
								Curso c = ac.buscar(codigoCurso);
								c.setAsignatura(asignatura);
								c.setCiclo(ciclo);
								c.setCreditos(creditos);
								c.setHoras(horas);
								ac.actualizarArchivo();
								btnModificar.setEnabled(true);
							}
							listar();
							habilitarEntradas(false);
						}
					catch(Exception e){
						error("Ingrese cantidad de horas", txtHoras);
					}
				}
				catch(Exception e){
					error("Ingrese cantidad de creditos", txtCreditos);
				}
			}
			else
				error("Ingrese asignatura", txtAsignatura);
		}
		catch(Exception e){
			error("Ingrese c�digo del Curso", txtCodigo);
		}
	}
	
	//Buscar
	protected void BtnBuscar(ActionEvent arg0) {
		try{
			int codigoCurso = leerCodigoCurso();
			Curso c = ac.buscar(codigoCurso);
			if(btnModificar.isEnabled() == false){
				if(c != null){
					txtAsignatura.setText(c.getAsignatura());
					cboCiclo.setSelectedIndex(c.getCiclo());
					txtCreditos.setText(""+c.getCreditos());
					txtHoras.setText(""+c.getHoras());
					habilitarEntradas(true);
					habilitarBotones(true);
					btnModificar.setEnabled(false);
					habilitarBusqueda(false);
				}
				else
					error("El c�digo " + codigoCurso + " no existe", txtCodigo);
			}
			else{
				if(c != null){
					txtAsignatura.setText(c.getAsignatura());
					cboCiclo.setSelectedIndex(c.getCiclo());
					txtCreditos.setText(""+c.getCreditos());
					txtHoras.setText(""+c.getHoras());
					habilitarEntradas(false);
					habilitarBotones(true);
					habilitarBusqueda(false);
				}
				else
					error("El c�digo " + codigoCurso + " no existe", txtCodigo);
			}
		}
		catch(Exception e){
			error("Ingrese un c�digo", txtCodigo);
		}
	}
	
	public void keyPressed(KeyEvent arg0) {
	}
	
	public void keyReleased(KeyEvent arg0) {	
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtAsignatura) {
			keyTypedTxtAsignatura(arg0);
		}
		if (arg0.getSource() == txtCreditos) {
			keyTypedTxtCreditos(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigoCurso(arg0);
		}
		if (arg0.getSource() == txtHoras) {
			keyTypedTxtHoras(arg0);
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCurso) {
			mouseClickedTblCurso(arg0);
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
		if (arg0.getSource() == tblCurso) {
			mouseEnteredTblCurso(arg0);
		}
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	protected void mouseClickedTblCurso(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	protected void mouseEnteredTblCurso(MouseEvent arg0) {
		tblCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		TableColumnModel tcm = tblCurso.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); //codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(50)); //asignatura
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); //ciclo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); //creditos
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); //horas
	}
	
	void listar(){
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCurso.getSelectedRow();
		if (modelo.getRowCount() == ac.tamano() - 1)
			posFila = ac.tamano() - 1;
		if (posFila == ac.tamano())
			posFila --;
		modelo.setRowCount(0);
		Curso x;
		for (int i=0; i<ac.tamano(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodCurso(),
							  x.getAsignatura(),
			          		  enTextoCiclo(x.getCiclo()),
			                  x.getCreditos(),
			                  x.getHoras()};
			modelo.addRow(fila);
		}
		if (ac.tamano() > 0)
			tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila(){
		if (ac.tamano() == 0)
			limpiar();
		else{
			Curso x = ac.obtener(tblCurso.getSelectedRow());
			txtCodigo.setText("" + x.getCodCurso());
			txtAsignatura.setText(x.getAsignatura());
			cboCiclo.setSelectedIndex(x.getCiclo());
			txtCreditos.setText(String.valueOf(x.getCreditos()));
			txtHoras.setText(String.valueOf(x.getHoras()));
		}
	}
	
	void limpiar(){
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
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
	
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtAsignatura.setEditable(sino);
		cboCiclo.setEnabled(sino);
		txtCreditos.setEditable(sino);
		txtHoras.setEditable(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	void habilitarBusqueda(boolean sino) {
		btnBuscar.setEnabled(sino);
		txtCodigo.setEditable(sino);
	}
	
	//M�todos que retornan valor (sin par�metros)
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerAsignaturaCurso(){
		return txtAsignatura.getText().trim();
	}
	
	int leerCicloCurso(){
		return cboCiclo.getSelectedIndex();
	}
	
	int leerCreditosCurso(){
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	
	int leerHorasCurso(){
		return Integer.parseInt(txtHoras.getText().trim());
	}
	
	//M�todos que retornan valor (con par�metros)
	String enTextoCiclo(int i){
		return cboCiclo.getItemAt(i);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
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
	
	protected void keyTypedTxtCodigoCurso(KeyEvent arg0) {
		if(txtCodigo.getText().length() >= 4){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtCreditos(KeyEvent arg0) {
		if(txtCreditos.getText().length() >= 2){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtHoras(KeyEvent arg0) {
		if(txtHoras.getText().length() >= 2){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtAsignatura(KeyEvent arg0) {
		if(arg0.getKeyChar()>=33 && arg0.getKeyChar()<=64 
			|| arg0.getKeyChar()>=91 && arg0.getKeyChar()<=96
			|| arg0.getKeyChar()>=123 && arg0.getKeyChar()<=179
			|| arg0.getKeyChar()>=181 && arg0.getKeyChar()<=192
			|| arg0.getKeyChar()>=194 && arg0.getKeyChar()<=200
			|| arg0.getKeyChar()>=202 && arg0.getKeyChar()<=204
			|| arg0.getKeyChar()>=206 && arg0.getKeyChar()<=208
			|| arg0.getKeyChar()==210 
			|| arg0.getKeyChar()>=212 && arg0.getKeyChar()<=217
			|| arg0.getKeyChar()>=219 && arg0.getKeyChar()<=224
			|| arg0.getKeyChar()>=226 && arg0.getKeyChar()<=232
			|| arg0.getKeyChar()>=234 && arg0.getKeyChar()<=236
			|| arg0.getKeyChar()>=238 && arg0.getKeyChar()<=240
			|| arg0.getKeyChar()==242
			|| arg0.getKeyChar()>=244 && arg0.getKeyChar()<=249
			|| arg0.getKeyChar()>=251 && arg0.getKeyChar()<=255){
			arg0.consume();
		}
	}
}
