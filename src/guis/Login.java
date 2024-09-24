package guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/Login.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 166);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/img/usuario.png")));
		lblUsuario.setBounds(10, 19, 112, 24);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setIcon(new ImageIcon(Login.class.getResource("/img/clave.png")));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(10, 65, 112, 24);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(132, 23, 127, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(211, 211, 211));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(276, 22, 89, 23);
		btnIngresar.addActionListener(this);
		contentPane.add(btnIngresar);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(132, 69, 127, 20);
		contentPane.add(txtContrasena);
	}
	public void actionPerformed(ActionEvent e) {
		actionPerformedbtnIngresar(e);
		
	}
	
	public void actionPerformedbtnIngresar(ActionEvent e) {
		
		char[] clave = txtContrasena.getPassword();
		String clavefinal = new String(clave);
		
		if(txtUsuario.getText().equals("Jhoan") && clavefinal.equals("1234"))
		{
			dispose();
			JOptionPane.showMessageDialog(null, "Ingreso al sistema", "Ingresaste" ,JOptionPane.INFORMATION_MESSAGE);
			FrmMenuPrincipal mp = new FrmMenuPrincipal();
			mp.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	}
}
	
