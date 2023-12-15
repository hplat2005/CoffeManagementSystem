package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.ConnectDatabase;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import view.Dashboard;
import javax.swing.ImageIcon;
public class AddProductPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField productIdTextField;
	public JTextField productNameTextField;
	public JTextField productPriceTextFiled;
    DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public AddProductPanel() {
		
		
		setLayout(null);
		this.setBounds(170,1,908,704);
		
	
		
		JLabel titleLabel = new JLabel("ADD PRODUCT");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Space Age", Font.BOLD, 18));
		titleLabel.setBackground(Color.DARK_GRAY);
		titleLabel.setBounds(0, 0, 908, 97);
		titleLabel.setOpaque(true);
		titleLabel.setForeground(new Color(201, 162, 34));
		add(titleLabel);
		
		JLabel productidlabel = new JLabel("Product Id");
		productidlabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productidlabel.setBounds(164, 232, 141, 39);
		add(productidlabel);
		
		JLabel productnamelabel = new JLabel("Product Name");
		productnamelabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productnamelabel.setBounds(164, 286, 141, 39);
		add(productnamelabel);
		
		JLabel productPriceTextField = new JLabel("Product Price");
		productPriceTextField.setFont(new Font("Roboto", Font.BOLD, 15));
		productPriceTextField.setBounds(164, 335, 141, 39);
		add(productPriceTextField);
		
		productIdTextField = new JTextField();
		productIdTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		productIdTextField.setBounds(328, 232, 417, 39);
		add(productIdTextField);
		productIdTextField.setColumns(10);
		
		productNameTextField = new JTextField();
		productNameTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		productNameTextField.setColumns(10);
		productNameTextField.setBounds(328, 287, 417, 39);
		add(productNameTextField);
		
		productPriceTextFiled = new JTextField();
		productPriceTextFiled.setFont(new Font("Roboto", Font.BOLD, 13));
		productPriceTextFiled.setColumns(10);
		productPriceTextFiled.setBounds(328, 336, 417, 39);
		add(productPriceTextFiled);
		
		
		
		JButton addButton = new JButton("ADD");
		addButton.setIcon(new ImageIcon(AddProductPanel.class.getResource("/image/add 30.png")));
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String productId = productIdTextField.getText();
				String productName = productNameTextField.getText();
				String productPrice = productPriceTextFiled.getText();
				
				try {
					
					Connection connect = ConnectDatabase.getConnection();
					Statement statement = connect.createStatement();
					String sql = "INSERT INTO product (productId, productName, productPrice) VALUES(" + productId + ", \"" + productName + "\", \"" + productPrice + "\")";
					int ketqua =  statement.executeUpdate(sql);
					
					
					
					ConnectDatabase.closeConnection(connect);
					statement.close();
					
	                
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		addButton.setFont(new Font("Roboto", Font.BOLD, 17));
		addButton.setBounds(402, 422, 141, 46);
		add(addButton);
		
		JButton closeAddProductButton = new JButton("CLOSE");
		closeAddProductButton.setIcon(new ImageIcon(AddProductPanel.class.getResource("/image/close 30.png")));
		closeAddProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			  setVisible(false);
			  view.Dashboard.clickClosebutton();
			  
			}
		});
		closeAddProductButton.setFont(new Font("Roboto", Font.BOLD, 12));
		closeAddProductButton.setForeground(new Color(0, 0, 0));
		closeAddProductButton.setBounds(0, 98, 110, 33);
		add(closeAddProductButton);
		
		
		
}
	}
