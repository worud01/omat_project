package dao;

import java.sql.Connection;

public class RestaurantreDAO {
	private static RestaurantreDAO instance =new RestaurantreDAO();
	private static Connection con;
	public void setConnection(Connection con) {
		this.con=con; 
	} 
	private RestaurantreDAO() {}
	public static RestaurantreDAO getInstance() {
		return instance;
	}
	
	
}
