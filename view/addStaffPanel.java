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
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addStaffPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField staffIdText;
	private JTextField staffNameText;
	private JTextField staffAddressText;
	private JTextField staffPhoneNumberText;

	/**
	 * Create the panel.
	 */
	public addStaffPanel() {
		setLayout(null);
		this.setBounds(170,1,908,704);
		
		JLabel lblAddStaff = new JLabel("ADD STAFF");
		lblAddStaff.setOpaque(true);
		lblAddStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStaff.setForeground(new Color(201, 162, 34));
		lblAddStaff.setFont(new Font("Space Age", Font.BOLD, 18));
		lblAddStaff.setBackground(Color.DARK_GRAY);
		lblAddStaff.setBounds(0, 0, 908, 97);
		
		
		JLabel staffIdLabel = new JLabel("Staff Id");
		staffIdLabel.setForeground(Color.DARK_GRAY);
		staffIdLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffIdLabel.setBounds(138, 158, 130, 34);
		
		
		JLabel staffNameLabel = new JLabel("Staff Name");
		staffNameLabel.setForeground(Color.DARK_GRAY);
		staffNameLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffNameLabel.setBounds(138, 218, 130, 34);
				
		JLabel staffAddressLabel = new JLabel("Staff Address");
		staffAddressLabel.setForeground(Color.DARK_GRAY);
		staffAddressLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffAddressLabel.setBounds(138, 276, 130, 34);
		
		JLabel staffPhoneNumberLabel = new JLabel("Staff Phone Number");
		staffPhoneNumberLabel.setForeground(Color.DARK_GRAY);
		staffPhoneNumberLabel.setFont(new Font("Roboto", Font.BOLD, 13));
		staffPhoneNumberLabel.setBounds(138, 331, 130, 34);
		
		staffIdText = new JTextField();
		staffIdText.setFont(new Font("Roboto", Font.BOLD, 11));
		staffIdText.setForeground(Color.ORANGE);
		staffIdText.setBounds(261, 159, 594, 34);
		
		staffIdText.setColumns(10);
		
		staffNameText = new JTextField();
		staffNameText.setFont(new Font("Roboto", Font.BOLD, 11));
		staffNameText.setForeground(Color.ORANGE);
		staffNameText.setColumns(10);
		staffNameText.setBounds(261, 218, 594, 34);
		
		
		staffAddressText = new JTextField();
		staffAddressText.setFont(new Font("Roboto", Font.BOLD, 11));
		staffAddressText.setForeground(Color.ORANGE);
		staffAddressText.setColumns(10);
		staffAddressText.setBounds(261, 276, 594, 34);
		
		
		staffPhoneNumberText = new JTextField();
		staffPhoneNumberText.setFont(new Font("Roboto", Font.BOLD, 11));
		staffPhoneNumberText.setForeground(Color.ORANGE);
		staffPhoneNumberText.setColumns(10);
		staffPhoneNumberText.setBounds(261, 332, 594, 34);
				
		JButton addButton = new JButton("ADD");
		addButton.setIcon(new ImageIcon(addStaffPanel.class.getResource("/image/add 30.png")));
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "INSERT INTO staff (staffId, staffName, staffAddress, staffPhoneNumber) "
							+ "VALUES (\"" + staffIdText.getText() + "\", \"" + staffNameText.getText() + "\", \"" +
							staffAddressText.getText() + "\", \"" + staffPhoneNumberText.getText() + "\")";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Add staff successfully...");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Invalid add, please re-enter...");
				}
			} 
		});
		addButton.setFont(new Font("Roboto", Font.BOLD, 12));
		addButton.setBounds(397, 404, 141, 34);
		

		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(addStaffPanel.class.getResource("/image/close 26.png")));
		closeButton.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
			    view.Dashboard.tabbedPane.setVisible(true);
				view.Dashboard.addProductPanel.setVisible(false);
				view.Dashboard.deleteProductPanel.setVisible(false);
				view.Dashboard.showProductsPanel.setVisible(false);
				view.Dashboard.updateProductPanel.setVisible(false);
				
				view.Dashboard.deletestaffpanel.setVisible(false);
				view.Dashboard.addstaffpanel.setVisible(false);
				view.Dashboard.showstaffspanel.setVisible(false);
				view.Dashboard.updatestaffpanel.setVisible(false);
				
							}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 12));
		closeButton.setBounds(641, 404, 141, 34);
		
		
		JButton resetButton = new JButton("RESET");
		resetButton.setIcon(new ImageIcon(addStaffPanel.class.getResource("/image/icons8-reset-30 (4).png")));
		resetButton.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				staffIdText.setText(null);
				staffNameText.setText(null);
				staffAddressText.setText(null);
				staffPhoneNumberText.setText(null);
			}
		});
		resetButton.setFont(new Font("Roboto", Font.BOLD, 12));
		resetButton.setBounds(141, 404, 141, 34);
		
		
		
		
		this.add(resetButton);
		this.add(closeButton);
		this.add(addButton);
		this.add(staffPhoneNumberText);
		this.add(staffAddressText);
		this.add(staffNameText);
		this.add(staffIdText);
		this.add(staffPhoneNumberLabel);
		this.add(staffAddressLabel);
		this.add(staffNameLabel);
		this.add(staffIdLabel);
		this.add(lblAddStaff);


		

	}
}
