package com.hejPlogging;

import java.io.IOException;
//�׽�Ʈ
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hejPlogging.action.Action;
import com.hejPlogging.action.ActionInfo;
import com.hejPlogging.domain.dao.CourseDAO;
import com.hejPlogging.domain.dao.CourseFileDAO;
import com.hejPlogging.domain.vo.CourseFileVO;
import com.hejPlogging.domain.vo.CourseVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CourseAdd implements Action{
	
	private ServletResponse response;

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		String uploadPath = "C:\\web_1900j_wjh\\jsp\\workspace\\hejPlogging\\WebContent\\upload";
		int fileSize = 1024 * 1024 * 5; //5M
		
		ActionInfo actionInfo = new ActionInfo();
		CourseFileDAO fileDAO = new CourseFileDAO();
		CourseVO courseVO = new CourseVO();
		CourseDAO courseDAO = new CourseDAO();
		CourseFileVO fileVO = new CourseFileVO();
		
		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//courseVO.setCourseNumber(Integer.parseInt(multipartRequest.getParameter("courseNumber")));
		//�׽�Ʈ
		courseVO.setCourseName(multipartRequest.getParameter("courseName"));
		courseVO.setCourseDetail(multipartRequest.getParameter("courseDetail"));
		courseVO.setCourseImgTitle(multipartRequest.getParameter("courseImgTitle"));
		courseVO.setCourseImgDetail(multipartRequest.getParameter("courseImgDetail"));
		courseVO.setCourseDifficulty(multipartRequest.getParameter("courseDifficulty"));
		courseVO.setCourseStart(multipartRequest.getParameter("courseStart"));
		courseVO.setCourseEnd(multipartRequest.getParameter("courseEnd"));
		courseVO.setCourseStartDetail(multipartRequest.getParameter("courseStartDetail"));
		courseVO.setCourseEndDetail(multipartRequest.getParameter("courseEndDetail"));

		
		courseDAO.join(courseVO);
//		courseDAO.insert(multipartRequest, courseDAO.getSeq());
		fileDAO.insert(multipartRequest, courseDAO.getSeq());
		
//		int courseNumber = courseDAO.getSeq();
//		int courseNumber = Integer.parseInt(multipartRequest.getParameter("courseNumber"));
//		int courseNumber = fileVO.getCourseNumber();
//		req.setAttribute("memberName", memberVO.getMemberName());
//		req.setAttribute("CourseName", courseVO.getCourseName());
//		req.setAttribute("courseList", courseDAO.selectCourses());
//		req.setAttribute("coursefileList", fileDAO.select(courseNumber));
//		System.out.println(courseNumber);
//		System.out.println(courseDAO.selectCourses().get(0).getCourseName());
//		System.out.println(fileDAO.select(courseVO.getCourseNumber()).get(0).getFileName());
		actionInfo.setRedirect(true);
//		actionInfo.setPath("/courseMain.jsp");
		actionInfo.setPath(req.getContextPath() + "/courseMainInfo.cs");

		return actionInfo;
	}
}
