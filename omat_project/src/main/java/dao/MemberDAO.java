package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtill;
import vo.MemberDTO;

import static db.JdbcUtill.*;


public class MemberDAO {
	private static MemberDAO instance =new MemberDAO();
	private static Connection con;
	public void setConnection(Connection con) {
		this.con=con; 
	}
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	public int selectMember() {
		return 0;
	}
	public int insertMember(MemberDTO dto) {
		PreparedStatement pstmt = null;
		
		System.out.println("insertMember");
		int insertCount = 0;
		String sql = "";
	
		try {
			sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_name());
			pstmt.setString(2, dto.getMember_id());
			pstmt.setString(3, dto.getMember_pass()); 
			pstmt.setString(4, dto.getMember_email());
			pstmt.setString(5, dto.getMember_post_code());
			pstmt.setString(6, dto.getMember_address1());
			pstmt.setString(7, dto.getMember_address2());
			
		
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
			close(pstmt);
		}
		
		
		return insertCount;
		
	}
	public int selectMemberList() {
		return 0;
	}

}
