package com.xxz.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.proxy.DruidDriver;

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

//根据所加载的配置信息创建连接池
		DruidDataSource druid = new DruidDataSource();
		Connection conn = null;
		try {
			Class.forName(drivername);
			druid.setUrl(url);
			druid.setUsername(username);
			druid.setPassword(password);
			conn = druid.getConnection();
		} catch (Exception throwables) {
			throwables.printStackTrace();
		}
//		Connection conn = null;
//		try {
//			// 1.��������
//			Class.forName(drivername);
//			// 2.�������ݿ�
//			conn =DriverManager.getConnection(url, username, password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
