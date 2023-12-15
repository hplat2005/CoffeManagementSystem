package view;

import java.awt.EventQueue;

//import java.net.MalformedURLException;
//import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MouseMenuListener;
import controller.ProductListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTable;

import view.AddProductPanel;
import view.ShowProductsPanel;
import view.DeleteProductPanel;
import view.UpdateProductPanel;
public class Dashboard extends JFrame {

	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// panel ngoàiiiiiii
	static AddProductPanel addProductPanel = new AddProductPanel();
	static ShowProductsPanel showProductsPanel = new ShowProductsPanel();
	static UpdateProductPanel updateProductPanel = new UpdateProductPanel();
	static DeleteProductPanel deleteProductPanel = new DeleteProductPanel();
	
//	 addStaffPanel addstaffpanel = new addStaffPanel();
//     deleteStaffPanel deletestaffpanel = new deleteStaffPanel();
     //static showStaffsPanel  showstaffspanel = new showStaffsPanel();
     static addStaffPanel addstaffpanel = new addStaffPanel();
     static showStaffsPanel showstaffspanel = new showStaffsPanel();
     static deleteStaffPanel deletestaffpanel = new deleteStaffPanel();
     static updateStaffPanel updatestaffpanel = new updateStaffPanel();
//     updateStaffPanel updatestaffpanel = new updateStaffPanel();
	

	/**
	 * Create the frame.
	 */
	
	public JLabel homeLabel  = new JLabel("Home");
	public JLabel productsLabel = new JLabel("Products");
	public JLabel staffLabel = new JLabel("Staff");
	public JLabel orderLabel = new JLabel("Order");
	
	//product
	public JButton addProductButton = new JButton("ADD PRODUCT");	
	public JButton showProductsButton = new JButton("SHOW PRODUCTS");
	public JButton deleteProductButton = new JButton("DELETE PRODUCT");
	public JButton updateProductButton = new JButton("UPDATE PRODUCT");
	private final JButton addStaffButton = new JButton("ADD STAFF");
	private final JButton deleteStaffButton = new JButton("DELETE STAFF");
	private final JButton updateStaffButton = new JButton("UPDATE STAFF ");
	private final JButton showStaffsButton = new JButton("SHOW STAFFS");
	
