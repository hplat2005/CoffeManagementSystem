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

public class deleteStaffPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField staffIdText;
	private JTextField staffNameText;
	private JTextField staffAddressText;
	private JTextField staffPhoneNumberText;
	private JTextField searchStaffIdText;

	/**
	 * Create the panel.
	 */
	public deleteStaffPanel() {
		this.setLayout(null);
		this.setBounds(170,1,908,704);
		
		JLabel labelDeleteStaff = new JLabel("DELETE STAFF");
		labelDeleteStaff.setOpaque(true);
		labelDeleteStaff.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteStaff.setForeground(new Color(201, 162, 34));
		labelDeleteStaff.setFont(new Font("Space Age", Font.BOLD, 18));
		labelDeleteStaff.setBackground(Color.DARK_GRAY);
		labelDeleteStaff.setBounds(0, 0, 908, 97);
		add(labelDeleteStaff);
		
		JLabel staffIdLabel = new JLabel("Staff Id");
		staffIdLabel.setForeground(Color.DARK_GRAY);
		staffIdLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffIdLabel.setBounds(100, 231, 130, 34);
		add(staffIdLabel);
		
		JLabel staffNameLabel = new JLabel("Staff Name");
		staffNameLabel.setForeground(Color.DARK_GRAY);
		staffNameLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffNameLabel.setBounds(100, 291, 130, 34);
		add(staffNameLabel);
		
		JLabel staffAddressLabel = new JLabel("Staff Address");
		staffAddressLabel.setForeground(Color.DARK_GRAY);
		staffAddressLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffAddressLabel.setBounds(100, 349, 130, 34);
		add(staffAddressLabel);
		
		JLabel staffPhoneNumberLabel = new JLabel("Staff Phone Number");
		staffPhoneNumberLabel.setForeground(Color.DARK_GRAY);
		staffPhoneNumberLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffPhoneNumberLabel.setBounds(100, 404, 130, 34);
		add(staffPhoneNumberLabel);
		
		staffIdText = new JTextField();
		staffIdText.setForeground(Color.ORANGE);
		staffIdText.setFont(new Font("Roboto", Font.BOLD, 12));
		staffIdText.setColumns(10);
		staffIdText.setBounds(240, 231, 594, 34);
		add(staffIdText);
		
		staffNameText = new JTextField();
		staffNameText.setForeground(Color.ORANGE);
		staffNameText.setFont(new Font("Roboto", Font.BOLD, 12));
		staffNameText.setColumns(10);
		staffNameText.setBounds(240, 290, 594, 34);
		add(staffNameText);
		
		staffAddressText = new JTextField();
		staffAddressText.setForeground(Color.ORANGE);
		staffAddressText.setFont(new Font("Roboto", Font.BOLD, 12));
		staffAddressText.setColumns(10);
		staffAddressText.setBounds(240, 348, 594, 34);
		add(staffAddressText);
		
		staffPhoneNumberText = new JTextField();
		staffPhoneNumberText.setForeground(Color.ORANGE);
		staffPhoneNumberText.setFont(new Font("Roboto", Font.BOLD, 12));
		staffPhoneNumberText.setColumns(10);
		staffPhoneNumberText.setBounds(240, 404, 594, 34);
		add(staffPhoneNumberText);
		
		JLabel searchStaffIdLabel = new JLabel("Staff Id");
		searchStaffIdLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		searchStaffIdLabel.setBounds(171, 124, 130, 34);
		add(searchStaffIdLabel);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setIcon(new ImageIcon(deleteStaffPanel.class.getResource("/image/icons8-delete-30 (2).png")));
		deleteButton.setFont(new Font("Roboto", Font.BOLD, 13));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "DELETE FROM staff WHERE staffId= \"" + searchStaffIdText.getText();
					st.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteButton.setBounds(387, 539, 130, 34);
		add(deleteButton);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(deleteStaffPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.setFont(new Font("Roboto", Font.BOLD, 13));
		searchButton.addMouseListener(new MouseAdapter() {
			 @Override
			public void mousePressed(MouseEvent e) {
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM staff WHERE staffId = \"" + searchStaffIdText.getText() +  "\"";
					ResultSet rs = st.executeQuery(sql);
					
					if(rs.next()) {
						staffIdText.setText(rs.getString(1));
						staffNameText.setText(rs.getString(2));
						staffAddressText.setText(rs.getString(3));
						staffPhoneNumberText.setText(rs.getString(4));
						
						}else {
							JOptionPane.showMessageDialog(null,"Staff Id not found...");
							
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		searchButton.setBounds(703, 125, 130, 34);
		add(searchButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(deleteStaffPanel.class.getResource("/image/close 26.png")));
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
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
		closeButton.setBounds(649, 539, 130, 34);
		add(closeButton);
		
		searchStaffIdText = new JTextField();
		searchStaffIdText.setForeground(Color.ORANGE);
		searchStaffIdText.setFont(new Font("Roboto", Font.BOLD, 12));
		searchStaffIdText.setColumns(10);
		searchStaffIdText.setBounds(240, 126, 441, 34);
		add(searchStaffIdText);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setIcon(new ImageIcon(deleteStaffPanel.class.getResource("/image/icons8-reset-30 (4).png")));
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
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
		resetButton.setBounds(115, 539, 130, 34);
		add(resetButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 182, 908, 2);
		add(separator);
		

	}
}
