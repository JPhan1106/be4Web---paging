package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Category;

public class CategoryService {


	public List<Category> getAllCategories () throws SQLException{
       // connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;
		List<Category> list = new ArrayList<Category>();
		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("select * from `category`");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
		
				category = new Category(id,name);
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close ();
			}
		}

		return list;
	}
}