	public Dashboard() {
		
		
		// khởi tạo listener
		MouseMenuListener mousemenulistener = new MouseMenuListener(this);
//		ProductListener productListener = new ProductListener(this);

		productsLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/drink (1).png")));
		staffLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/management (1).png")));
		orderLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/checklist (1).png")));
		
		
		
		this.setTitle("Coffe Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel functionPanel = new JPanel();
		functionPanel.setBackground(new Color(46, 45, 41));
		functionPanel.setBounds(0, 86, 169, 619);
		functionPanel.setLayout(null);
		
		// tạo khung chứa vùng hiển thị giá trị
		
		
		
		//bản menu - home
		
		homeLabel.setOpaque(true);
		homeLabel.setBackground(new Color(51, 255, 102));
		homeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		homeLabel.setBounds(0, 28, 169, 39);
		functionPanel.add(homeLabel);
		homeLabel.setBackground(new Color(252, 186, 3));
		homeLabel.setOpaque(true);
		homeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/home42.png")));
		homeLabel.setForeground(new Color(249,211,66));
		
		homeLabel.addMouseListener(mousemenulistener);
//		homeLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				tabbedPane.setSelectedIndex(0);
//				homeLabel.setBackground(new Color(252, 186, 3));
//				productsLabel.setBackground(new Color(46,45,41));
//				staffLabel.setBackground(new Color(46,45,41));
//				orderLabel.setBackground(new Color(46,45,41));
//				}
//			
//		});
		
		
		// bản menu - products
		
		productsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productsLabel.setForeground(new Color(249, 211, 66));
		productsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		productsLabel.setBackground(new Color(46,45,41));
		productsLabel.setOpaque(true);
		productsLabel.setBounds(0, 97, 169, 39);
		functionPanel.add(productsLabel);
		
		productsLabel.addMouseListener(mousemenulistener);
//		productsLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				tabbedPane.setSelectedIndex(1);
//				productsLabel.setBackground(new Color(252, 186, 3));
//	            homeLabel.setBackground(new Color(46,45,41));
//				staffLabel.setBackground(new Color(46,45,41));
//				orderLabel.setBackground(new Color(46,45,41));
//				
//			}
//		});
//		
		// bản menu - staff
		
		staffLabel.setHorizontalAlignment(SwingConstants.LEFT);
		staffLabel.setForeground(new Color(249, 211, 66));
		staffLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		staffLabel.setBackground(new Color(46, 45, 41));
		staffLabel.setOpaque(true);
		staffLabel.setBounds(0, 159, 169, 39);
		functionPanel.add(staffLabel);
		staffLabel.addMouseListener(mousemenulistener);
//		staffLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				tabbedPane.setSelectedIndex(2);
//				staffLabel.setBackground(new Color(252, 186, 3));
//				productsLabel.setBackground(new Color(46,45,41));
//	            homeLabel.setBackground(new Color(46,45,41));
//				orderLabel.setBackground(new Color(46,45,41));
//			}
//		});
//		
//		
		//bản menu - order
		
		orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		orderLabel.setForeground(new Color(249, 211, 66));
		orderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		orderLabel.setBackground(new Color(46, 45, 41));
		orderLabel.setOpaque(true);
		orderLabel.setBounds(0, 227, 169, 39);
		functionPanel.add(orderLabel);
		orderLabel.addMouseListener(mousemenulistener);
//		orderLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				tabbedPane.setSelectedIndex(3);
//				orderLabel.setBackground(new Color(252, 186, 3));
//				productsLabel.setBackground(new Color(46,45,41));
//	            homeLabel.setBackground(new Color(46,45,41));
//				staffLabel.setBackground(new Color(46,45,41));
//				
//			}
//		});
//		
		
		// không quan tâm cái này - vùng trang trí tiêu đề
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(46, 45, 41));
		titlePanel.setBounds(0, 1, 169, 85);
		titlePanel.setLayout(null);
		JLabel hplatcoffeLabel = new JLabel("hplat Coffee");
		hplatcoffeLabel.setBounds(0, 0, 169, 85);
		titlePanel.add(hplatcoffeLabel);
		hplatcoffeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-coffe-cup-48.png")));
		hplatcoffeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hplatcoffeLabel.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		hplatcoffeLabel.setForeground(new Color(253,253,251));
		
		
		
		// thêm tab vào tabbedpanel
		tabbedPane.setBounds(170, 1, 908, 704);
		JPanel homeTabbedPanel = new JPanel();
		tabbedPane.addTab("Home", null, homeTabbedPanel, null);
		homeTabbedPanel.setLayout(null);
		
		JLabel homeTabbedLabel = new JLabel("COFFEE MANAGEMENT SYSTEM");
		homeTabbedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeTabbedLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeTabbedLabel.setBounds(166, 128, 480, 253);
		homeTabbedPanel.add(homeTabbedLabel);
		JPanel productsTabbedPanel = new JPanel();
		tabbedPane.addTab("Products", null, productsTabbedPanel, null);
		productsTabbedPanel.setLayout(null);
		
		JPanel staffTabbedPanel = new JPanel();
		tabbedPane.addTab("Staff", null, staffTabbedPanel, null);
		staffTabbedPanel.setLayout(null);
		
		
		
		
		
		
		
		JPanel orderTabbedPanell = new JPanel();
		orderTabbedPanell.setForeground(new Color(102, 51, 204));
		tabbedPane.addTab("Order", null, orderTabbedPanell, null);
		
		
		
		addProductButton.setHorizontalAlignment(SwingConstants.LEFT);
		addProductButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/add 40.png")));
		addProductButton.setFont(new Font("Roboto", Font.BOLD, 13));
		addProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(true);
				deleteProductPanel.setVisible(false);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(false);
				}
		});
		
		
		
		
		// Product pane
		addProductButton.setBounds(62, 111, 199, 51);
		productsTabbedPanel.add(addProductButton);
//		addProductButton.addActionListener(productListener);
		deleteProductButton.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(true);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(false);

			}
		});
		deleteProductButton.setHorizontalAlignment(SwingConstants.LEFT);
		deleteProductButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-delete-30 (2).png")));
		deleteProductButton.setFont(new Font("Roboto", Font.BOLD, 13));
//		deleteProductButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				new DeleteProductPanel().setVisible(true);
//			}
//		});
		
		
		deleteProductButton.setBounds(62, 362, 199, 44);
		productsTabbedPanel.add(deleteProductButton);
//		deleteProductButton.addActionListener(productListener);
		updateProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                tabbedPane.setVisible(false);
                
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(false);
				
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				updateProductPanel.setVisible(true);
				
			}
		});
		updateProductButton.setHorizontalAlignment(SwingConstants.LEFT);
		updateProductButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/update 30.png")));
		updateProductButton.setFont(new Font("Roboto", Font.BOLD, 13));

		updateProductButton.setBounds(62, 192, 199, 51);
		productsTabbedPanel.add(updateProductButton);
//		updateProductButton.addActionListener(productListener);
		showProductsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);

				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(false);
				
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				showProductsPanel.setVisible(true);
				updateProductPanel.setVisible(false);
			}
		});
		showProductsButton.setHorizontalAlignment(SwingConstants.LEFT);
		showProductsButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/show 30.png")));
		showProductsButton.setFont(new Font("Roboto", Font.BOLD, 13));
		
		
		showProductsButton.setBounds(62, 275, 199, 51);
		productsTabbedPanel.add(showProductsButton);
