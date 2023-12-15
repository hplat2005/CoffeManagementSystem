package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(102, 108, 111, 52);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(102, 170, 111, 52);
		contentPane.add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(223, 119, 285, 35);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 182, 285, 35);
		contentPane.add(passwordField);
		
		JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
		showPasswordCheckBox.setBounds(307, 239, 103, 41);
		contentPane.add(showPasswordCheckBox);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		loginButton.setBounds(210, 322, 103, 38);
		contentPane.add(loginButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		closeButton.setBounds(380, 324, 111, 35);
		contentPane.add(closeButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\latru\\eclipse-workspace\\BillingManagerSystem\\v960-ning-05.jpg"));
		lblNewLabel.setBounds(0, 10, 709, 476);
		contentPane.add(lblNewLabel);
	}
}
