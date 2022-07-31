package dao;

import java.sql.Connection;

public class RestauranListDAO {
	private static RestauranListDAO instance =new RestauranListDAO();
	private static Connection con;
	public void setConnection(Connection con) {
		this.con=con; 
	}  
	private RestauranListDAO() {}
	public static RestauranListDAO getInstance() {
		return instance;
	}
	
	
}
