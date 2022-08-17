package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JTextField txtLogin;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(117, 0, 53, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setBounds(20, 36, 53, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(20, 67, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(80, 64, 121, 20);
		contentPane.add(txtSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(80, 33, 121, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("Login");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
			
		});
		btnEntrar.setBounds(100, 107, 79, 23);
		contentPane.add(btnEntrar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/Banco.png")));
		lblStatus.setToolTipText("Banco de dados");
		lblStatus.setBounds(231, 98, 32, 32);
		contentPane.add(lblStatus);
		
		RestrictedTextField validarSenha = new RestrictedTextField(txtSenha);
		validarSenha.setLimit(255);
		
		RestrictedTextField validarLogin = new RestrictedTextField(txtLogin);
		validarLogin.setLimit(40);
		
		//Usar o enter  para logar
		getRootPane().setDefaultButton(btnEntrar);
	}// fim do construtor
	
	// Criação ded um objeto para acessar a camada model
	DAO dao = new DAO();
	private JLabel lblStatus;
	
	/**
	 * 
	 * Método usando para verificar o status do servidor
	 */
	
	private void status(){
		try {
			Connection con = dao.conectar();
			if(con == null) {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
			}else {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
				
			
		}catch (Exception e) {
		
		System.out.println(e);
		}
	}
	
	/**
	 * Metodo usando para logar
	 */
	
	private void logar() {
		String capturaSenha = new String(txtSenha.getPassword());

		 if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite as informações do usuário");
			txtLogin.requestFocus();
		}
		 else if (txtSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a senha");
			txtSenha.requestFocus();
		}else {
			//Logica pricipal
			String read = "select * from usuarios where login=? and senha=md5(?)";
			try {
				
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Substituir os ??? pelo conteudo das caixas de texto
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					//Verificar perfil de usuario
					String perfil = rs.getString(5);
					//System.out.println(perfil);
					if (perfil.equals("admin")) {
					Principal principal = new Principal();
					principal.setVisible(true);
					principal.btnRelatorios.setEnabled(true);
					principal.btnUsuarios.setEnabled(true);
					principal.lblUsuario.setText(rs.getString(2));
					//encerrar conexão
					con.close();
					//fechar a tela de login
					this.dispose();
					} else {
						Principal principal = new Principal();
						principal.setVisible(true);
						principal.btnRelatorios.setEnabled(false);
						principal.btnUsuarios.setEnabled(false);
						//encerrar conexão
						con.close();
						//fechar a tela de login
						this.dispose();
					}
					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha inválido(s)");
					
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
}//fim do codigo
