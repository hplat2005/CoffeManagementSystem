package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import database.ConnectDatabase;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateStaffPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField searchStaffIdText  = new JTextField();
	private JTextField staffIdText;
	private JTextField staffNameText;
	private JTextField staffAddressText;
	private JTextField staffPhoneNumberText;
    
	
	
	
	/**
	 * Create the panel.
	 */
	public updateStaffPanel() {
		this.setLayout(null);
		this.setBounds(170,1,908,704);
		
		JLabel lblUpdateStaff = new JLabel("UPDATE STAFF");
		lblUpdateStaff.setOpaque(true);
		lblUpdateStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStaff.setForeground(new Color(201, 162, 34));
		lblUpdateStaff.setFont(new Font("Space Age", Font.BOLD, 18));
		lblUpdateStaff.setBackground(Color.DARK_GRAY);
		lblUpdateStaff.setBounds(0, 0, 908, 97);
		add(lblUpdateStaff);
		
		JLabel searchStaffIdLabel = new JLabel("Staff Id");
		searchStaffIdLabel.setForeground(Color.DARK_GRAY);
		searchStaffIdLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		searchStaffIdLabel.setBounds(231, 131, 100, 39);
		add(searchStaffIdLabel);
		
		JLabel staffIdLabel = new JLabel("Staff Id");
		staffIdLabel.setForeground(Color.DARK_GRAY);
		staffIdLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		staffIdLabel.setBounds(147, 252, 141, 39);
		add(staffIdLabel);
		
		JLabel staffNameLabel = new JLabel("Staff Name");
		staffNameLabel.setForeground(Color.DARK_GRAY);
		staffNameLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		staffNameLabel.setBounds(147, 301, 141, 39);
		add(staffNameLabel);
		
		JLabel staffAddressLabel = new JLabel("Staff Address");
		staffAddressLabel.setForeground(Color.DARK_GRAY);
		staffAddressLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		staffAddressLabel.setBounds(147, 355, 141, 39);
		add(staffAddressLabel);
		searchStaffIdText.setForeground(Color.ORANGE);
		
		
		searchStaffIdText.setFont(new Font("Roboto", Font.BOLD, 13));
		searchStaffIdText.setColumns(10);
		searchStaffIdText.setBounds(312, 131, 357, 39);
		add(searchStaffIdText);
		
		staffIdText = new JTextField();
		staffIdText.setForeground(Color.ORANGE);
		staffIdText.setFont(new Font("Roboto", Font.BOLD, 13));
		staffIdText.setColumns(10);
		staffIdText.setBounds(312, 252, 417, 39);
		add(staffIdText);
		
		staffNameText = new JTextField();
		staffNameText.setForeground(Color.ORANGE);
		staffNameText.setFont(new Font("Roboto", Font.BOLD, 13));
		staffNameText.setColumns(10);
		staffNameText.setBounds(312, 301, 417, 39);
		add(staffNameText);
		
		staffAddressText = new JTextField();
		staffAddressText.setForeground(Color.ORANGE);
		staffAddressText.setFont(new Font("Roboto", Font.BOLD, 13));
		staffAddressText.setColumns(10);
		staffAddressText.setBounds(312, 355, 417, 39);
		add(staffAddressText);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(updateStaffPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			   try {
				Connection connect = ConnectDatabase.getConnection();
				   Statement st = connect.createStatement();
				   String sql = "SELECT * FROM staff WHERE staffId= \"" + searchStaffIdText.getText() + "\"";
				   ResultSet rs = st.executeQuery(sql);
				   
				   if(rs.next()) {
					   staffIdText.setText(rs.getString(1));
					   staffNameText.setText(rs.getString(2));
					   staffAddressText.setText(rs.getString(3));
					   staffPhoneNumberText.setText(rs.getString(4));
				   }else{
					   JOptionPane.showMessageDialog(null, "Staff Id not found...");
				   }
				   ConnectDatabase.closeConnection(connect);
				   st.close();
				   			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		searchButton.setFont(new Font("Roboto", Font.BOLD, 11));
		searchButton.setBounds(681, 132, 109, 39);
		add(searchButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton.setIcon(new ImageIcon(updateStaffPanel.class.getResource("/image/icons8-reset-30 (4).png")));
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				searchStaffIdText.setText(null);
				staffIdText.setText(null);
				staffNameText.setText(null);
				staffAddressText.setText(null);
				staffPhoneNumberText.setText(null);
			}
		});
		resetButton.setFont(new Font("Roboto", Font.BOLD, 11));
		resetButton.setBounds(189, 575, 120, 34);
		add(resetButton);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.setIcon(new ImageIcon(updateStaffPanel.class.getResource("/image/update 30.png")));
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "UPDATE staff SET staffId= \"" + staffIdText.getText() + "\", staffName= \"" + staffNameText.getText()
					+ "\", staffAddress= \"" + staffAddressText.getText() + "\", staffPhoneNumber= \"" + staffPhoneNumberText.getText()
					+ "\" WHERE staffId= \"" + searchStaffIdText.getText() + "\"";
					
					JOptionPane.showMessageDialog(null, "Update completed");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		updateButton.setFont(new Font("Roboto", Font.BOLD, 11));
		updateButton.setBounds(376, 575, 130, 34);
		add(updateButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(updateStaffPanel.class.getResource("/image/close 26.png")));
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				view.Dashboard.tabbedPane.setVisible(true);
				view.Dashboard.addProductPanel.setVisible(false);
				view.Dashboard.addstaffpanel.setVisible(false);
				view.Dashboard.deleteProductPanel.setVisible(false);
				view.Dashboard.deletestaffpanel.setVisible(false);
				view.Dashboard.updateProductPanel.setVisible(false);
				view.Dashboard.updatestaffpanel.setVisible(false);
				view.Dashboard.showProductsPanel.setVisible(false);
				view.Dashboard.showstaffspanel.setVisible(false);
			}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 11));
		closeButton.setBounds(577, 575, 130, 34);
		add(closeButton);
		
		JLabel staffPhoneNumberLabel = new JLabel("Staff Phone Number");
		staffPhoneNumberLabel.setForeground(Color.DARK_GRAY);
		staffPhoneNumberLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		staffPhoneNumberLabel.setBounds(147, 404, 141, 39);
		add(staffPhoneNumberLabel);
		
		staffPhoneNumberText = new JTextField();
		staffPhoneNumberText.setForeground(Color.ORANGE);
		staffPhoneNumberText.setFont(new Font("Roboto", Font.BOLD, 13));
		staffPhoneNumberText.setColumns(10);
		staffPhoneNumberText.setBounds(312, 404, 417, 39);
		add(staffPhoneNumberText);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 210, 908, 11);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 504, 908, 11);
		add(separator_1);


	}
}
