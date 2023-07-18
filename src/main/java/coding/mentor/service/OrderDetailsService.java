package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.OrderDetails;

public class OrderDetailsService {

	public void addOrderDetails (OrderDetails orderDetails) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
		
			String sql = "INSERT INTO `order_details`(order_id, book_id) value(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, orderDetails.getOrderId());
			ps.setInt(2, orderDetails.getBookId());
		
			ps.execute();
			
	
	} finally {

		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}

	}
	}
}