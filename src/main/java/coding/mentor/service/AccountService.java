package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Account;

public class AccountService {

	public void addNewAccount(Account account) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
//			make connection to mySQL
			conn = DBUtil.makeConnection();

//			create sql for insert
			String sql = "INSERT INTO account(username, email, password) value(?,?,?)";
			ps = conn.prepareStatement(sql);

//			set parameters
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getEmail());
			ps.setString(3, account.getPassword());

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

	public boolean isEmailAvailable(String email) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// Make connection to MySQL
			conn = DBUtil.makeConnection();

			// Create SQL for select
			String sql = "SELECT COUNT(*) FROM student WHERE email = ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Email is available if count is 0
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return true;
	}


	public boolean isValidInput(String username, String email, String password) {
		// Check if all fields are non-empty
		if (username != null && !username.isEmpty() && email != null && !email.isEmpty() && password != null
				&& !password.isEmpty()) {
			return true;
		}

		return false;

	}

	public Account getAccountByUsernameAndPassword(String username, String password) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Account account = null;

	    try {
	        conn = DBUtil.makeConnection();

	        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
	        ps = conn.prepareStatement(sql);

	        ps.setString(1, username);
	        ps.setString(2, password);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("id");
	            account = new Account(id, username, password);
	        }

	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (ps != null) {
	            ps.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }

	    return account;
	}
}
