package com.hejPlogging;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hejPlogging.action.ActionInfo;

public class CourseFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURL = req.getRequestURI();
		String command = requestURL.substring(requestURL.lastIndexOf("/") + 1);
		ActionInfo actionInfo = null;
		
		if(command.equals("courseadd.cs")) {
			actionInfo = new CourseAdd().execute(req, resp);
		} else if(command.equals("coursewrite")) {
			actionInfo = new ActionInfo();
			actionInfo.setRedirect(true); 
			actionInfo.setPath(req.getContextPath() + "/.jsp");
		}else{
		//	 404 �씪 �븣 異쒕젰�븷 �뿉�윭 �럹�씠吏� 寃쎈줈 �옉�꽦
		}
		
		if(command.equals("courseMainInfo.cs")) {
			actionInfo = new CourseMainInfo().execute(req, resp);
		}else {
		//	 404 �씪 �븣 異쒕젰�븷 �뿉�윭 �럹�씠吏� 寃쎈줈 �옉�꽦
		}
		
		if(command.equals("courseDetail.cs")) {
			actionInfo = new CourseDetail().execute(req, resp);
		}else {
		//	 404 �씪 �븣 異쒕젰�븷 �뿉�윭 �럹�씠吏� 寃쎈줈 �옉�꽦
		}
		
		if(actionInfo != null) {
			if(actionInfo.isRedirect()) {
				resp.sendRedirect(actionInfo.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(actionInfo.getPath());
				dispatcher.forward(req, resp);
			}
		}
		
	}
	
}
