package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Ajuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ajuda dialog = new Ajuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ajuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajuda.class.getResource("/img/Ajuda.png")));
		setTitle("Ajuda");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Autor: Dimitri Saraiva");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(128, 24, 263, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Ajuda.class.getResource("/img/mit.png")));
			lblNewLabel_2.setBounds(26, 24, 64, 64);
			contentPanel.add(lblNewLabel_2);
		}
		
		JTextPane txtpnALicenaMit = new JTextPane();
		txtpnALicenaMit.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnALicenaMit.setBackground(Color.LIGHT_GRAY);
		txtpnALicenaMit.setText("A licen\u00E7a MIT, tamb\u00E9m chamada de licen\u00E7a X ou de licen\u00E7a X11, \u00E9 uma licen\u00E7a de programas de computadores, criada pelo Instituto de Tecnologia de Massachusetts. Ela \u00E9 uma licen\u00E7a permissiva utilizada tanto em software livre quanto em software propriet\u00E1rio.");
		txtpnALicenaMit.setBounds(128, 63, 246, 136);
		contentPanel.add(txtpnALicenaMit);
	}
}
