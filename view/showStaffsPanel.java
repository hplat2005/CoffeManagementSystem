package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.ConnectDatabase;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class showStaffsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static JTable table = new JTable();
	
	

	/**
	 * Create the panel.
	 */
	public showStaffsPanel() {
		this.setLayout(null);
		this.setBounds(170,1,908,704);
		this.setVisible(false);
		
		JLabel showStaffsLabel = new JLabel("SHOW STAFF");
		showStaffsLabel.setOpaque(true);
		showStaffsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		showStaffsLabel.setForeground(new Color(201, 162, 34));
		showStaffsLabel.setFont(new Font("Space Age", Font.BOLD, 18));
		showStaffsLabel.setBackground(Color.DARK_GRAY);
		showStaffsLabel.setBounds(0, 0, 908, 97);
		add(showStaffsLabel);
		
		JButton showButton = new JButton("SHOW");
		showButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					showButton.setVisible(false);
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM staff";
					ResultSet rs =st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel)view.showStaffsPanel.table.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] = rsmd.getColumnName(i+1); // cột đc tính từ 1 trở lên
					}
					model.setColumnIdentifiers(colName);
					
					String staffId, staffName, staffAddress, staffPhoneNumber;
					while(rs.next()) {
						staffId = rs.getString(1);
						staffName = rs.getString(2);
						staffAddress= rs.getString(3);
						staffPhoneNumber = rs.getString(4);
						String[] row = {staffId, staffName,staffAddress,staffPhoneNumber};
						model.addRow(row);
						}
					ConnectDatabase.closeConnection(connect);
					st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		showButton.setIcon(new ImageIcon(showStaffsPanel.class.getResource("/image/show 30.png")));
		showButton.setForeground(Color.BLACK);
		showButton.setFont(new Font("Roboto", Font.BOLD, 13));
		showButton.setBounds(41, 481, 122, 34);
		add(showButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				view.Dashboard.deleteProductPanel.setVisible(false);
				table.setModel(new DefaultTableModel());
			     showButton.setVisible(true);
			}
		});
		resetButton.setIcon(new ImageIcon(showStaffsPanel.class.getResource("/image/icons8-reset-30 (2).png")));
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		resetButton.setBounds(165, 481, 122, 34);
		add(resetButton);
		
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.addMouseListener(new MouseAdapter() {
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
		closeButton.setIcon(new ImageIcon(showStaffsPanel.class.getResource("/image/icons8-return-30.png")));
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
		closeButton.setBounds(730, 484, 127, 29);
		add(closeButton);
		
		
		
		
		
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM staff";
			ResultSet rs =st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)view.showStaffsPanel.table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i=0; i<cols; i++) {
				colName[i] = rsmd.getColumnName(i+1); // cột đc tính từ 1 trở lên
			}
			model.setColumnIdentifiers(colName);
			
		    String staffId, staffName, staffAddress, staffPhoneNumber;
		    while(rs.next()) {
		    	staffId = rs.getString(1);
		    	staffName = rs.getString(2);
		    	staffAddress = rs.getString(3);
		    	staffPhoneNumber = rs.getString(4);
		    	String[] row = {staffId, staffName, staffAddress, staffPhoneNumber};
		    	model.addRow(row);
		    	}
		   
		    ConnectDatabase.closeConnection(connect);
		    st.close();
		    
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 107, 787, 358);
		add(scrollPane);
		
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBackground(SystemColor.activeCaption);
		backgroundLabel.setBounds(0, 94, 908, 610);
		backgroundLabel.setOpaque(true);
		add(backgroundLabel);
		}
}
