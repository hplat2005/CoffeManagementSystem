package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConnectDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class login extends JFrame {

	
	private JPanel contentPane = new JPanel();
	private JTextField userNameTextField  = new JTextField();
	private JTextField  passwordTextField = new JTextField();


	
	JFrame frame = new JFrame();
	JButton closeButton = new JButton("CLOSE");
	JLabel lblNewLabel = new JLabel("COFFE MANAGEMENT SYSTEM");
	JButton loginButton = new JButton("LOGIN");
	private JTextField textField;

	public login() {
//				frame.setLocationRelativeTo(null);
//		frame.setUndecorated(true);
		contentPane.add(loginButton);
		contentPane.add(closeButton);
		frame.getContentPane().add(contentPane);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 746, 524);
		init();
	}
		
	private void init(){
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(56, 54, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(237, 180, 19));
		usernameLabel.setBackground(new Color(237, 180, 19));
		usernameLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		usernameLabel.setBounds(117, 97, 111, 52);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(237, 180, 19));
		passwordLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		passwordLabel.setBounds(117, 159, 111, 52);
		
		
		
		userNameTextField.setBounds(238, 108, 364, 35);
		userNameTextField.setColumns(10);
		contentPane.add(userNameTextField);

		passwordTextField.setBounds(238,168, 364,40);
		passwordTextField.setColumns(10);
		contentPane.add(passwordTextField);
		
		
		loginButton.setForeground(new Color(237, 180, 19));
		loginButton.setIcon(new ImageIcon(login.class.getResource("/image/login giff.gif")));
		loginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				
				
				Connection connect = ConnectDatabase.getConnection();
				ArrayList<String> usernameList = new ArrayList<>();
				ArrayList <String> passwordList = new ArrayList<>();
				try {
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM users WHERE userName='" + userNameTextField.getText() +"'"
							+ " && password='" + passwordTextField.getText() + "'";
					ResultSet rs = st.executeQuery(sql);
					
					while(rs.next()) {
				        usernameList.add(rs.getString("userName"));
						passwordList.add(rs.getString("password"));
					}
					for(int i=0; i< usernameList.size(); i++) {
						if(userNameTextField.getText().equals(usernameList.get(i))&&
								passwordTextField.getText().equals(passwordList.get(i))){
							new view.Dashboard();
							frame.setVisible(false);

							break;
						}
					}
					
					
				    } catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null,"UserName does not exist!!!");
					}
			}				
				});
		loginButton.setFont(new Font("Roboto Black", Font.BOLD, 15));
		loginButton.setBounds(289, 259, 152, 38);
		loginButton.setFocusable(false);
				
		
		closeButton.setIcon(new ImageIcon(login.class.getResource("/image/show 30.png")));
		closeButton.setForeground(new Color(237, 180, 19));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 14));
		closeButton.setBounds(289, 353, 152, 35);
		
		
		
		lblNewLabel.setForeground(new Color(237, 180, 19));
		lblNewLabel.setBackground(new Color(140, 109, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Insaniburger", Font.BOLD, 25));
		lblNewLabel.setBounds(53, 10, 669, 79);
	
		contentPane.add(lblNewLabel);
		
		contentPane.add(passwordLabel);
				
		
	}
}
