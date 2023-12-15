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

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateProductPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField productIdTextField  = new JTextField();
	private JTextField productNameTextField  = new JTextField();

	private JTextField productPriceTextField  = new JTextField();

	private JTextField searchProductIdTextField  = new JTextField();

	/**
	 * Create the panel.
	 */
	public UpdateProductPanel() {
		setLayout(null);
		this.setBounds(170,1,908,704);
		
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setOpaque(true);
		lblUpdateProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateProduct.setForeground(new Color(201, 162, 34));
		lblUpdateProduct.setFont(new Font("Space Age", Font.BOLD, 18));
		lblUpdateProduct.setBackground(Color.DARK_GRAY);
		lblUpdateProduct.setBounds(0, 0, 908, 97);
		add(lblUpdateProduct);
		
		JLabel productidlabel = new JLabel("Product Id");
		productidlabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productidlabel.setBounds(180, 261, 141, 39);
		add(productidlabel);
		
		JLabel productnamelabel = new JLabel("Product Name");
		productnamelabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productnamelabel.setBounds(180, 325, 141, 39);
		add(productnamelabel);
		
		JLabel productpricelabel = new JLabel("Product Price");
		productpricelabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productpricelabel.setBounds(180, 387, 141, 39);
		add(productpricelabel);
		productIdTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		
		
		productIdTextField.setColumns(10);
		productIdTextField.setBounds(301, 262, 417, 39);
		add(productIdTextField);
				productNameTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		
				productNameTextField.setColumns(10);
		productNameTextField.setBounds(301, 326, 417, 39);
		add(productNameTextField);
				productPriceTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		
				productPriceTextField.setColumns(10);
		productPriceTextField.setBounds(301, 388, 417, 39);
		add(productPriceTextField);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/update 30.png")));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "UPDATE product SET productId=\"" + productIdTextField.getText() + "\", productName= \"" +
					productNameTextField.getText() + "\", productPrice= \"" + productPriceTextField.getText() 
					+ "\" WHERE (productId=\"" + searchProductIdTextField.getText() + "\")";
					st.executeUpdate(sql);
				    
					JOptionPane.showMessageDialog(null, "Update completed...");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}  
		});
		updateButton.setFont(new Font("Roboto", Font.BOLD, 13));
		updateButton.setBounds(492, 488, 130, 29);
		add(updateButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/close 30.png")));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				view.Dashboard.clickClosebutton();
			}
		});
		closeButton.setFont(new Font("Roboto", Font.BOLD, 16));
		closeButton.setBounds(403, 636, 120, 29);
		add(closeButton);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String productId = searchProductIdTextField.getText();
				try { 
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM product WHERE productId= \"" + productId + "\"";
					ResultSet rs = st.executeQuery(sql);
					if(rs.next()) {
						
						productIdTextField.setText(rs.getString(1));
						productNameTextField.setText(rs.getString(2));
						productPriceTextField.setText(rs.getString(3));
						
						
					}else JOptionPane.showMessageDialog(null,"Product Id not found...");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		searchButton.setFont(new Font("Roboto", Font.BOLD, 11));
		searchButton.setBounds(685, 126, 109, 39);
		add(searchButton);
		searchProductIdTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		
		
		searchProductIdTextField.setBounds(301, 126, 357, 39);
		add(searchProductIdTextField);
		searchProductIdTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Product Id");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setBounds(199, 125, 100, 39);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 179, 908, 12);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 527, 898, 12);
		add(separator_1);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/icons8-reset-30 (2).png")));
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				productIdTextField.setText(null);
				productNameTextField.setText(null);
				productPriceTextField.setText(null);
				searchProductIdTextField.setText(null);
			}
		});
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		resetButton.setBounds(327, 488, 120, 29);
		add(resetButton);

	}
}
