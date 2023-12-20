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
import java.awt.SystemColor;
public class Dashboard extends JFrame {

	  public Dashboard() {
//		this.setUndecorated(true);
    	this.setBounds(100, 100, 1092, 742);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("Coffe Management System");
		this.setVisible(true);
		init();
		
		
	}
    private JPanel contentPane;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	static AddProductPanel addProductPanel = new AddProductPanel();
	static ShowProductsPanel showProductsPanel = new ShowProductsPanel();
	static UpdateProductPanel updateProductPanel = new UpdateProductPanel();
	static DeleteProductPanel deleteProductPanel = new DeleteProductPanel();
	static addStaffPanel addstaffpanel = new addStaffPanel();
    static showStaffsPanel showstaffspanel = new showStaffsPanel();
    static deleteStaffPanel deletestaffpanel = new deleteStaffPanel();
    static updateStaffPanel updatestaffpanel = new updateStaffPanel();

	
    
	public JLabel homeLabel  = new JLabel("Home");
	public JLabel productsLabel = new JLabel("Products");
	public JLabel staffLabel = new JLabel("Staff");
	public JLabel orderLabel = new JLabel("Order");
	
	//product,staff
	public JButton addProductButton = new JButton("ADD PRODUCT");	
	public JButton showProductsButton = new JButton("SHOW PRODUCTS");
	public JButton deleteProductButton = new JButton("DELETE PRODUCT");
	public JButton updateProductButton = new JButton("UPDATE PRODUCT");
	public  JButton addStaffButton = new JButton("ADD STAFF");
	public  JButton deleteStaffButton = new JButton("DELETE STAFF");
	public  JButton updateStaffButton = new JButton("UPDATE STAFF ");
	public  JButton showStaffsButton = new JButton("SHOW STAFFS");
	private final JPanel decorateYellowHomePanel = new JPanel();
	private final JLabel decorateFunctionStaffLabel = new JLabel("FUNCTION");
	private final JLabel decorateFunctionProductLabel = new JLabel("FUNCTION");
	
	
	public void init(){
		
		
		// khởi tạo listener
		MouseMenuListener mousemenulistener = new MouseMenuListener(this);
        //ProductListener productListener = new ProductListener(this);

		productsLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/drink (1).png")));
		staffLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/management (1).png")));
		orderLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/checklist (1).png")));
		decorateFunctionStaffLabel.setForeground(new Color(219, 171, 33));
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel functionPanel = new JPanel();
		functionPanel.setBackground(new Color(46, 45, 41));
		functionPanel.setBounds(0, 86, 169, 619);
		functionPanel.setLayout(null);
		
		
		
		
		
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
		tabbedPane.setBounds(170, 10, 908, 695);
		JPanel homeTabbedPanel = new JPanel();
		tabbedPane.addTab("Home", null, homeTabbedPanel, null);
		homeTabbedPanel.setLayout(null);
		
		JPanel decorateHomePanel = new JPanel();
		decorateHomePanel.setBackground(new Color(46, 45, 41));
		decorateHomePanel.setForeground(new Color(0, 0, 0));
		decorateHomePanel.setBounds(0, 0, 903, 245);
		homeTabbedPanel.add(decorateHomePanel);
		decorateHomePanel.setLayout(null);
		
		JLabel decorateTitleHomeLabel = new JLabel("COFFEE MANAGEMENT SYSTEM");
		decorateTitleHomeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/shop 100.png")));
		decorateTitleHomeLabel.setForeground(new Color(237, 180, 19));
		decorateTitleHomeLabel.setBounds(139, 58, 661, 107);
		decorateHomePanel.add(decorateTitleHomeLabel);
		decorateTitleHomeLabel.setBackground(Color.WHITE);
		decorateTitleHomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		decorateTitleHomeLabel.setFont(new Font("Neon 80s", Font.BOLD, 26));
		decorateYellowHomePanel.setBackground(new Color(140, 109, 22));
		decorateYellowHomePanel.setBounds(0, 244, 903, 433);
		
		homeTabbedPanel.add(decorateYellowHomePanel);
		decorateYellowHomePanel.setLayout(null);
		JPanel productsTabbedPanel = new JPanel();
		tabbedPane.addTab("Products", null, productsTabbedPanel, null);
		productsTabbedPanel.setLayout(null);
		
		JPanel decorateProductPanel = new JPanel();
		decorateProductPanel.setBackground(new Color(56, 54, 49));
		decorateProductPanel.setBounds(0, 0, 216, 668);
		productsTabbedPanel.add(decorateProductPanel);
		decorateProductPanel.setLayout(null);
								
		addProductButton.setBounds(10, 137, 199, 40);
		decorateProductPanel.add(addProductButton);
		addProductButton.setFocusable(false);
								
		addProductButton.setHorizontalAlignment(SwingConstants.LEFT);
		addProductButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/add 40.png")));
		addProductButton.setFont(new Font("Roboto", Font.BOLD, 13));
		deleteProductButton.setBounds(10, 199, 199, 40);
		decorateProductPanel.add(deleteProductButton);
		deleteProductButton.setFocusable(false);
//		//addProductButton.addActionListener(productListener);
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
				showProductsButton.setBounds(10, 263, 199, 40);
				decorateProductPanel.add(showProductsButton);
				showProductsButton.setFocusable(false);
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
						updateProductButton.setBounds(10, 331, 199, 40);
						decorateProductPanel.add(updateProductButton);
						updateProductButton.setFocusable(false);
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
								decorateFunctionProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
								decorateFunctionProductLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/setting 64.png")));
								decorateFunctionProductLabel.setForeground(new Color(237, 180, 19));
								decorateFunctionProductLabel.setFont(new Font("Nirmala UI", Font.BOLD, 21));
								decorateFunctionProductLabel.setBounds(10, 34, 184, 75);
								
								decorateProductPanel.add(decorateFunctionProductLabel);
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
												
		JPanel staffTabbedPanel = new JPanel();
		tabbedPane.addTab("Staff", null, staffTabbedPanel, null);
		staffTabbedPanel.setLayout(null);
		
		JPanel decorateStaffPanel = new JPanel();
		decorateStaffPanel.setBackground(new Color(56, 54, 49));
		decorateStaffPanel.setBounds(0, 0, 223, 668);
		staffTabbedPanel.add(decorateStaffPanel);
		decorateStaffPanel.setLayout(null);
		addStaffButton.setHorizontalAlignment(SwingConstants.LEFT);
		addStaffButton.setBounds(10, 87, 203, 39);
		decorateStaffPanel.add(addStaffButton);
		
		addStaffButton.setFocusable(false);
		addStaffButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/add 30.png")));
		addStaffButton.setFont(new Font("Roboto", Font.BOLD, 13));
		addStaffButton.setForeground(new Color(0, 0, 0));
		deleteStaffButton.setHorizontalAlignment(SwingConstants.LEFT);
		deleteStaffButton.setBounds(10, 146, 203, 39);
		decorateStaffPanel.add(deleteStaffButton);
		deleteStaffButton.setFocusable(false);
		deleteStaffButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-delete-30 (2).png")));
		deleteStaffButton.setFont(new Font("Roboto", Font.BOLD, 13));
		deleteStaffButton.setForeground(new Color(0, 0, 0));
		updateStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateStaffButton.setHorizontalAlignment(SwingConstants.LEFT);
		updateStaffButton.setBounds(10, 207, 203, 39);
		decorateStaffPanel.add(updateStaffButton);
		updateStaffButton.setFocusable(false);
		updateStaffButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/update 30.png")));
		updateStaffButton.setFont(new Font("Roboto", Font.BOLD, 13));
		updateStaffButton.setForeground(new Color(0, 0, 0));
		showStaffsButton.setHorizontalAlignment(SwingConstants.LEFT);
		showStaffsButton.setBounds(10, 266, 203, 39);
		decorateStaffPanel.add(showStaffsButton);
		showStaffsButton.setFocusable(false);
		showStaffsButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/show 30.png")));
		showStaffsButton.setFont(new Font("Roboto", Font.BOLD, 13));
		showStaffsButton.setForeground(new Color(0, 0, 0));
		decorateFunctionStaffLabel.setHorizontalAlignment(SwingConstants.CENTER);
		decorateFunctionStaffLabel.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		decorateFunctionStaffLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/setting 64.png")));
		decorateFunctionStaffLabel.setBounds(-13, 10, 236, 67);
		
		decorateStaffPanel.add(decorateFunctionStaffLabel);
		
		
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
		
		
				
				
						
		
		
		
		
		
		
		JPanel orderTabbedPanell = new JPanel();
		orderTabbedPanell.setForeground(new Color(102, 51, 204));
		tabbedPane.addTab("Order", null, orderTabbedPanell, null);
		
		
		
		
		
		contentPane.add(functionPanel);
		contentPane.add(titlePanel);
		contentPane.add(tabbedPane);
		contentPane.add(addProductPanel);
		contentPane.add(deleteProductPanel);
		contentPane.add(updateProductPanel);
		contentPane.add(showProductsPanel);
		
		contentPane.add(addstaffpanel);

	
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
		
	    tabbedPane.setVisible(true);
		
	    updatestaffpanel.setVisible(false);
	    deletestaffpanel.setVisible(false);
	    showstaffspanel.setVisible(false);
	    addstaffpanel.setVisible(false);
	    
	    addProductPanel.setVisible(false);
	    deleteProductPanel.setVisible(false);
	    updateProductPanel.setVisible(false);
	    showProductsPanel.setVisible(false);}
	    
