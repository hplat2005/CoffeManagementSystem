package view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.UpdateProductController;
import dao.ProductDAO;
import database.ConnectDatabase;
import model.Product;

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

	
	public static  JTextField productIdTextField  = new JTextField();
	public static  JTextField productNameTextField  = new JTextField();

	public static JTextField productPriceTextField  = new JTextField();

	public static  JTextField searchProductIdTextField  = new JTextField();
	public JButton closeButton;
	public JButton searchButton;
	public JButton resetButton;
	public JButton updateButton;
	public UpdateProductController updateProductController;

	/**
	 * Create the panel.
	 */
	public UpdateProductPanel() {
		
		updateProductController = new UpdateProductController(this);
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
		
		 updateButton = new JButton("UPDATE");
		updateButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/update 30.png")));
		updateButton.setFont(new Font("Roboto", Font.BOLD, 13));
		updateButton.setBounds(492, 488, 130, 29);
		updateButton.addMouseListener(updateProductController);
		add(updateButton);
		
		closeButton = new JButton("CLOSE");
		closeButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/close 30.png")));
		closeButton.setFont(new Font("Roboto", Font.BOLD, 16));
		closeButton.setBounds(403, 636, 120, 29);
		closeButton.addMouseListener(updateProductController);
		add(closeButton);
		
		searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.setFont(new Font("Roboto", Font.BOLD, 11));
		searchButton.setBounds(685, 126, 109, 39);
		searchButton.addMouseListener(updateProductController);
		add(searchButton);
		
		
		searchProductIdTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				while(true) {
					searchProductIdTextField.setText(null);
					break;
				}
				
			}
		});
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
		
		resetButton = new JButton("RESET");
		resetButton.setIcon(new ImageIcon(UpdateProductPanel.class.getResource("/image/icons8-reset-30 (2).png")));
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		resetButton.setBounds(327, 488, 120, 29);
		resetButton.addMouseListener(updateProductController);
		add(resetButton);

	}
	public void pressSearchButton() {
		Product product = new Product();
		product.setProductId(searchProductIdTextField.getText());
		ProductDAO.getInstance().selectById(product);
		
		productIdTextField.setText(product.getProductId());
		productNameTextField.setText(product.getProductName());
		productPriceTextField.setText(product.getProductPrice());
		
		
	}
	public void pressUpdateButton() {
		Product product = new Product();
		product.setProductId(productIdTextField.getText());
		product.setProductName(productNameTextField.getText());
		product.setProductPrice(productPriceTextField.getName());
		
		
	}
	public void pressResetButton() {
		productIdTextField.setText(null);
		productNameTextField.setText(null);
		productPriceTextField.setText(null);
		searchProductIdTextField.setText(null);
	}
	public void pressCloseButton() {
		view.Dashboard.clickClosebutton();
	}
}
