package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblData;
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelUsuario;
	public final JLabel lblUsuario = new JLabel("txtlabel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
			}
		});
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuario1.png")));
		btnUsuarios.setToolTipText("Usu\u00E1rio");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarios = new Usuario();
				usuarios.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/tenis.png")));
		lblNewLabel.setBounds(10, 329, 96, 96);
		contentPane.add(lblNewLabel);
		btnUsuarios.setBounds(27, 22, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(31, 99, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/Fornecedores.png")));
		btnNewButton_2.setToolTipText("Fornecedores");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_2.setBounds(182, 22, 128, 128);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/img/caixa1.png")));
		btnNewButton_3.setToolTipText("Produtos");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_3.setBounds(337, 22, 128, 128);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/img/Clientes.png")));
		btnNewButton_4.setToolTipText("Clientes");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_4.setBounds(497, 22, 128, 128);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pdv pdv = new Pdv();
				pdv.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Principal.class.getResource("/img/PDV.png")));
		btnNewButton_5.setToolTipText("PDV");
		btnNewButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_5.setBounds(27, 171, 128, 128);
		contentPane.add(btnNewButton_5);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario formulario = new Formulario();
				formulario.setVisible(true);
			}
		});
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/Relat\u00F3rio3.png")));
		btnRelatorios.setToolTipText("Relat\u00F3rio");
		btnRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
		btnRelatorios.setBounds(182, 171, 128, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramentas ferramentas = new Ferramentas();
				ferramentas.setVisible(true);
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(Principal.class.getResource("/img/ferramentas1.png")));
		btnNewButton_7.setToolTipText("Ferramentas");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_7.setBounds(337, 171, 128, 128);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajuda ajuda = new Ajuda();
				ajuda.setVisible(true);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon(Principal.class.getResource("/img/Ajuda.png")));
		btnNewButton_8.setToolTipText("Ajuda");
		btnNewButton_8.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_8.setBounds(497, 171, 128, 128);
		contentPane.add(btnNewButton_8);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(Color.GRAY);
		panelUsuario.setBounds(0, 382, 647, 65);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		lblUsuario.setBounds(553, 40, 84, 14);
		panelUsuario.add(lblUsuario);
		
		lblData = new JLabel("New label");
		lblData.setBounds(229, 5, 340, 17);
		lblData.setBackground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelUsuario.add(lblData);
	}
}
