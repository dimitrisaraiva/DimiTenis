package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class Fornecedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

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
		
		textField = new JTextField();
		textField.setBounds(120, 24, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/lupa1.png")));
		lblNewLabel_2.setToolTipText("Buscar");
		lblNewLabel_2.setBounds(215, 18, 32, 32);
		contentPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 113, 65, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(130, 116, 37, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("IE");
		lblNewLabel_4.setBounds(323, 116, 10, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("IM");
		lblNewLabel_5.setBounds(489, 116, 17, 14);
		contentPanel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(505, 113, 146, 20);
		contentPanel.add(textField_5);
		
		JLabel lblNewLabel_7 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_7.setBounds(10, 166, 86, 14);
		contentPanel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(99, 163, 305, 20);
		contentPanel.add(textField_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(335, 113, 135, 20);
		contentPanel.add(textField_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 113, 146, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_8 = new JLabel("Nome Fantasia");
		lblNewLabel_8.setBounds(414, 166, 92, 14);
		contentPanel.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(507, 163, 178, 20);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Site");
		lblNewLabel_9.setBounds(10, 213, 25, 14);
		contentPanel.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(37, 210, 169, 20);
		contentPanel.add(textField_8);
		
		JLabel lblNewLabel_6 = new JLabel("Fone");
		lblNewLabel_6.setBounds(215, 213, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(249, 210, 146, 20);
		contentPanel.add(textField_9);
		
		JLabel lblNewLabel_10 = new JLabel("Contato");
		lblNewLabel_10.setBounds(405, 213, 46, 14);
		contentPanel.add(lblNewLabel_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(450, 210, 201, 20);
		contentPanel.add(textField_10);
		
		JLabel lblNewLabel_11 = new JLabel("E-mail");
		lblNewLabel_11.setBounds(10, 255, 40, 14);
		contentPanel.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(60, 252, 241, 20);
		contentPanel.add(textField_11);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(308, 255, 25, 14);
		contentPanel.add(lblNewLabel_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(343, 252, 209, 20);
		contentPanel.add(textField_12);
		
		JButton btnNewButton = new JButton("Buscar CEP");
		btnNewButton.setBounds(562, 251, 123, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_13 = new JLabel("Endere\u00E7o");
		lblNewLabel_13.setBounds(10, 297, 55, 14);
		contentPanel.add(lblNewLabel_13);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(68, 294, 370, 20);
		contentPanel.add(textField_13);
		
		JLabel lblNewLabel_14 = new JLabel("N\u00FAmero");
		lblNewLabel_14.setBounds(450, 297, 46, 14);
		contentPanel.add(lblNewLabel_14);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(499, 294, 162, 20);
		contentPanel.add(textField_14);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(10, 337, 46, 14);
		contentPanel.add(lblNewLabel_15);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(47, 334, 200, 20);
		contentPanel.add(textField_15);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(257, 337, 46, 14);
		contentPanel.add(lblNewLabel_16);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(296, 334, 256, 20);
		contentPanel.add(textField_16);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(582, 337, 18, 14);
		contentPanel.add(lblNewLabel_17);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(610, 333, 41, 22);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(10, 391, 65, 14);
		contentPanel.add(lblNewLabel_18);
		
		textField_17 = new JTextField();
		textField_17.setBounds(85, 365, 216, 67);
		contentPanel.add(textField_17);
		textField_17.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/adicionar.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setToolTipText("Adicionar");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(434, 368, 64, 64);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Editar.png")));
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.setToolTipText("Editar");
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(505, 368, 64, 64);
		contentPanel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Remover.png")));
		btnNewButton_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2.setToolTipText("Remover");
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(571, 368, 64, 64);
		contentPanel.add(btnNewButton_1_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(399, 119, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}

}
