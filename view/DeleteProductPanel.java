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

import database.ConnectDatabase;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class DeleteProductPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField searchProductIdTextField;
	public JTextField productNameTextField;
	public JTextField productPriceTextField;
	private JLabel productidlabel;
	private JLabel productnamelabel;
	private JLabel productpricelabel;
	private JButton deleteButton;
    private JButton resetButton;

	/**
	 * Create the panel.
	 */
	
	
	private JLabel productidlabel_1;
	private JTextField productIdTextField;
	private JButton closeButton;
	public DeleteProductPanel() {
		setForeground(Color.DARK_GRAY);
		
		setLayout(null);
		this.setBounds(170,1,908,704);
		
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
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				searchProductIdTextField.setText(null);
				productIdTextField.setText(null);
				productNameTextField.setText(null);
				productPriceTextField.setText(null);
			}
		});
		resetButton.setFont(new Font("Roboto", Font.BOLD, 13));
		
		
		deleteButton = new JButton("DELETE");
		deleteButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-delete-30 (2).png")));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 String productId = productIdTextField.getText();
                 int a = JOptionPane.showConfirmDialog(null,"Do you want to DELETE","SELECT", JOptionPane.YES_NO_OPTION);
                 if(a==0) {
                	 try {
						Connection connect = ConnectDatabase.getConnection();
						 Statement st = connect.createStatement();
						 String sql = "DELETE FROM product WHERE productId= \"" + productId + "\""; 
						 st.executeUpdate(sql);
						 
						 
//						 setVisible(false);
//						 new DeleteProductPanel().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
     
                 }
			}
		});
		
		deleteButton.setFont(new Font("Roboto", Font.BOLD, 13));
		deleteButton.setBounds(405, 506, 134, 44);
		add(deleteButton);
		resetButton.setBounds(230, 506, 134, 44);
		add(resetButton);
		
		
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-search-30.png")));
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Connection connect = ConnectDatabase.getConnection();
					Statement st = connect.createStatement();
					String sql = "SELECT * FROM product WHERE productId= \"" + searchProductIdTextField.getText() + "\"";
					ResultSet rs = st.executeQuery(sql);
					
					if(rs.next()) {
						productIdTextField.setText(rs.getString(1));
						productNameTextField.setText(rs.getString(2));
						productPriceTextField.setText(rs.getString(3));
						
						
					}else JOptionPane.showMessageDialog(null, "product Id not found");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		searchButton.setFont(new Font("Roboto", Font.BOLD, 11));
		searchButton.setBounds(568, 133, 128, 39);
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
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				view.Dashboard.clickClosebutton();
			}
		});
		closeButton.setIcon(new ImageIcon(DeleteProductPanel.class.getResource("/image/icons8-return-30.png")));
		closeButton.setFont(new Font("Roboto", Font.BOLD, 13));
		closeButton.setBounds(587, 508, 128, 39);
		add(closeButton);


	}
}
