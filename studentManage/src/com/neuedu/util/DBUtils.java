package com.neuedu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	//静态代码块,获取配置文件变量
		private static Properties prop;
		static {
			prop = new Properties();
			try {
				prop.load(Object.class.getResourceAsStream("/setting.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	//拿到配置文件中的值
		private static final String URL = prop.getProperty("url");
		private static final String USERNAME = prop.getProperty("username");
		private static final String PASSWORD = prop.getProperty("password");
	//获取连接
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
}
