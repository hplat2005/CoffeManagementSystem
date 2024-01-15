package view;

import javax.swing.JPanel; 

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.ConnectDatabase;
import view.Dashboard;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

import java.sql.Statement;
import java.sql.ResultSet;
import controller.ShowProductsController;
import dao.ProductDAO;
import database.ConnectDatabase;
import model.Product;
import view.ShowProductsPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class ShowProductsPanel extends JPanel {

	
	public static JTable table = new JTable();
	public static DefaultTableModel model;
//	public JButton showButton = new JButton("SHOW");
//	public JButton resetButton = new JButton("RESET");
	public JButton closeButton;


	public ShowProductsPanel() {
		ShowProductsController showProductsController= new ShowProductsController(this);
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
		
		 
		closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/close 30.png")));
		closeButton.setBounds(709, 491, 127, 29);
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
		closeButton.addMouseListener(showProductsController);
		add(closeButton);
		
//		resetButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/icons8-reset-30 (2).png")));
//		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
//		resetButton.setBounds(144, 488, 122, 34);
//		resetButton.addMouseListener(showProductsController);
//		add(resetButton);
		
//		showButton.setIcon(new ImageIcon(ShowProductsPanel.class.getResource("/image/show 30.png")));
//		showButton.setForeground(new Color(0, 0, 0));
//		showButton.setFont(new Font("Roboto", Font.BOLD, 13));
//		showButton.setBounds(20, 488, 122, 34);
//		showButton.addMouseListener(showProductsController);
//		add(showButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 824, 349);
		add(scrollPane);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
        
//		ProductDAO.getInstance().selecetAll();
//		showButton.setVisible(false);
	}
	public void pressCloseButton() {
		Dashboard.clickClosebutton();
	}
//	public void pressResetButton() {
//		table.setModel(new DefaultTableModel());
//		ProductDAO.getInstance().selecetAll();

//	     showButton.setVisible(true);
//	}
//	public void pressShowButton() {
//		ProductDAO.getInstance().selecetAll();
//	}
	public void clickRowColumn() {
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		table.getValueAt(row, column);
		 Object value = table.getValueAt(row, column);
		 table.setValueAt(value,row, column);
	}
	
	public static void pressShowProductsButtonInHome() {
		table.setModel(new DefaultTableModel());
		ProductDAO.getInstance().selecetAll();
	}
}
