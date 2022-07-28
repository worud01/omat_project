package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtill {
	public static Connection getConnection() {
	
		Connection con=null;
		try {
			try {
				Context initContext=new InitialContext();
				DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/MySQL");
				
				con=ds.getConnection();
				con.setAutoCommit(false);// 자동 커밋 해체
				//dml 작업후에는 수동으로 커밋 작업을 해야함
				//rollback 작업을 수동으로 해야함
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	//트렌젝션 처리에 필요한  작업 매서드를 정의
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
