package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.ConnectDatabase;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

import java.sql.Statement;
import java.sql.ResultSet;
import database.ConnectDatabase;
import model.Product;
import view.ShowProductsPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class ShowProductsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTable table = new JTable();

	/**
	 * Create the panel.
	 */
	JButton showButton = new JButton("SHOW");
	JButton resetButton = new JButton("RESET");

	public ShowProductsPanel() {
		
		// không cần quan tâm đến phần này -- phần trang trí
		this.setBounds(170,1,908,704);
		setLayout(null);
		JLabel lblShowProducts = new JLabel("SHOW PRODUCTS");
		lblShowProducts.setBounds(0, 1, 869, 89);
		lblShowProducts.setOpaque(true);
		lblShowProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowProducts.setForeground(new Color(201, 162, 34));
		lblShowProducts.setFont(new Font("Space Age", Font.BOLD, 18));
		lblShowProducts.setBackground(Color.DARK_GRAY);
		add(lblShowProducts);
		
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/close 30.png")));
		closeButton.setBounds(709, 491, 127, 29);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.Dashboard.clickClosebutton();
			}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
		add(closeButton);
		
		
		
	    //database
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM product";
			ResultSet rs =st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)view.ShowProductsPanel.table.getModel();
			 
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i=0; i<cols; i++) {
				colName[i] = rsmd.getColumnName(i+1); // cột đc tính từ 1 trở lên
			}
			model.setColumnIdentifiers(colName);
			
		    String productId, productName, productPrice;
		    while(rs.next()) {
		    	productId = rs.getString(1);
		    	productName = rs.getString(2);
		    	productPrice = rs.getString(3);
		    	String[] row = {productId, productName, productPrice};
		    	model.addRow(row);
		    	}
		    ConnectDatabase.closeConnection(connect);
		    st.close();
		    
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 824, 349);
		add(scrollPane);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		
		
		
		resetButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/icons8-reset-30 (2).png")));
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table.setModel(new DefaultTableModel());
			     showButton.setVisible(true);
			}
		});
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		resetButton.setBounds(144, 488, 122, 34);
		add(resetButton);
		showButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/show 30.png")));
		
		
		 
		showButton.setForeground(new Color(0, 0, 0));
		showButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try { 
					showButton.setVisible(false);
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM product";
					ResultSet rs =st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel)view.ShowProductsPanel.table.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] = rsmd.getColumnName(i+1); // cột đc tính từ 1 trở lên
					}
					model.setColumnIdentifiers(colName);
					
					String productId, productName, productPrice;
					while(rs.next()) {
						productId = rs.getString(1);
						productName = rs.getString(2);
						productPrice = rs.getString(3);
						String[] row = {productId, productName, productPrice};
						model.addRow(row);
						}
					ConnectDatabase.closeConnection(connect);
					st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		showButton.setFont(new Font("Roboto", Font.BOLD, 13));
		showButton.setBounds(20, 488, 122, 34);
		add(showButton);

	}
}
