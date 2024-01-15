package view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.DeleteProductController;
import database.ConnectDatabase;
import model.Product;
import dao.ProductDAO;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

import javax.swing.ImageIcon;

public class DeleteProductPanel extends JPanel {


	public static JTextField searchProductIdTextField;
	public static JTextField productNameTextField;
	public static JTextField productPriceTextField;
	public static JTextField productIdTextField;
	private JLabel productidlabel;
	private JLabel productnamelabel;
	private JLabel productpricelabel;
	public JButton deleteButton;
	public JButton resetButton;
    public JButton searchButton;
    public JButton closeButton;

	private JLabel productidlabel_1;

		public DeleteProductPanel() {
		setForeground(Color.DARK_GRAY);
		setLayout(null);
		this.setBounds(170,1,908,704);
		
		DeleteProductController deleteProductController = new DeleteProductController(this);
		
		JLabel labelDeleteProduct = new JLabel("DELETE PRODUCT");
		labelDeleteProduct.setOpaque(true);
		labelDeleteProduct.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeleteProduct.setForeground(new Color(201, 162, 34));
		labelDeleteProduct.setFont(new Font("Space Age", Font.BOLD, 18));
		labelDeleteProduct.setBackground(Color.DARK_GRAY);
		labelDeleteProduct.setBounds(0, 10, 908, 97);
		add(labelDeleteProduct);
		
		searchProductIdTextField = new JTextField();
		searchProductIdTextField.setForeground(new Color(255, 215, 0));
		searchProductIdTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		
		searchProductIdTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				searchProductIdTextField.setText(null);
			}
		});
		searchProductIdTextField.setColumns(10);
		searchProductIdTextField.setBounds(280, 133, 272, 39);
		add(searchProductIdTextField);
		
		productNameTextField = new JTextField();
		productNameTextField.setForeground(new Color(255, 215, 0));
		productNameTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		productNameTextField.setColumns(10);
		productNameTextField.setBounds(280, 344, 417, 39);
		add(productNameTextField);
		
		productPriceTextField = new JTextField();
		productPriceTextField.setForeground(new Color(255, 215, 0));
		productPriceTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		productPriceTextField.setColumns(10);
		productPriceTextField.setBounds(280, 393, 417, 39);
		add(productPriceTextField);
		
		productidlabel = new JLabel("Product Id");
		productidlabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productidlabel.setBounds(171, 132, 79, 39);
		add(productidlabel);
		
		productnamelabel = new JLabel("Product Name");
		productnamelabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productnamelabel.setBounds(171, 343, 109, 39);
		add(productnamelabel);
		
		productpricelabel = new JLabel("Product Price");
		productpricelabel.setFont(new Font("Roboto", Font.BOLD, 15));
		productpricelabel.setBounds(171, 393, 103, 39);
		add(productpricelabel);
		
		resetButton = new JButton("RESET");
		resetButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-reset-30 (4).png")));
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		resetButton.setBounds(230, 506, 134, 44);
		resetButton.addMouseListener(deleteProductController);
		add(resetButton);
		
		
		deleteButton = new JButton("DELETE");
		deleteButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-delete-30 (2).png")));
		deleteButton.setFont(new Font("Roboto", Font.BOLD, 13));
		deleteButton.setBounds(405, 506, 134, 44);
		deleteButton.addMouseListener(deleteProductController);
		add(deleteButton);
		
		
		
		
		
		searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.setFont(new Font("Roboto", Font.BOLD, 11));
		searchButton.setBounds(568, 133, 128, 39);
		searchButton.addMouseListener(deleteProductController);
		add(searchButton);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 189, 908, 8);
		add(separator_1);
		
		productidlabel_1 = new JLabel("Product Id");
		productidlabel_1.setFont(new Font("Roboto", Font.BOLD, 15));
		productidlabel_1.setBounds(171, 295, 96, 39);
		add(productidlabel_1);
		
		productIdTextField = new JTextField();
		productIdTextField.setForeground(new Color(255, 215, 0));
		productIdTextField.setFont(new Font("Roboto", Font.BOLD, 13));
		productIdTextField.setColumns(10);
		productIdTextField.setBounds(280, 295, 417, 39);
		add(productIdTextField);
		
		closeButton = new JButton("CLOSE");
		closeButton.setVerticalAlignment(SwingConstants.BOTTOM);
		closeButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-return-30.png")));
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
		closeButton.setBounds(587, 508, 128, 39);
		closeButton.addMouseListener(deleteProductController);
		add(closeButton);


	}
	public void pressSearchButton() {
		Product product = new Product();
		product.setProductId(searchProductIdTextField.getText());
		ProductDAO.getInstance().selectById(product);
		
		productIdTextField.setText(product.getProductId());
		productNameTextField.setText(product.getProductName());
		productPriceTextField.setText(product.getProductPrice());
	}
	public void pressDeleteButton() {
		Product product = new Product();
		product.setProductId(productIdTextField.getText());
		ProductDAO.getInstance().delete(product);
		
		searchProductIdTextField.setText(null);
		productIdTextField.setText(null);
		productNameTextField.setText(null);
		productPriceTextField.setText(null);
		
	}
	public void pressCloseButton() {
		view.Dashboard.clickClosebutton();
	}
	public void pressResetButton() {
		searchProductIdTextField.setText(null);
		productIdTextField.setText(null);
		productNameTextField.setText(null);
		productPriceTextField.setText(null);
	}
}
