package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
import java.sql.ResultSet;
import database.ConnectDatabase;
import model.Product;
import model.Staff;
import view.ShowProductsPanel;
import view.AddProductPanel;

public class ProductDAO implements DAOInterface<Product>{
    public static ProductDAO getInstance() {
    	return new ProductDAO();
    }
	@Override
	public int insert(Product t) {
		
		return 0;
	}

	@Override
	public int delete(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Product> selecetAll() {
		try {
			ArrayList<Product> danhsachproduct = new ArrayList<>();
			
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM product";
			ResultSet rs =st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)view.ShowProductsPanel.table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i=0; i<cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			System.out.println("Ban vua thuc hien " + sql);
			
			while(rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String productPrice = rs.getString("productPrice");
				
				Product product = new Product(productId, productName, productPrice);
				danhsachproduct.add(product);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return null;
	}

	@Override
	public Product selectById(Product t) {
//		Product product = null;
//		try {
//			Connection connect = ConnectDatabase.getConnection();
//			Statement st = connect.createStatement();
//			String sql = "SELECT * FROM staff WHERE staffId= \"" + t.getStaffId() + "\"";
//			ResultSet rs= st.executeQuery(sql);
//			
//			System.out.println("ban vua thuc hien" + sql);
//			
//			while(rs.next()) {
//				String staffId = rs.getString("staffId");
//				String staffName = rs.getString("staffName");
//				String staffAddress = rs.getString("staffAddress");
//				String staffPhoneNumber = rs.getString("staffPhoneNumber");
//				
//				 selectStaffById = new Staff(staffId, staffName, staffAddress, staffPhoneNumber);
//				
//				
//				
//			}
//			
//			
//			  //b5 ngắt kết nối:
//			  ConnectDatabase.closeConnection(connect);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return selectStaffById;
		return null;
	}

	@Override
	public ArrayList<Product> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
}

	