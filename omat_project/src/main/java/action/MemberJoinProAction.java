package action;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberDTO;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		
		
		 String email= request.getParameter("email1") + "@" + request.getParameter("email2");
		 String id= request.getParameter("email1");
		 String name=request.getParameter("name");
		 String passwd= request.getParameter("psswd");
		 String nick_name= request.getParameter("nick_name");
		 String birth_date= request.getParameter("birth_date");
		 int spicy_degree= Integer.parseInt(request.getParameter("spicy_degree"));
//		 String post_code= request.getParameter("post_code");
//		 String address1=request.getParameter("address1");
//		 String address2=request.getParameter("address2");
		 MemberDTO member = new MemberDTO();
		 member.setEmail(email);
		 member.setId(id);
		 member.setName(name);
		 member.setPasswd(passwd);
		 member.setNick_name(nick_name);
		 member.setBirth_date(birth_date);
		 member.setSpicy_degree(spicy_degree);
//		 member.setPost_code(post_code);
//		 member.setAddress1(address1);
//		 member.setAddress1(address2);
		 MemberJoinProService service = new MemberJoinProService();
		 boolean isJoinSuccess = service.joinMember(member);
		 if(!isJoinSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 가입 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// 가입 성공 시 인증 메일 발송을 위한 서블릿 주소 요청(파라미터 : 아이디, 이메일)
				forward = new ActionForward();
				forward.setPath("SendAuthMail.auth?id=" + member.getId() + "&email=" + member.getEmail());
				forward.setRedirect(true);
			}
			
			return forward;
		
		
		
		
	
	}

}
