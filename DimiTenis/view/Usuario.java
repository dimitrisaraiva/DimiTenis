package view;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Usuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JTextField txtUsuLogin;
	private JPasswordField txtUsuSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Usuario dialog = new Usuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Usuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/img/Usuario.png")));
		setModal(true);
		setTitle("Usu\u00E1rios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(35, 35, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(35, 41, 46, 14);
		contentPanel.add(lblNewLabel);

		txtUsuId = new JTextField();
		txtUsuId.setEditable(false);
		txtUsuId.setBounds(80, 38, 141, 20);
		contentPanel.add(txtUsuId);
		txtUsuId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setBounds(35, 88, 46, 14);
		contentPanel.add(lblNewLabel_2);

		txtUsuNome = new JTextField();
		txtUsuNome.setEditable(false);
		txtUsuNome.setBounds(80, 85, 254, 20);
		contentPanel.add(txtUsuNome);
		txtUsuNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setBounds(35, 120, 46, 14);
		contentPanel.add(lblNewLabel_3);

		txtUsuLogin = new JTextField();
		txtUsuLogin.setBounds(80, 117, 141, 20);
		contentPanel.add(txtUsuLogin);
		txtUsuLogin.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setBounds(35, 151, 46, 14);
		contentPanel.add(lblNewLabel_4);

		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setEditable(false);
		txtUsuSenha.setBounds(80, 148, 254, 20);
		contentPanel.add(txtUsuSenha);

		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "user" }));
		cboUsuPerfil.setBounds(320, 116, 61, 22);
		contentPanel.add(cboUsuPerfil);

		JLabel lblNewLabel_5 = new JLabel("Perfil");
		lblNewLabel_5.setBounds(280, 120, 30, 14);
		contentPanel.add(lblNewLabel_5);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
		});
		btnAlterar.setIcon(new ImageIcon(Usuario.class.getResource("/img/Editar.png")));
		btnAlterar.setToolTipText("Editar");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(182, 179, 64, 64);
		contentPanel.add(btnAlterar);

		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}

		});
		btnPesquisar.setIcon(new ImageIcon(Usuario.class.getResource("/img/lupa1.png")));
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setBounds(225, 107, 32, 32);
		contentPanel.add(btnPesquisar);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setIcon(new ImageIcon(Usuario.class.getResource("/img/adicionar.png")));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(92, 179, 64, 64);
		contentPanel.add(btnAdicionar);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Usuario.class.getResource("/img/Remover.png")));
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(270, 179, 64, 64);
		contentPanel.add(btnExcluir);

		RestrictedTextField validarId = new RestrictedTextField(txtUsuId);
		validarId.setOnlyNums(true);
		validarId.setLimit(4);
		// UsuNome
		RestrictedTextField validarNome = new RestrictedTextField(txtUsuNome);

		validarNome.setLimit(40);
		// UsuLogin
		RestrictedTextField validarLogin = new RestrictedTextField(txtUsuLogin);

		validarLogin.setLimit(40);
		// UsuSenha
		RestrictedTextField validarSenha = new RestrictedTextField(txtUsuSenha);

		validarSenha.setLimit(255);

	}// fim do construtor

	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnPesquisar;

	

	/**
	 * Metodo responsavel pela pesquisa de usuario
	 */

	private void pesquisarUsuario() {
		// validação
		if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o login do usuário");
			txtUsuLogin.requestFocus();
		} else {
			// lógca principal
			// Querry (instrução SQL)
			String read = "select * from usuarios where login=?";
			// tratar exceções sempre que lidar com o banco
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteudo da caixa de texto
				pst.setString(1, txtUsuLogin.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();

				// validação (existencia de usuario)
				// rs.next() -> Existencia de usuario
				if (rs.next()) {
					// preencher(setar) os campos do fomulario
					txtUsuId.setText(rs.getString(1));
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(4));
					txtUsuSenha.setText(rs.getString(5));
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEnabled(true);
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					

				} else {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
					txtUsuLogin.setEditable(false);
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
				
				}
				// Nunca esquecer de encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	};

	/**
	 * Método responsavel por adicionar usuario no banco
	 */
	private void adicionarUsuario() {
		// validação
		// validação da senha
		String capturaSenha = new String(txtUsuSenha.getPassword());

		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite as informações do usuario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite as informações do login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite as informações do perfil");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite a senha");
			txtUsuSenha.requestFocus();
		} else {
			// Lógica principal
			String create = "insert into usuarios(usuario,login,senha,perfil)" + "values(?,?,md5(?),?)";
			try {
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ??? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
				limparCampos();
				con.close();
			} catch(SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso, escolha outro login");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	
	
	//alterar usuario
	
	private void alterarUsuario() {
		// validação
		// validação da senha
		String capturaSenha = new String(txtUsuSenha.getPassword());

		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite as informações do usuario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite as informações do login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite as informações do perfil");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite a senha");
			txtUsuSenha.requestFocus();
		} else {
			// Lógica principal
			String update = "update usuarios set usuario=?, login=?,senha=md5(?), perfil=? where idusu=?";
			try {
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ??? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(5, txtUsuId.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
				limparCampos();
				con.close();
			} catch(SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso, escolha outro login");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	//excluir usuario
	
	private void excluirUsuario() {
		// validação
		// validação da senha
		int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a exclusão?","Atenção!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION);
			// Lógica principal
			String delete = "delete from usuarios where idusu=?";
			try {
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(delete);
				// Substituir os ??? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuId.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");
				limparCampos();
				con.close();
			
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	

	private void limparCampos() {
		txtUsuId.setText(null);
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		cboUsuPerfil.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		txtUsuNome.setEditable(false);
		txtUsuLogin.setEditable(true);
		cboUsuPerfil.setEnabled(false);
		txtUsuSenha.setEditable(false);
	}

}// fim do codigo
