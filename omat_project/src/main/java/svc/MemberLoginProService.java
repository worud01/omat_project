package svc;

import java.sql.Connection;
import static db.JdbcUtill.*;  
import dao.MemberDAO;
import vo.MemberDTO;

public class MemberLoginProService {

	public boolean loginMember(MemberDTO member) {
		boolean isLoginSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isLoginSuccess = dao.selectMember(member);
		
		close(con);
		
		return isLoginSuccess;
	}

}
