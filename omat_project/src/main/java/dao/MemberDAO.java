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
	public boolean selectMember(MemberDTO member) {
		boolean isLoginSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=? AND passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isLoginSuccess =  true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMember() 메서드 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return isLoginSuccess;
	}
	public int insertMember(MemberDTO dto) {
		PreparedStatement pstmt = null;
		
		System.out.println("insertMember");
		int insertCount = 0;
		String sql = "";
	
		try {
			sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,now(),0,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getNick_name());
			pstmt.setString(6, dto.getBirth_date());
			pstmt.setInt(7, dto.getSpicy_degree());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
			close(pstmt);
		}
		
		
		return insertCount;
		
	}
	public boolean checkUser(MemberDTO dto) throws Exception {
		boolean isLoginSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 3단계. SQL 구문 작성 및 전달
			// => 전달받은 아이디, 패스워드를 사용하여 일치하는 레코드 조회
			String sql = "SELECT * FROM auth_member WHERE id=? AND passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			
			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// ResultSet 객체의 다음 레코드가 존재할 경우 = 로그인 성공
			if(rs.next()) {
				// 조회 성공 시(= 로그인 성공) isLoginSuccess 값을 true 로 변경
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			close(rs);
			close(pstmt);
		}
		
		return isLoginSuccess;
	}
	
	public int registAuthCode(String id, String authCode) {
		int registCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 전달받은 ID 에 대한 기존 인증코드가 존재하는지 확인 후
			// 만약, 기존 인증코드가 존재하면 새 인증코드로 덮어쓰고(UPDATE),
			// 아니면, 아이디와 인증코드를 새로 등록(INSERT)
			String sql = "SELECT auth_code FROM auth_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 기존 인증코드가 이미 존재하는 경우
				// UPDATE 구문을 사용하여 인증코드 갱신(새로운 인증코드로 덮어씀)
				sql = "UPDATE auth_info SET auth_code=? WHERE id=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authCode);
				pstmt2.setString(2, id);
				registCount = pstmt2.executeUpdate();
				System.out.println("인증코드 갱신 성공!");
			} else { // 기존 인증코드가 존재하지 않는 경우
				// INSERT 구문을 사용하여 아이디와 인증코드 추가
				sql = "INSERT INTO auth_info VALUES (?,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, id);
				pstmt2.setString(2, authCode);
				registCount = pstmt2.executeUpdate();
				System.out.println("인증코드 등록 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		
		return registCount;
	}
	public boolean selectDuplicateId(String id) {
		boolean isDuplicate = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 아이디가 이미 존재할 경우
				isDuplicate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectDuplicateId() 메서드 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isDuplicate;
	}

}
