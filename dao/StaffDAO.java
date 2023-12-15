package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.ConnectDatabase;
import model.Staff;


public class StaffDAO implements DAOInterface <Staff> {
	public  static StaffDAO getInstance(){
		return new StaffDAO(); 
	}

	
	@Override
	public ArrayList selectByCondition(String condition) {
		ArrayList<Staff> ketQuaArr = new ArrayList<>();
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM staff WHERE " + condition;
			ResultSet rs= st.executeQuery(sql);
			
			System.out.println("ban vua thuc hien" + sql);
			
			while(rs.next()) {
				String staffId = rs.getString("staffId");
				String staffName = rs.getString("staffName");
				String staffAddress = rs.getString("staffAddress");
				String staffPhoneNumber = rs.getString("staffPhoneNumber");
				
				Staff staff = new Staff(staffId, staffName, staffAddress, staffPhoneNumber);
				
				ketQuaArr.add(staff);
				
			}
			
			
			  //b5 ngắt kết nối:
			  ConnectDatabase.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
		return null;
	}

	@Override
	public int insert(Staff t) {
		
	 
	  try {
		// kết nối với database
		   Connection connect =  ConnectDatabase.getConnection();
		  //tạo đối tương staement
		Statement st = connect.createStatement();
		//tạo câu lệnh
		  String sql = "INSERT INTO staff(staffId,staffName, staffAddress, staffPhoneNumber) "
		  		+ " VALUES (" + "\""+  t.getStaffId() + "\",\"" + t.getStaffName() + "\",\" " + t.getStaffAddress() + "\",\" " + t.getStaffPhoneNumber() + "\")";
		  
		  
		  
		  // thực thi câu lệnh , insert là làm thay đổi database --> dùng hàm executeUpdate ( nó sẽ trả về số dữ liệu bị thay đổi trong bảng csdl)
		  int ketqua = st.executeUpdate(sql);
		  
		  //b4 xử lý kết quả 
		  System.out.println("ban da thuc thi " + sql);
		  System.out.println("So dong trong csdl bị thay đổi: " + ketqua);
		 
		  //b5 ngắt kết nối:
		  ConnectDatabase.closeConnection(connect);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		return 0;
	}

	@Override
	public int delete(Staff t) {
		try {
			// kết nối với database
			   Connection connect =  ConnectDatabase.getConnection();
			  //tạo đối tương staement
			Statement st = connect.createStatement();
			//tạo câu lệnh
			  String sql = "DELETE from staff WHERE staffId= \"" + t.getStaffId() + "\"";
			  
			  
			  
			  // thực thi câu lệnh , insert là làm thay đổi database --> dùng hàm executeUpdate ( nó sẽ trả về số dữ liệu bị thay đổi trong bảng csdl)
			  int ketqua = st.executeUpdate(sql);
			  
			  //b4 xử lý kết quả 
			  System.out.println("ban da thuc thi " + sql);
			  System.out.println("So dong trong csdl bị thay đổi: " + ketqua);
			 
			  //b5 ngắt kết nối:
			  ConnectDatabase.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			return 0;
	}

	@Override // update là chỉnh sửa lại thông tin đã có trong csdl
	public int update(Staff t) {
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "UPDATE staff " + "SET " + "staffName= \"" + t.getStaffName() + "\", staffAddress= \"" + t.getStaffAddress() + "\", staffPhoneNumber= \"" + t.getStaffPhoneNumber() 
			+ "\" WHERE staffId =" + t.getStaffId();
			
			int ketqua =st.executeUpdate(sql);   
			System.out.println("ban da thuc thi " + sql);
			  System.out.println("So dong trong csdl bị thay đổi: " + ketqua);
			 
			  //b5 ngắt kết nối:
			  ConnectDatabase.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Staff selectById(Staff t) {
		Staff selectStaffById = null;
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM staff WHERE staffId= \"" + t.getStaffId() + "\"";
			ResultSet rs= st.executeQuery(sql);
			
			System.out.println("ban vua thuc hien" + sql);
			
			while(rs.next()) {
				String staffId = rs.getString("staffId");
				String staffName = rs.getString("staffName");
				String staffAddress = rs.getString("staffAddress");
				String staffPhoneNumber = rs.getString("staffPhoneNumber");
				
				 selectStaffById = new Staff(staffId, staffName, staffAddress, staffPhoneNumber);
				
				
				
			}
			
			
			  //b5 ngắt kết nối:
			  ConnectDatabase.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return selectStaffById;
	}

	@Override
	public ArrayList<Staff> selecetAll() {
		ArrayList<Staff> ketQuaArr = new ArrayList<>();
		try {
			Connection connect = ConnectDatabase.getConnection();
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM staff";
			ResultSet rs= st.executeQuery(sql);
			
			System.out.println("ban vua thuc hien" + sql);
			
			while(rs.next()) {
				String staffId = rs.getString("staffId");
				String staffName = rs.getString("staffName");
				String staffAddress = rs.getString("staffAddress");
				String staffPhoneNumber = rs.getString("staffPhoneNumber");
				
				Staff staff = new Staff(staffId, staffName, staffAddress, staffPhoneNumber);
				
				ketQuaArr.add(staff);
				
			}
			
			
			  //b5 ngắt kết nối:
			  ConnectDatabase.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQuaArr;
	}

}
