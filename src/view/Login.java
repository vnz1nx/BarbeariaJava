package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 62,64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(183, 51, 516, 352);
		panel.setBackground(new Color(204,207,208));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 35));
		lblNewLabel.setBounds(199, 40, 118, 35);
		panel.add(lblNewLabel);
		
		senha = new JPasswordField();
		senha.setBounds(126, 164, 252, 35);
		panel.add(senha);
		
		usuario = new JTextField();
		usuario.setBounds(126, 106, 252, 35);
		panel.add(usuario);
		usuario.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(senha.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if (usuario.getText() != null && !usuario.getText().isEmpty() &&
						senha.getText() != null && !senha.getText().isEmpty()) {
					if (criptografia.criptografar().equals("202CB962AC59075B964B07152D234B70")) {
					JOptionPane.showMessageDialog(btnNewButton, "Informações Validas!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Principal principalTela = new Principal();
					principalTela.setLocationRelativeTo(principalTela);
					principalTela.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Informações Invalidas!", "Alerta!", JOptionPane.WARNING_MESSAGE);
				}
			}
			}
		});
		btnNewButton.setBackground(new Color(49, 62, 64));
		btnNewButton.setBounds(157, 229, 201, 53);
		panel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setBounds(127, 91, 61, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("SENHA:");
		lblNewLabel_2.setBounds(127, 152, 61, 14);
		panel.add(lblNewLabel_2);
	}
}
