package net.eleword.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;

public class DBUtil {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/eleword";
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "javafan";
			if (url.equals("jdbc:mysql://localhost:3306/eleword")) {
				Class.forName(driver).newInstance();
				Connection conn = (Connection) DriverManager.getConnection(url, username, password);
				ScriptRunner runner = new ScriptRunner(conn, false, false);
				runner.setErrorLogWriter(null);
				runner.setLogWriter(null);
				runner.runScript(Resources.getResourceAsReader("eleword2014616.sql"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}