package view;
import database.ConnectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;



public class taotable {
	 	
	 	DefaultTableModel model = new DefaultTableModel();
	 	JTable table = new JTable(model);
		public taotable() {
			taoDuLieu();
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.add(table);
			frame.add(scrollPane);
			frame.pack();
			frame.setVisible(true);
			

	}
public void taoDuLieu() {
	Connection connect = ConnectDatabase.getConnection();
	try {
		Statement st = connect.createStatement();
		String sql = "select * from staff";
		ResultSet rs = st.executeQuery(sql);
		
		ResultSetMetaData metadata = rs.getMetaData();
		int column = metadata.getColumnCount();
		//khoi tao column
		for(int i=1; i <= column; i++ ) {
			model.addColumn(column);
		};
		//khoi tao du lieu
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			String phoneNumber = rs.getString(4);
			
			Object[] row = new Object[column];
			for(int i=1; i<=column; i++) {
				row[i-1] = rs.getObject(1);
				
			}
			model.addRow(row);
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	new taotable();
}
}






