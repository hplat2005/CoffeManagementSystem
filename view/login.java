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
import javax.swing.JSeparator;

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
		usernameLabel.setBounds(93, 126, 111, 52);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(237, 180, 19));
		passwordLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		passwordLabel.setBounds(93, 173, 111, 52);
		
		
		
		userNameTextField.setBounds(205, 130, 429, 35);
		userNameTextField.setColumns(10);
		contentPane.add(userNameTextField);

		passwordTextField.setBounds(205,175, 429,40);
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
						}else {
							JOptionPane.showMessageDialog(null,"UserName does not exist!!!");
						}
					}
					
					
				    } catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null,"UserName does not exist!!!");
					}
			}				
				});
		loginButton.setFont(new Font("Roboto Black", Font.BOLD, 15));
		loginButton.setBounds(282, 285, 152, 38);
		loginButton.setFocusable(false);
				
		
		closeButton.setIcon(new ImageIcon(login.class.getResource("/image/show 30.png")));
		closeButton.setForeground(new Color(237, 180, 19));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 14));
		closeButton.setBounds(303, 333, 111, 29);
		
		
		
		lblNewLabel.setForeground(new Color(237, 180, 19));
		lblNewLabel.setBackground(new Color(140, 109, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Insaniburger", Font.BOLD, 25));
		lblNewLabel.setBounds(36, 10, 669, 79);
	
		contentPane.add(lblNewLabel);
		
		contentPane.add(passwordLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Forget Password?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Relax and try to remember your password=)))");			
				}
		});
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Roboto", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(510, 225, 141, 19);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 0));
		separator.setBounds(10, 75, 722, 2);
		contentPane.add(separator);
				
		
	}
}
