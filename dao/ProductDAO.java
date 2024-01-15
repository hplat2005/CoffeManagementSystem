package dao;

import java.sql.Connection; 

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Statement;
import java.sql.ResultSet;
import database.ConnectDatabase;
import model.Product;
import model.Staff;
import view.ShowProductsPanel;
import view.AddProductPanel;
import view.DeleteProductPanel;
import view.UpdateProductPanel;
public class ProductDAO implements DAOInterface<Product>{
	
    public static ProductDAO getInstance() {
    	return new ProductDAO();
    }
	@Override
	public int insert(Product product) {
		try {
			
			Connection connect = ConnectDatabase.getConnection();
			Statement statement = connect.createStatement();
			String sql = "INSERT INTO product (productId, productName, productPrice) VALUES("  
			+ product.getProductId() + ", \"" +  product.getProductName() + "\", \"" + product.getProductPrice() + "\")";
			int ketqua =  statement.executeUpdate(sql);
			
			
			
			ConnectDatabase.closeConnection(connect);
			statement.close();
			
            JOptionPane.showMessageDialog(null, "Add Product Successfully");
		} catch (SQLException e1) {
			
			JOptionPane.showMessageDialog(null,"Product Id Already Exists ");
		}
		return 0;
		
	}
		
		

	@Override
	public int delete(Product product) {
		int a = JOptionPane.showConfirmDialog(null,"Do you want to DELETE","SELECT", JOptionPane.YES_NO_OPTION);
        if(a==0) {
       	 try {
				Connection connect = ConnectDatabase.getConnection();
				 Statement st = connect.createStatement();
				 String sql = "DELETE FROM product WHERE productId= \"" + product.getProductId() + "\""; 
				 st.executeUpdate(sql);
				
		
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else JOptionPane.showMessageDialog(null, "Ban da huy");
		
		return 0;
	}

	@Override
	public int update(Product product) {
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "UPDATE product SET productId=\"" + product.getProductId()+ "\", productName= \"" +
			product.getProductName() + "\", productPrice= \"" + product.getProductPrice()
			+ "\" WHERE (productId=\"" + DeleteProductPanel.searchProductIdTextField.getText() + "\")";
			st.executeUpdate(sql);
		    
			JOptionPane.showMessageDialog(null, "Update completed...");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		
		}
	return 0;
	}

	@Override
	public ArrayList<Product> selecetAll() {
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM product";
			ResultSet rs =st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			ShowProductsPanel.model = (DefaultTableModel)view.ShowProductsPanel.table.getModel();
			 
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i=0; i<cols; i++) { 
				colName[i] = rsmd.getColumnName(i+1); // cột đc tính từ 1 trở lên
			}
			ShowProductsPanel.model.setColumnIdentifiers(colName);
			
		    String productId, productName, productPrice;
		    while(rs.next()) {
		    	productId = rs.getString(1);
		    	productName = rs.getString(2);
		    	productPrice = rs.getString(3);
		    	String[] row = {productId, productName, productPrice};
		    	ShowProductsPanel.model.addRow(row);
		    	}
		    ConnectDatabase.closeConnection(connect);
		    st.close();
		    
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	    
	    
		return null;
	}



	@Override
	public ArrayList<Product> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Product selectById(Product product) {
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM product WHERE productId= \"" + product.getProductId() + "\"";
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getString(3));

			}else JOptionPane.showMessageDialog(null, "product Id not found");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,e2);
		}
	
		return null;
	}
}

	