package controller;


import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


import action.Action;
import action.MemberChechDuplicateIdAction;
import action.MemberJoinProAction;
import action.MemberLoginProAction;
import action.MemberLogoutAction;
import action.MemberSendAuthMailAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		System.out.println(command);
		ActionForward forward = null;
		Action action = null;

		
		if (command.equals("/MemberJoinForm.me")) {
			forward= new ActionForward();
			forward.setPath("/member/memberForm.jsp");
			forward.setRedirect(true);
		}else if (command.equals("/MemberJoinPro.me")) {
			try {
				action =new MemberJoinProAction(); 
				forward =action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(command.equals("/CheckDuplicateId.auth")) {
			action = new MemberChechDuplicateIdAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SendAuthMail.auth")) {
			try {
				action = new MemberSendAuthMailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLoginForm.auth")) {
			forward = new ActionForward();
			forward.setPath("member/login_form.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberLoginPro.auth")) {
			try {
				action = new MemberLoginProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/MemberLogout.auth")) {
			try {
				action = new MemberLogoutAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

}
