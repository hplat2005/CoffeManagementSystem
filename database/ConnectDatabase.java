package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

// boolean execute(String SQL){throws SQLEXception
// int executeUpdate(String SQL)     // thực hiện các câu lệnh sql như thêm,xóa giá trị trong bảng csdl --> nó trả về số lượng dòng bị thay đổi csdl
// ResultSet executeQuery(Strin SQL);  // thực hiện câu lệnh truy vấn sql, truy cập bảng,hiệnbảng,....

public class ConnectDatabase {
	public static Connection getConnection(){
		Connection connect = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
		String name = "root";
		String password = "051205";
		
		try {
			connect = DriverManager.getConnection(url,name,password);
			java.sql.Statement st = connect.createStatement();
			String sql = "use coffemanagementsystem";
		     st.executeUpdate(sql);
//		     JOptionPane.showMessageDialog(null, "Database Connected");
		} catch (Exception e) {
			
		JOptionPane.showMessageDialog(null, "Database Connection Error" + e);
			
		}
		
		return connect;
	}
	public static void  closeConnection(Connection connect) {
		if(connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
		}
	};
	
}