	  public void pressProductsLabel() {
		this.tabbedPane.setSelectedIndex(1);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(252, 186, 3));
		this.staffLabel.setBackground(new Color(46,45,41));
		this.orderLabel.setBackground(new Color(46,45,41));
		
		
	    tabbedPane.setVisible(true);
		
		updatestaffpanel.setVisible(false);
	    deletestaffpanel.setVisible(false);
	    showstaffspanel.setVisible(false);
	    addstaffpanel.setVisible(false);
	    
	    addProductPanel.setVisible(false);
	    deleteProductPanel.setVisible(false);
	    updateProductPanel.setVisible(false);
	    showProductsPanel.setVisible(false);}
		
	  public void pressStaffLabel() {
		this.tabbedPane.setSelectedIndex(2);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(46,45,41));
		this.staffLabel.setBackground(new Color(252, 186, 3));
		this.orderLabel.setBackground(new Color(46,45,41));
		
		
	    tabbedPane.setVisible(true);
		
		updatestaffpanel.setVisible(false);
	    deletestaffpanel.setVisible(false);
	    showstaffspanel.setVisible(false);
	    addstaffpanel.setVisible(false);
	    
	    addProductPanel.setVisible(false);
	    deleteProductPanel.setVisible(false);
	    updateProductPanel.setVisible(false);
	    showProductsPanel.setVisible(false);}
		
	public void pressOrderLabel() {
		this.tabbedPane.setSelectedIndex(3);
		this.homeLabel.setBackground(new Color(46,45,41));
		this.productsLabel.setBackground(new Color(46,45,41));
		this.staffLabel.setBackground(new Color(46,45,41));
		this.orderLabel.setBackground(new Color(252, 186, 3));
		
		
	    tabbedPane.setVisible(true);
		
		updatestaffpanel.setVisible(false);
	    deletestaffpanel.setVisible(false);
	    showstaffspanel.setVisible(false);
	    addstaffpanel.setVisible(false);
	    
	    addProductPanel.setVisible(false);
	    deleteProductPanel.setVisible(false);
	    updateProductPanel.setVisible(false);
	    showProductsPanel.setVisible(false);}
		
	
	
	
	
	
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
}
