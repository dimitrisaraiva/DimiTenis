package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.KeyAdapter;

public class Clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPesquisarClientes;
	private JTextField txtCliId;
	private JTextField txtCliNascimento;
	private JTextField txtCliNome;
	private JTextField txtCliCPF;
	private JTextField txtCliFone;
	private JTextField txtCliEmail;
	private JTextField txtCliCEP;
	private JTextField txtCliEndereco;
	private JTextField txtCliNumero;
	private JTextField txtCliBairro;
	private JTextField txtCliCidade;
	private JTextField textField_16;
	private JTable tblClientes;
	private JTextField txtCliComp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/Clientes.png")));
		setTitle("Clientes");
		setModal(true);
		setBounds(100, 100, 815, 436);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 799, 399);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBounds(0, 0, 799, 397);
		contentPanel.add(contentPanel_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(45, 27, 65, 14);
		contentPanel_1.add(lblCliente);
		
		JLabel lblNewLabel_1 = new JLabel("IDCLI");
		lblNewLabel_1.setBounds(10, 116, 40, 14);
		contentPanel_1.add(lblNewLabel_1);
		
		txtPesquisarClientes = new JTextField();
		txtPesquisarClientes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarClientesTabela();
			}
		});
		txtPesquisarClientes.setColumns(10);
		txtPesquisarClientes.setBounds(120, 24, 86, 20);
		contentPanel_1.add(txtPesquisarClientes);
		
		txtCliId = new JTextField();
		txtCliId.setColumns(10);
		txtCliId.setBounds(45, 113, 25, 20);
		contentPanel_1.add(txtCliId);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(154, 116, 37, 14);
		contentPanel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NOME");
		lblNewLabel_4.setBounds(338, 116, 40, 14);
		contentPanel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NASCIMENTO");
		lblNewLabel_5.setBounds(579, 116, 86, 14);
		contentPanel_1.add(lblNewLabel_5);
		
		txtCliNascimento = new JTextField();
		txtCliNascimento.setColumns(10);
		txtCliNascimento.setBounds(654, 113, 135, 20);
		contentPanel_1.add(txtCliNascimento);
		
		txtCliNome = new JTextField();
		txtCliNome.setColumns(10);
		txtCliNome.setBounds(388, 113, 186, 20);
		contentPanel_1.add(txtCliNome);
		
		txtCliCPF = new JTextField();
		txtCliCPF.setColumns(10);
		txtCliCPF.setBounds(182, 113, 146, 20);
		contentPanel_1.add(txtCliCPF);
		
		JLabel lblNewLabel_6 = new JLabel("Fone");
		lblNewLabel_6.setBounds(10, 166, 46, 14);
		contentPanel_1.add(lblNewLabel_6);
		
		txtCliFone = new JTextField();
		txtCliFone.setColumns(10);
		txtCliFone.setBounds(45, 163, 146, 20);
		contentPanel_1.add(txtCliFone);
		
		JLabel lblNewLabel_11 = new JLabel("E-mail");
		lblNewLabel_11.setBounds(215, 166, 40, 14);
		contentPanel_1.add(lblNewLabel_11);
		
		txtCliEmail = new JTextField();
		txtCliEmail.setColumns(10);
		txtCliEmail.setBounds(257, 163, 241, 20);
		contentPanel_1.add(txtCliEmail);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(516, 166, 25, 14);
		contentPanel_1.add(lblNewLabel_12);
		
		txtCliCEP = new JTextField();
		txtCliCEP.setColumns(10);
		txtCliCEP.setBounds(544, 163, 209, 20);
		contentPanel_1.add(txtCliCEP);
		
		JButton btnNewButton = new JButton("Buscar CEP");
		btnNewButton.setBounds(585, 194, 123, 23);
		contentPanel_1.add(btnNewButton);
		
		JLabel lblNewLabel_13 = new JLabel("Endere\u00E7o");
		lblNewLabel_13.setBounds(10, 198, 55, 14);
		contentPanel_1.add(lblNewLabel_13);
		
		txtCliEndereco = new JTextField();
		txtCliEndereco.setColumns(10);
		txtCliEndereco.setBounds(68, 194, 370, 20);
		contentPanel_1.add(txtCliEndereco);
		
		JLabel lblNewLabel_14 = new JLabel("N\u00FAmero");
		lblNewLabel_14.setBounds(10, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_14);
		
		txtCliNumero = new JTextField();
		txtCliNumero.setColumns(10);
		txtCliNumero.setBounds(60, 230, 162, 20);
		contentPanel_1.add(txtCliNumero);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(236, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_15);
		
		txtCliBairro = new JTextField();
		txtCliBairro.setColumns(10);
		txtCliBairro.setBounds(272, 230, 200, 20);
		contentPanel_1.add(txtCliBairro);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(482, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_16);
		
		txtCliCidade = new JTextField();
		txtCliCidade.setColumns(10);
		txtCliCidade.setBounds(522, 230, 256, 20);
		contentPanel_1.add(txtCliCidade);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(10, 271, 18, 14);
		contentPanel_1.add(lblNewLabel_17);
		
		cboCliUF = new JComboBox();
		cboCliUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboCliUF.setBounds(45, 267, 65, 22);
		contentPanel_1.add(cboCliUF);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(10, 333, 81, 14);
		contentPanel_1.add(lblNewLabel_18);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(101, 307, 216, 67);
		contentPanel_1.add(textField_16);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Adicionar");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(434, 368, 64, 64);
		contentPanel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setToolTipText("Editar");
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(505, 368, 64, 64);
		contentPanel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setToolTipText("Remover");
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(571, 368, 64, 64);
		contentPanel_1.add(btnNewButton_1_2);
		
		JLabel lblNewLabel = new JLabel("Marketing");
		lblNewLabel.setBounds(120, 271, 65, 14);
		contentPanel_1.add(lblNewLabel);
		
		cboCliMark = new JComboBox();
		cboCliMark.setModel(new DefaultComboBoxModel(new String[] {"", "SIM", "N\u00C3O"}));
		cboCliMark.setBounds(194, 267, 71, 22);
		contentPanel_1.add(cboCliMark);
		
		JButton btnAdicionarCliente = new JButton("");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			}
		});
		btnAdicionarCliente.setIcon(new ImageIcon(Clientes.class.getResource("/img/adicionar.png")));
		btnAdicionarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarCliente.setToolTipText("Adicionar");
		btnAdicionarCliente.setContentAreaFilled(false);
		btnAdicionarCliente.setBorderPainted(false);
		btnAdicionarCliente.setBounds(533, 307, 64, 64);
		contentPanel_1.add(btnAdicionarCliente);
		
		JButton btnAlterarCliente = new JButton("");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCliente();
			}
		});
		btnAlterarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterarCliente.setIcon(new ImageIcon(Clientes.class.getResource("/img/Editar.png")));
		btnAlterarCliente.setToolTipText("Editar");
		btnAlterarCliente.setContentAreaFilled(false);
		btnAlterarCliente.setBorderPainted(false);
		btnAlterarCliente.setBounds(628, 307, 64, 64);
		contentPanel_1.add(btnAlterarCliente);
		
		JButton btnRemoverCliente = new JButton("");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		btnRemoverCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoverCliente.setIcon(new ImageIcon(Clientes.class.getResource("/img/Remover.png")));
		btnRemoverCliente.setToolTipText("Remover");
		btnRemoverCliente.setContentAreaFilled(false);
		btnRemoverCliente.setBorderPainted(false);
		btnRemoverCliente.setBounds(714, 307, 64, 64);
		contentPanel_1.add(btnRemoverCliente);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setToolTipText("Buscar");
		lblNewLabel_2_1.setBounds(216, 18, 32, 32);
		contentPanel_1.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 779, 57);
		contentPanel_1.add(scrollPane);
		
		txtCliComp = new JTextField();
		txtCliComp.setColumns(10);
		txtCliComp.setBounds(357, 262, 141, 32);
		contentPanel_1.add(txtCliComp);
		
	
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblClientes);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarClientes();
			}
		});
		btnPesquisar.setBounds(80, 112, 64, 23);
		contentPanel_1.add(btnPesquisar);
		JLabel lblNewLabel_18_1 = new JLabel("Complemento");
		lblNewLabel_18_1.setBounds(282, 271, 71, 14);
		contentPanel_1.add(lblNewLabel_18_1);
		
		
		
		RestrictedTextField validarId = new RestrictedTextField(txtCliId);
		validarId.setOnlyNums(true);
		validarId.setLimit(4);
		
		RestrictedTextField validarNome = new RestrictedTextField(txtCliNome);
		validarNome.setLimit(30);
		
		RestrictedTextField validarCPF = new RestrictedTextField(txtCliCPF);
		validarCPF.setLimit(15);
		
		RestrictedTextField validarFone = new RestrictedTextField(txtCliFone);
		validarFone.setLimit(20);
		
		RestrictedTextField validarEmail = new RestrictedTextField(txtCliEmail);
		validarEmail.setLimit(30);
		
		RestrictedTextField validarCep = new RestrictedTextField(txtCliCEP);
		validarCep.setLimit(15);
		
		RestrictedTextField validarEndereco = new RestrictedTextField(txtCliEndereco);
		validarEndereco.setLimit(50);
		
		RestrictedTextField validarNumero = new RestrictedTextField(txtCliNumero);
		validarNumero.setLimit(10);

		RestrictedTextField validarComp = new RestrictedTextField(txtCliComp);
		validarComp.setLimit(30);
		
		RestrictedTextField validarBairro = new RestrictedTextField(txtCliBairro);
		validarBairro.setLimit(50);
		
		RestrictedTextField validarCidade = new RestrictedTextField(txtCliCidade);
		validarCidade.setLimit(15);
	}
	
	DAO dao = new DAO();
	private JComboBox cboCliUF;
	private JComboBox cboCliMark;
	
	private void pesquisarClientesTabela() {
		
		String readT = "select idcli as ID,nome as clientes,fone,cpf from clientes where nome like ?";
		try {
			
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Setar o argumento (id)
			// Substituir o ? pelo conteúdo da caixa de texto
			pst.setString(1, txtPesquisarClientes.getText() + "%");
			ResultSet rs = pst.executeQuery();
			//usu da biblioteca rs2xml para popular a tabela
			tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}
	
	private void setarCaixasTexto() {
		
		int setar = tblClientes.getSelectedRow();
		txtCliId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
		txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
		
	}
	private void PesquisarClientes() {
		if (txtCliId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID do clientes");
			txtCliId.requestFocus();
		} else {
			// lógica principal
			// query principal ( Instrução SQL)
			String read = "select * from clientes where idcli = ?";
			// tratar excessões sempre que lidar com o banco
			try {
				// estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da Query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtCliId.getText());
				// Executar a query e exibir o resultado no formulário
				ResultSet rs = pst.executeQuery();
				// Validação (existência de usuário)
				// rs.next() -> existência de usuário
				if(rs.next()) {
					// preencher(setar) os campos do formulário
					txtCliId.setText(rs.getString(1));
					txtCliNome.setText(rs.getString(2));
					txtCliNascimento.setText(rs.getString(3));
					txtCliFone.setText(rs.getString(4));
					txtCliCPF.setText(rs.getString(5));
					txtCliEmail.setText(rs.getString(6));
					cboCliMark.setSelectedItem(rs.getString(7));
					txtCliCEP.setText(rs.getString(8));					
					txtCliEndereco.setText(rs.getString(9));
					txtCliNumero.setText(rs.getString(10));
					txtCliComp.setText(rs.getString(11));
					txtCliBairro.setText(rs.getString(12));
					txtCliCidade.setText(rs.getString(13));
					cboCliUF.setSelectedItem(rs.getString(14));
				}else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
				}
				con.close();
				} catch (Exception e) {
				System.out.println(e);
			}
				// NUNCA esquecer de encerrar a conexão
				
		
	}
}
	
	private void adicionarCliente() {
		if (txtCliNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome Do Cliente");
			txtCliNome.requestFocus();
			
		} else if (txtCliNascimento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome a Data de Nascimento do cliente");
			txtCliNascimento.requestFocus();
			
		} else if (txtCliFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o Telefone do cliente");
			txtCliFone.requestFocus();
			
	}else if (txtCliCPF.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Infome O CPF do Cliente");
		txtCliCPF.requestFocus();
		
	}else if (cboCliMark.getSelectedItem().equals("")) {
		JOptionPane.showMessageDialog(null, "Infome o se o cliente deseja receber informações");
		cboCliMark.requestFocus();
	}else {
		 
		String create = "insert into clientes(nome,nascimento,fone,cpf,email,mkt,cep,endereco,numero,complemento,bairro,cidade,uf)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// Estabelecer a conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os ???? pelo conteúdo das caixas de texto
			pst.setString(1, txtCliNome.getText());
			pst.setString(2,txtCliNascimento.getText());
			pst.setString(3,txtCliFone.getText());
			pst.setString(4, txtCliCPF.getText());
			pst.setString(5,txtCliEmail.getText());
			pst.setString(6, cboCliMark.getSelectedItem().toString());
			pst.setString(7,txtCliCEP.getText());
			pst.setString(8,txtCliEndereco.getText());
			pst.setString(9,txtCliNumero.getText());
			pst.setString(10,txtCliComp.getText());
			pst.setString(11,txtCliBairro.getText());
			pst.setString(12,txtCliCidade.getText());
			pst.setString(13,cboCliUF.getSelectedItem().toString());
			// Executar a query e inserir o usuário no banco
			pst.executeUpdate();
			// Encerrar a conexão
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
			con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	}
	
	private void alterarCliente() {
		// valida��o
		if (txtCliNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o nome");
			txtCliNome.requestFocus();
		} else if (txtCliNascimento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe a data de nascimento do cliente");
			txtCliNascimento.requestFocus();
		} else if (txtCliFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o telefone do cliente");
			txtCliFone.requestFocus();
		} else if (txtCliCPF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o CPF do cliente");
			txtCliCPF.requestFocus();
		} else if (cboCliMark.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Infome o se o cliente deseja receber informações");
			cboCliMark.requestFocus();
		} else {
			// l�gica principal
			String update = "update clientes set nome=?, nascimento=?, fone=?, cpf=?, email=?, mkt=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, uf=? where idcli=?";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da Query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtCliNome.getText());
				pst.setString(2, txtCliNascimento.getText());
				pst.setString(3, txtCliFone.getText());
				pst.setString(4, txtCliCPF.getText());
				pst.setString(5, txtCliEmail.getText());
				pst.setString(6, cboCliMark.getSelectedItem().toString());
				pst.setString(7, txtCliCEP.getText());
				pst.setString(8, txtCliEndereco.getText());
				pst.setString(9, txtCliNumero.getText());
				pst.setString(10, txtCliComp.getText());
				pst.setString(11, txtCliBairro.getText());
				pst.setString(12, txtCliCidade.getText());
				pst.setString(13, cboCliUF.getSelectedItem().toString());
				pst.setString(14, txtCliId.getText());
				// Executar a query e alterar o cliente no banco
				pst.executeUpdate();
				// confirmação
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
				// Encerrar a conexão
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "CPF em uso.\nEscolha outro CPF");
				txtCliCPF.setText(null);
				txtCliCPF.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void excluirCliente() {
		// validação (confirmação da exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from clientes where idcli=?";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da Query
				PreparedStatement pst = con.prepareStatement(delete);
				// Substituir o ? pelo conte�do da caixa de texto
				pst.setString(1, txtCliId.getText());
				// Executar a query e excluir o cliente do banco
				pst.executeUpdate();
				// confirmação
				JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
				// Encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	}
	
	

