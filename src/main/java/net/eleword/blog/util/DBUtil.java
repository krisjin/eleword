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
			String password = "";
			if (url.equals("jdbc:mysql://localhost:3306/eleword")) {
				Class.forName(driver).newInstance();
				Connection conn = (Connection) DriverManager.getConnection(url+"?useUnicode=true&characterEncoding=utf-8", username, password);
				ScriptRunner runner = new ScriptRunner(conn, false, false);
				runner.setErrorLogWriter(null);
				runner.setLogWriter(null);
				runner.runScript(Resources.getResourceAsReader("eleword-20140930.sql"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}