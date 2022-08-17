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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 24, 86, 20);
		contentPanel_1.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Clientes.class.getResource("/img/lupa1.png")));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setToolTipText("Buscar");
		lblNewLabel_2.setBounds(215, 18, 32, 32);
		contentPanel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(60, 113, 65, 20);
		contentPanel_1.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(130, 116, 37, 14);
		contentPanel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NOME");
		lblNewLabel_4.setBounds(323, 116, 40, 14);
		contentPanel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NASCIMENTO");
		lblNewLabel_5.setBounds(567, 116, 86, 14);
		contentPanel_1.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(654, 113, 135, 20);
		contentPanel_1.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(371, 113, 186, 20);
		contentPanel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(167, 113, 146, 20);
		contentPanel_1.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fone");
		lblNewLabel_6.setBounds(10, 166, 46, 14);
		contentPanel_1.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(45, 163, 146, 20);
		contentPanel_1.add(textField_8);
		
		JLabel lblNewLabel_11 = new JLabel("E-mail");
		lblNewLabel_11.setBounds(215, 166, 40, 14);
		contentPanel_1.add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(257, 163, 241, 20);
		contentPanel_1.add(textField_10);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(516, 166, 25, 14);
		contentPanel_1.add(lblNewLabel_12);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(544, 163, 209, 20);
		contentPanel_1.add(textField_11);
		
		JButton btnNewButton = new JButton("Buscar CEP");
		btnNewButton.setBounds(585, 194, 123, 23);
		contentPanel_1.add(btnNewButton);
		
		JLabel lblNewLabel_13 = new JLabel("Endere\u00E7o");
		lblNewLabel_13.setBounds(10, 198, 55, 14);
		contentPanel_1.add(lblNewLabel_13);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(68, 194, 370, 20);
		contentPanel_1.add(textField_12);
		
		JLabel lblNewLabel_14 = new JLabel("N\u00FAmero");
		lblNewLabel_14.setBounds(10, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_14);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(60, 230, 162, 20);
		contentPanel_1.add(textField_13);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(236, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_15);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(272, 230, 200, 20);
		contentPanel_1.add(textField_14);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(482, 233, 46, 14);
		contentPanel_1.add(lblNewLabel_16);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(522, 230, 256, 20);
		contentPanel_1.add(textField_15);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(10, 271, 18, 14);
		contentPanel_1.add(lblNewLabel_17);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(45, 267, 65, 22);
		contentPanel_1.add(comboBox);
		
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "SIM", "N\u00C3O"}));
		comboBox_1.setBounds(194, 267, 71, 22);
		contentPanel_1.add(comboBox_1);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setIcon(new ImageIcon(Clientes.class.getResource("/img/adicionar.png")));
		btnNewButton_1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_3.setToolTipText("Adicionar");
		btnNewButton_1_3.setContentAreaFilled(false);
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setBounds(533, 307, 64, 64);
		contentPanel_1.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.setIcon(new ImageIcon(Clientes.class.getResource("/img/Editar.png")));
		btnNewButton_1_1_1.setToolTipText("Editar");
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBounds(628, 307, 64, 64);
		contentPanel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("");
		btnNewButton_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2_1.setIcon(new ImageIcon(Clientes.class.getResource("/img/Remover.png")));
		btnNewButton_1_2_1.setToolTipText("Remover");
		btnNewButton_1_2_1.setContentAreaFilled(false);
		btnNewButton_1_2_1.setBorderPainted(false);
		btnNewButton_1_2_1.setBounds(714, 307, 64, 64);
		contentPanel_1.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setToolTipText("Buscar");
		lblNewLabel_2_1.setBounds(216, 18, 32, 32);
		contentPanel_1.add(lblNewLabel_2_1);
	}
}
