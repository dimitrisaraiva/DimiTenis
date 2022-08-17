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
import javax.swing.JCheckBox;

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
				//logica para verificar o checkbox
				if(chkSenha.isSelected()) {
					alterarUsuarioSenha();
				}else
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
		
		chkSenha = new JCheckBox("Alterar senha");
		chkSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuSenha.setText(null);
				txtUsuSenha.requestFocus();
				txtUsuSenha.setEditable(true);
			}
		});
		chkSenha.setVisible(false);
		chkSenha.setBounds(256, 35, 125, 23);
		contentPanel.add(chkSenha);

		validarSenha.setLimit(255);

	}// fim do construtor

	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JCheckBox chkSenha;

	

	/**
	 * Metodo responsavel pela pesquisa de usuario
	 */

	private void pesquisarUsuario() {
		// validação
		if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o login do usuário");
			txtUsuLogin.requestFocus();
		} else {
			// lógica principal
			// Query (instrução SQL)
			String read = "select * from usuarios where login = ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtUsuLogin.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// Validação (existência de usuário)
				// rs.next() -> existência de usuário
				if (rs.next()) {
					// preencher(setar) os campos do formulário
					txtUsuId.setText(rs.getString(1));
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(5));
					txtUsuSenha.setText(rs.getString(4));
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					chkSenha.setVisible(true);
					txtUsuSenha.setEditable(false);

				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
				}
				// NUNCA esquecer de encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsável por adicionar um novo usuário no banco
	 */
	private void adicionarUsuario() {
		// validação da senha (captura segura)
		String capturaSenha = new String(txtUsuSenha.getPassword());

		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuário");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String create = "insert into usuarios(usuario,login,senha,perfil) values(?,?,md5(?),?)";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteúdo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				// Executar a query e inserir o usuário no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Método responsável por alterar os dados de um usuário no banco exceto a senha
	 */
	private void alterarUsuario() {
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuário");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String update = "update usuarios set usuario=?, login=?, perfil=? where idusu=?";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ????? pelo conteúdo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(4, txtUsuId.getText());
				// Executar a query e inserir o usuário no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Dados do usuário exceto senha, alterados com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsável por alterar os dados de um usuário e sua respectiva senha no banco
	 */
	private void alterarUsuarioSenha() {
		// validação da senha (captura segura)
		String capturaSenha = new String(txtUsuSenha.getPassword());
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuário");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String update2 = "update usuarios set usuario=?, login=?,senha=md5(?), perfil=? where idusu=?";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update2);
				// Substituir os ????? pelo conteúdo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(5, txtUsuId.getText());
				// Executar a query e inserir o usuário no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsável por excluir um usuário do banco
	 */
	private void excluirUsuario() {
		// validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confima a exclusão do usuário?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// lógica principal
			String delete = "delete from usuarios where idusu=?";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a query(comando sql) substituindo a ? pelo idusu
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtUsuId.getText());
				// Executar a query
				pst.executeUpdate();
				// confimação
				limparCampos();
				JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
				// encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método usado para limpar e validar os campos e objetos do formulário
	 */
	private void limparCampos() {
		txtUsuId.setText(null);
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		txtUsuSenha.setEditable(true);
		cboUsuPerfil.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		chkSenha.setVisible(false);
		chkSenha.setSelected(false);
	}
}// fim do código
