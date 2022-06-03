// 하 이클립스 깃헙 연동 왜 아무도 안알려주나.....ㅜㅜ

// 왜 또 마스터로 들어가는 걸까
// 왜 자동 undoing 되

// 마스터 브랜치는 푸시 되나  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/test";
			return DriverManager.getConnection(url, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	public static void close(Statement stmt, Connection conn) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
