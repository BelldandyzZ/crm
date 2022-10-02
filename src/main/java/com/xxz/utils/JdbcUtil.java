package com.xxz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//4 ������ ������ url ,�û��������� 
	private static String drivername = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/hpcrm";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			// 1.��������
			Class.forName(drivername);
			// 2.�������ݿ�
			conn =DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// �ر�����
	public static void close(Connection c,Statement s,ResultSet r) {
			try {
				if(r!=null) {
					r.close();
				}
				if(s!=null) {
					s.close();
				}
				if(c!=null) {
					c.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	
	
}
