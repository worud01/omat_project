package controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberJoinProAction;
import action.MemberListAction;
import action.MemberLoginProAction;
import action.MemberLogoutAction;
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
		if (command.equals("/MemberJoinFrom.me")) {
			forward = new ActionForward();
			forward.setPath("/member/member_join.jsp");
			forward.setRedirect(false);
			
		} else if (command.equals("/MemberJoinPro.me")) {
			try {
				action =new MemberJoinProAction();
				forward=action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if (command.equals("/MemberLoginFrom.me")) {
		
			forward = new ActionForward();
			forward.setPath("/member/member_login.jsp");
			forward.setRedirect(false);
			
		}else if (command.equals("/MemberLoginPro.me")) {
		
			try {
				action=new MemberLoginProAction();
				forward=action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}else if (command.equals("/MemberLogout.me")) {
			try {
				action=new MemberListAction();
				forward=action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}else if (command.equals("/MemberList.me")) {
			try {
				action=new MemberLogoutAction();
				forward=action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}else if (command.equals("/MemberLoginCgeck.me")) {
			forward = new ActionForward();
			forward.setPath("/member/member_check_id.jsp");
			forward.setRedirect(false);
		
			
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
