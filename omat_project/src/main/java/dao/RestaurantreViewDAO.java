package dao;

import java.sql.Connection;

public class RestaurantreViewDAO {
	private static RestaurantreViewDAO instance =new RestaurantreViewDAO();
	private static Connection con;
	public void setConnection(Connection con) {
		this.con=con; 
	} 
	private RestaurantreViewDAO() {}
	public static RestaurantreViewDAO getInstance() {
		return instance;
	}
	
	
}
