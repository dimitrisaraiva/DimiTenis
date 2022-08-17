package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fornecedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField textField_3;
	private JTextField txtForIm;
	private JTextField txtForRazao;
	private JTextField txtForIe;
	private JTextField txtForCnpj;
	private JTextField txtForFantasia;
	private JTextField txtForSite;
	private JTextField txtForFone;
	private JTextField txtForContato;
	private JTextField txtForEmail;
	private JTextField txtForCep;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTextField txtForObs;
	private JTable tblFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fornecedores dialog = new Fornecedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fornecedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/Fornecedores.png")));
		setTitle("Fornecedores");
		setModal(true);
		setBounds(100, 100, 706, 486);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 690, 447);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(45, 27, 65, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IDFOR");
		lblNewLabel_1.setBounds(10, 116, 40, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//EVENTO digitação
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		txtPesquisarFornecedor.setBounds(120, 24, 86, 20);
		contentPanel.add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/lupa1.png")));
		lblNewLabel_2.setToolTipText("Buscar");
		lblNewLabel_2.setBounds(215, 18, 32, 32);
		contentPanel.add(lblNewLabel_2);
		
		txtForId = new JTextField();
		txtForId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
			
		});
		txtForId.setBounds(45, 113, 25, 20);
		contentPanel.add(txtForId);
		txtForId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(153, 116, 37, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("IE");
		lblNewLabel_4.setBounds(323, 116, 10, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("IM");
		lblNewLabel_5.setBounds(489, 116, 17, 14);
		contentPanel.add(lblNewLabel_5);
		
		txtForIm = new JTextField();
		txtForIm.setColumns(10);
		txtForIm.setBounds(505, 113, 146, 20);
		contentPanel.add(txtForIm);
		
		JLabel lblNewLabel_7 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_7.setBounds(10, 166, 86, 14);
		contentPanel.add(lblNewLabel_7);
		
		txtForRazao = new JTextField();
		txtForRazao.setColumns(10);
		txtForRazao.setBounds(99, 163, 305, 20);
		contentPanel.add(txtForRazao);
		
		txtForIe = new JTextField();
		txtForIe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtForIe.setColumns(10);
		txtForIe.setBounds(335, 113, 135, 20);
		contentPanel.add(txtForIe);
		
		txtForCnpj = new JTextField();
		txtForCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtForCnpj.setColumns(10);
		txtForCnpj.setBounds(190, 113, 123, 20);
		contentPanel.add(txtForCnpj);
		
		JLabel lblNewLabel_8 = new JLabel("Nome Fantasia");
		lblNewLabel_8.setBounds(414, 166, 92, 14);
		contentPanel.add(lblNewLabel_8);
		
		txtForFantasia = new JTextField();
		txtForFantasia.setBounds(507, 163, 178, 20);
		contentPanel.add(txtForFantasia);
		txtForFantasia.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Site");
		lblNewLabel_9.setBounds(10, 213, 25, 14);
		contentPanel.add(lblNewLabel_9);
		
		txtForSite = new JTextField();
		txtForSite.setColumns(10);
		txtForSite.setBounds(37, 210, 169, 20);
		contentPanel.add(txtForSite);
		
		JLabel lblNewLabel_6 = new JLabel("Fone");
		lblNewLabel_6.setBounds(215, 213, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		txtForFone = new JTextField();
		txtForFone.setColumns(10);
		txtForFone.setBounds(249, 210, 146, 20);
		contentPanel.add(txtForFone);
		
		JLabel lblNewLabel_10 = new JLabel("Contato");
		lblNewLabel_10.setBounds(405, 213, 46, 14);
		contentPanel.add(lblNewLabel_10);
		
		txtForContato = new JTextField();
		txtForContato.setColumns(10);
		txtForContato.setBounds(450, 210, 201, 20);
		contentPanel.add(txtForContato);
		
		JLabel lblNewLabel_11 = new JLabel("E-mail");
		lblNewLabel_11.setBounds(10, 255, 40, 14);
		contentPanel.add(lblNewLabel_11);
		
		txtForEmail = new JTextField();
		txtForEmail.setColumns(10);
		txtForEmail.setBounds(60, 252, 241, 20);
		contentPanel.add(txtForEmail);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(308, 255, 25, 14);
		contentPanel.add(lblNewLabel_12);
		
		txtForCep = new JTextField();
		txtForCep.setColumns(10);
		txtForCep.setBounds(343, 252, 209, 20);
		contentPanel.add(txtForCep);
		
		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setBounds(562, 251, 123, 23);
		contentPanel.add(btnBuscarCep);
		
		JLabel lblNewLabel_13 = new JLabel("Endere\u00E7o");
		lblNewLabel_13.setBounds(10, 297, 55, 14);
		contentPanel.add(lblNewLabel_13);
		
		txtForEndereco = new JTextField();
		txtForEndereco.setColumns(10);
		txtForEndereco.setBounds(68, 294, 370, 20);
		contentPanel.add(txtForEndereco);
		
		JLabel lblNewLabel_14 = new JLabel("N\u00FAmero");
		lblNewLabel_14.setBounds(450, 297, 46, 14);
		contentPanel.add(lblNewLabel_14);
		
		txtForNumero = new JTextField();
		txtForNumero.setColumns(10);
		txtForNumero.setBounds(499, 294, 162, 20);
		contentPanel.add(txtForNumero);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(10, 337, 46, 14);
		contentPanel.add(lblNewLabel_15);
		
		txtForBairro = new JTextField();
		txtForBairro.setColumns(10);
		txtForBairro.setBounds(47, 334, 200, 20);
		contentPanel.add(txtForBairro);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(257, 337, 46, 14);
		contentPanel.add(lblNewLabel_16);
		
		txtForCidade = new JTextField();
		txtForCidade.setColumns(10);
		txtForCidade.setBounds(296, 334, 256, 20);
		contentPanel.add(txtForCidade);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(582, 337, 18, 14);
		contentPanel.add(lblNewLabel_17);
		
		cboForUf = new JComboBox();
		cboForUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboForUf.setBounds(610, 333, 41, 22);
		contentPanel.add(cboForUf);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(151, 365, 65, 14);
		contentPanel.add(lblNewLabel_18);
		
		txtForObs = new JTextField();
		txtForObs.setBounds(215, 368, 216, 67);
		contentPanel.add(txtForObs);
		txtForObs.setColumns(10);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarFornecedor();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/adicionar.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(434, 368, 64, 64);
		contentPanel.add(btnAdicionar);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Editar.png")));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setToolTipText("Editar");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setBounds(505, 368, 64, 64);
		contentPanel.add(btnEditar);
		
		JButton btnRemovar = new JButton("");
		btnRemovar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Remover.png")));
		btnRemovar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemovar.setToolTipText("Remover");
		btnRemovar.setContentAreaFilled(false);
		btnRemovar.setBorderPainted(false);
		btnRemovar.setBounds(571, 368, 64, 64);
		contentPanel.add(btnRemovar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 658, 57);
		contentPanel.add(scrollPane);
		
		tblFornecedor = new JTable();
		tblFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//evento clicar com o mouse na tabela
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedor);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFornecedores();
			}
		});
		btnPesquisar.setBounds(78, 112, 65, 23);
		contentPanel.add(btnPesquisar);
		
		txtForComp = new JTextField();
		txtForComp.setColumns(10);
		txtForComp.setBounds(20, 390, 170, 42);
		contentPanel.add(txtForComp);
		
		JLabel lblNewLabel_19 = new JLabel("Complemento");
		lblNewLabel_19.setBounds(45, 365, 96, 14);
		contentPanel.add(lblNewLabel_19);
		
		textField_3 = new JTextField();
		textField_3.setBounds(399, 119, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		//Validação
		
		RestrictedTextField validarId = new RestrictedTextField(txtForId);
		validarId.setOnlyNums(true);
		validarId.setLimit(4);
		
		RestrictedTextField validarCnpj = new RestrictedTextField(txtForCnpj);
		validarCnpj.setLimit(40);
		
		RestrictedTextField validarIe = new RestrictedTextField(txtForIe);
		validarIe.setLimit(40);
	
		RestrictedTextField validarIm = new RestrictedTextField(txtForIm);
		validarIm.setLimit(40);
		
		RestrictedTextField validarRazao = new RestrictedTextField(txtForRazao);
		validarRazao.setLimit(40);
		
		RestrictedTextField validarFantasia = new RestrictedTextField(txtForFantasia);
		validarFantasia.setLimit(30);
		
		RestrictedTextField validarSite = new RestrictedTextField(txtForSite);
		validarSite.setLimit(20);
		
		RestrictedTextField validarFone = new RestrictedTextField(txtForFone);
		validarFone.setLimit(30);
		
		RestrictedTextField validarContato = new RestrictedTextField(txtForContato);
		validarContato.setLimit(20);
		
		RestrictedTextField validarEmail = new RestrictedTextField(txtForEmail);
		validarEmail.setLimit(20);
		
		RestrictedTextField validarCep = new RestrictedTextField(txtForCep);
		validarCep.setLimit(20);
		
		RestrictedTextField validarEndereco = new RestrictedTextField(txtForEndereco);
		validarEndereco.setLimit(30);

		RestrictedTextField validarComp = new RestrictedTextField(txtForComp);
		validarComp.setLimit(40);
		
		RestrictedTextField validarBairro = new RestrictedTextField(txtForBairro);
		validarBairro.setLimit(30);
		
		RestrictedTextField validarCidade = new RestrictedTextField(txtForCidade);
		validarCidade.setLimit(20);
		
		
		
		
		
	}// fim do construtor
	
	DAO dao = new DAO();
	private JTextField txtForComp;
	private JComboBox cboForUf;
	