//		showProductsButton.addActionListener(productListener);
		
		
		
		
		

		// set event listener cho vung staff panel
		
		deleteStaffButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(true);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(false);
			}
		});
		
		updateStaffButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(true);
				showstaffspanel.setVisible(false);
			}
		});

		addStaffButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				updatestaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
			    showstaffspanel.setVisible(false);
			    addstaffpanel.setVisible(true);
			    
				
			}
		});
		
		
		showStaffsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tabbedPane.setVisible(false);
				addProductPanel.setVisible(false);
				deleteProductPanel.setVisible(false);
				updateProductPanel.setVisible(false);
				showProductsPanel.setVisible(false);
				
				addstaffpanel.setVisible(false);
				deletestaffpanel.setVisible(false);
				updatestaffpanel.setVisible(false);
				showstaffspanel.setVisible(true);
				
			}
		});
		
		updateStaffButton.setBounds(87, 319, 203, 48);
		showStaffsButton.setBounds(87, 428, 203, 48);
		deleteStaffButton.setBounds(87, 215, 203, 48);
		addStaffButton.setBounds(87, 115, 203, 48);
		
		
		staffTabbedPanel.add(showStaffsButton);
		staffTabbedPanel.add(updateStaffButton);
		staffTabbedPanel.add(addStaffButton);
		staffTabbedPanel.add(deleteStaffButton);
		
		contentPane.add(functionPanel);
		contentPane.add(titlePanel);
		contentPane.add(tabbedPane);
		contentPane.add(addProductPanel);
		contentPane.add(deleteProductPanel);
		contentPane.add(updateProductPanel);
		contentPane.add(showProductsPanel);
		
		contentPane.add(addstaffpanel);
//		getContentPane().add(showstaffspanel);
		//contentPane.add(addstaffpanel);
		contentPane.add(deletestaffpanel);
		contentPane.add(updatestaffpanel);
	    contentPane.add(showstaffspanel);
		
		addProductPanel.setVisible(false);
		deleteProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		addstaffpanel.setVisible(false);
		deletestaffpanel.setVisible(false);
		updatestaffpanel.setVisible(false);
		showstaffspanel.setVisible(false);
		
		
		
		
	}
	// chức năng bấm bảng chức năng tổng
	public void pressHomeLabel() {
		this.tabbedPane.setSelectedIndex(0);
		this.homeLabel.setBackground(new Color(252, 186, 3));
		this.productsLabel.setBackground(new Color(46,45,41));
		this.staffLabel.setBackground(new Color(46,45,41));
		this.orderLabel.setBackground(new Color(46,45,41));
	   
	}
	public void pressProductsLabel() {
		this.tabbedPane.setSelectedIndex(1);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(252, 186, 3));
		this.staffLabel.setBackground(new Color(46,45,41));
		this.orderLabel.setBackground(new Color(46,45,41));
		
	}
	public void pressStaffLabel() {
		this.tabbedPane.setSelectedIndex(2);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(46,45,41));
		this.staffLabel.setBackground(new Color(252, 186, 3));
		this.orderLabel.setBackground(new Color(46,45,41));
		
	}
	public void pressOrderLabel() {
		this.tabbedPane.setSelectedIndex(3);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(46,45,41));
		this.staffLabel.setBackground(new Color(46,45,41));
		this.orderLabel.setBackground(new Color(252, 186, 3));
		
	}
	
	//chức năng bấm bảng product
	public void clickAddProductButton() {
		tabbedPane.setVisible(false);
		addProductPanel.setVisible(true);
		deleteProductPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
		
		
	}
	public void clickDeleteProductButton() {
		tabbedPane.setVisible(false);
		deleteProductPanel.setVisible(true);
		addProductPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
	}
	public void clickShowProductsButton() {
		
		tabbedPane.setVisible(false);
		showProductsPanel.setVisible(true);
		addProductPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		deleteProductPanel.setVisible(false);
	}
	public void clickUpdateProductButton() {
		tabbedPane.setVisible(false);
		updateProductPanel.setVisible(true);
		addProductPanel.setVisible(false);
		deleteProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
	}
	
	
	//product
	public static void clickClosebutton() {
		tabbedPane.setVisible(true);
		addProductPanel.setVisible(false);
		deleteProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		
		addstaffpanel.setVisible(false);
		deletestaffpanel.setVisible(false);
		showstaffspanel.setVisible(false);
		updatestaffpanel.setVisible(false);
		
	}
public static void clickCloseButtonStaff() {
		tabbedPane.setVisible(true);
		addProductPanel.setVisible(false);
		deleteProductPanel.setVisible(false);
		showProductsPanel.setVisible(false);
		updateProductPanel.setVisible(false);
		
		deletestaffpanel.setVisible(false);
		addstaffpanel.setVisible(false);
		updatestaffpanel.setVisible(false);
		showstaffspanel.setVisible(false);
		
		
	}
	
	public static void clickResetbutton() {
		deleteProductPanel.setVisible(false);
		
	}
}
