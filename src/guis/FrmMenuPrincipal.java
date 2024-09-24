package guis;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FrmMenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmAlumnosConMatricula;
	private JMenuItem mntmAlumnosConMatricula_1;
	private JMenuItem mntmAlumnosMatriculadosPor;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCursos;
	private JMenuItem mntmMatriculas;
	private JMenuItem mntmRetiros;
	private JMenuItem mntmMatricula;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenuPrincipal.class.getResource("/img/SAN.png")));
		setTitle("I.E. San Francis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 725);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/home.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon("C:\\Users\\uset\\Downloads\\Login.png"));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.setIcon(new ImageIcon("C:\\Users\\uset\\Downloads\\usuario.png"));
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/registro.png")));
		menuBar.add(mnRegistro);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		
		mntmMatricula = new JMenuItem("Matr\u00EDcula");
		mntmMatricula.addActionListener(this);
		mnRegistro.add(mntmMatricula);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/consulta.png")));
		menuBar.add(mnConsulta);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.addActionListener(this);
		mnConsulta.add(mntmAlumnos);
		
		mntmCursos = new JMenuItem("Cursos");
		mntmCursos.addActionListener(this);
		mnConsulta.add(mntmCursos);
		
		mntmMatriculas = new JMenuItem("Matr\u00EDculas");
		mntmMatriculas.addActionListener(this);
		mnConsulta.add(mntmMatriculas);
		
		mntmRetiros = new JMenuItem("Retiros");
		mntmRetiros.addActionListener(this);
		mnConsulta.add(mntmRetiros);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/reporte.png")));
		menuBar.add(mnReporte);
		
		mntmAlumnosConMatricula = new JMenuItem("Alumnos con Matr\u00EDcula Pendiente");
		mntmAlumnosConMatricula.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatricula);
		
		mntmAlumnosConMatricula_1 = new JMenuItem("Alumnos con Matr\u00EDcula Vigente");
		mntmAlumnosConMatricula_1.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatricula_1);
		
		mntmAlumnosMatriculadosPor = new JMenuItem("Alumnos Matriculados por Curso");
		mntmAlumnosMatriculadosPor.addActionListener(this);
		mnReporte.add(mntmAlumnosMatriculadosPor);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/SAN.png")));
			lblNewLabel.setBounds(302, 34, 354, 571);
			contentPane.add(lblNewLabel);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(arg0);
		}
		if (arg0.getSource() == mntmRetiros) {
			actionPerformedMntmRetiros(arg0);
		}
		if (arg0.getSource() == mntmMatriculas) {
			actionPerformedMntmMatriculas(arg0);
		}
		if (arg0.getSource() == mntmCursos) {
			actionPerformedMntmCursos(arg0);
		}
		if (arg0.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(arg0);
		}
		if (arg0.getSource() == mntmAlumnosMatriculadosPor) {
			actionPerformedMntmAlumnosMatriculadosPor(arg0);
		}
		if (arg0.getSource() == mntmAlumnosConMatricula_1) {
			actionPerformedMntmAlumnosConMatricula_1(arg0);
		}
		if (arg0.getSource() == mntmAlumnosConMatricula) {
			actionPerformedMntmAlumnosConMatricula(arg0);
		}
		if (arg0.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(arg0);
		}
		if (arg0.getSource() == mntmCurso) {
			actionPerformedMntmCurso(arg0);
		}
		if (arg0.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int msj = JOptionPane.showConfirmDialog(null, "Desea salir del sistema?", "Alerta!",JOptionPane.YES_NO_OPTION);	
		
		if(msj == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	protected void actionPerformedMntmAlumno(ActionEvent arg0) {
		DlgAlumno objAlumnos = new DlgAlumno();
		objAlumnos.setVisible(true);
	}
	
	protected void actionPerformedMntmCurso(ActionEvent arg0) {
		DlgCurso objCurso = new DlgCurso();
		objCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmRetiro(ActionEvent arg0) {
		DlgRetiro objRetiro = new DlgRetiro();
		objRetiro.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumnosConMatricula(ActionEvent arg0) {
		DlgAMPendiente objAlumnosMatriculaPendiente = new DlgAMPendiente();
		objAlumnosMatriculaPendiente.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumnosConMatricula_1(ActionEvent arg0) {
		DlgAMVigente objAlumnosMatriculaVigente = new DlgAMVigente();
		objAlumnosMatriculaVigente.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumnosMatriculadosPor(ActionEvent arg0) {
		DlgAMCurso objAlumnosMatriculadosCurso = new DlgAMCurso();
		objAlumnosMatriculadosCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumnos(ActionEvent arg0) {
		DlgCAlumnos objConsultaAlumnos = new DlgCAlumnos();
		objConsultaAlumnos.setVisible(true);
	}
	
	protected void actionPerformedMntmCursos(ActionEvent arg0) {
		DlgCCursos objConsultaCursos = new DlgCCursos();
		objConsultaCursos.setVisible(true);
	}
	
	protected void actionPerformedMntmMatriculas(ActionEvent arg0) {
		DlgCMatriculas objConsultaMatriculas = new DlgCMatriculas();
		objConsultaMatriculas.setVisible(true);
	}
	
	protected void actionPerformedMntmRetiros(ActionEvent arg0) {
		DlgCRetiros objConsultaRetiros = new DlgCRetiros();
		objConsultaRetiros.setVisible(true);
	}
	protected void actionPerformedMntmMatricula(ActionEvent arg0) {
		DlgMatricula objMatricula = new DlgMatricula();
		objMatricula.setVisible(true);
	}
}
