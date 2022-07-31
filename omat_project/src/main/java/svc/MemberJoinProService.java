package svc;

import java.sql.Connection;
import static db.JdbcUtill.*;  
import dao.MemberDAO;
import vo.MemberDTO;

public class MemberJoinProService {

	public boolean joinMember(MemberDTO member) {
		boolean isJoinSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// (MemberDAO - insertMember() 메서드 호출 - 파라미터 동일, 리턴타입 : int(insertCount)
		// => Service 클래스에서 수행 결과(int)를 사용하여 commit, rollback 판별
		int insertCount = dao.insertMember(member);
		
		if(insertCount > 0) {
			commit(con);
			isJoinSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isJoinSuccess;
	}

}