private void pesquisarFornecedorTabela() {
	
String readT = "select idfor as ID,fantasia as fornecedores,fone,contato from fornecedores where fantasia like ?";
try {
	
	Connection con = dao.conectar();
	// Preparar a execução da query
	PreparedStatement pst = con.prepareStatement(readT);
	// Setar o argumento (id)
	// Substituir o ? pelo conteúdo da caixa de texto
	pst.setString(1, txtPesquisarFornecedor.getText() + "%");
	ResultSet rs = pst.executeQuery();
	//usu da biblioteca rs2xml para popular a tabela
	tblFornecedor.setModel(DbUtils.resultSetToTableModel(rs));
	con.close();
	
}catch (Exception e) {
	System.out.println(e);
}
	
}




private void setarCaixasTexto() {
	
	int setar = tblFornecedor.getSelectedRow();
	txtForId.setText(tblFornecedor.getModel().getValueAt(setar, 0).toString());
	txtForFantasia.setText(tblFornecedor.getModel().getValueAt(setar, 1).toString());
	
}

private void limparCamposFornecedor() {
	
	((DefaultTableModel) tblFornecedor.getModel()).setRowCount(0);
}
	

	/**
	 * Metodo responsavel pela pesquisa de usuario
	 */

	private void pesquisarFornecedores() {
		if (txtForId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID do fornecedor");
			txtForId.requestFocus();
		} else {
			// lógica principal
			// query principal ( Instrução SQL)
			String read = "select * from fornecedores where idfor = ?";
			// tratar excessões sempre que lidar com o banco
			try {
				// estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da Query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtForId.getText());
				// Executar a query e exibir o resultado no formulário
				ResultSet rs = pst.executeQuery();
				// Validação (existência de usuário)
				// rs.next() -> existência de usuário
				if(rs.next()) {
					// preencher(setar) os campos do formulário
					txtForId.setText(rs.getString(1));
					txtForCnpj.setText(rs.getString(2));
					txtForIe.setText(rs.getString(3));
					txtForIm.setText(rs.getString(4));
					txtForRazao.setText(rs.getString(5));
					txtForFantasia.setText(rs.getString(6));
					txtForSite.setText(rs.getString(7));
					txtForFone.setText(rs.getString(8));
					txtForContato.setText(rs.getString(9));
					txtForEmail.setText(rs.getString(10));
					txtForCep.setText(rs.getString(11));
					txtForEndereco.setText(rs.getString(12));
					txtForNumero.setText(rs.getString(13));
					txtForComp.setText(rs.getString(14));
					txtForBairro.setText(rs.getString(15));
					txtForCidade.setText(rs.getString(16));
					cboForUf.setSelectedItem(rs.getString(17));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
				// NUNCA esquecer de encerrar a conexão
				
		}
	}
	
	private void adicionarFornecedor() {
		// validação
		if (txtForCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
			txtForCnpj.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome a razão social do fornecedor");
			txtForRazao.requestFocus();
		}else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o nome fantasia do fornecedor");
			txtForFantasia.requestFocus();
		}else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o CEP do fornecedor");
			txtForCep.requestFocus();
		}else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o endereco fornecedor");
			txtForEndereco.requestFocus();
		}else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o bairro do fornecedor");
			txtForBairro.requestFocus();
		}else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Infome o nome fantasia do fornecedor");
			txtForCidade.requestFocus();
		}else if (cboForUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Infome o UF do fornecedor");
			cboForUf.requestFocus();
		} else {
			 
			String create = "insert into fornecedores(cnpj,ie,im,razao,fantasia,site,fone,contato,email,cep,endereco,numero,complemento,bairro,cidade,uf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteúdo das caixas de texto
				pst.setString(1, txtForCnpj.getText());
				pst.setString(2,txtForIe.getText());
				pst.setString(3,txtForIm.getText());
				pst.setString(4, txtForRazao.getText());
				pst.setString(5,txtForFantasia.getText());
				pst.setString(6, txtForSite.getText());
				pst.setString(7,txtForFone.getText());
				pst.setString(8,txtForContato.getText());
				pst.setString(9,txtForEmail.getText());
				pst.setString(10,txtForCep.getText());
				pst.setString(11,txtForEndereco.getText());
				pst.setString(12,txtForNumero.getText());
				pst.setString(13,txtForComp.getText());
				pst.setString(14,txtForBairro.getText());
				pst.setString(15,txtForCidade.getText());
				pst.setString(16,cboForUf.getSelectedItem().toString());
				// Executar a query e inserir o usuário no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
				con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
		}		
	}
	
}
