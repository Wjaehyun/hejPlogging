package com.hejPlogging;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hejPlogging.action.Action;
import com.hejPlogging.action.ActionInfo;
import com.hejPlogging.domain.dao.CourseDAO;
import com.hejPlogging.domain.dao.CourseFileDAO;
import com.hejPlogging.domain.vo.CourseVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CourseMainInfo implements Action{
	
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		
		ActionInfo actionInfo = new ActionInfo();
		CourseFileDAO fileDAO = new CourseFileDAO();
		CourseVO courseVO = new CourseVO();
		CourseDAO courseDAO = new CourseDAO();
		HashMap<String, Integer> courseMap = new HashMap<>();
		

		//전체 게시글 개수
		int total = courseDAO.getTotal();
		//사용자가 요청한 페이지
		String temp = req.getParameter("page");
		//사용자가 요청한 페이지가 null이면 1페이지를,
		//null이 아니면 요청한 페이지를 page에 담아준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		//한 페이지에 출력되는 게시글의 개수
		int rowCount = 9;
		//한 화면에 나오는 페이지 번호 수
		int pageSize = 5;
		
		//페이지에서 출력되는 게시글 중 첫번째 게시글의 인덱스
		int startRow = (page - 1) * rowCount;
		
		//화면에 출력되는 페이지 번호 중
		//시작 페이지(1, 11, 21, ....)
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		//끝 페이지(10, 20, 30, ...)
		int endPage = startPage + pageSize - 1;
		//실제 마지막 게시글이 출력되는 마지막 페이지 번호
		int realEndPage = (int)Math.ceil(total / (double)rowCount);
		
		//만약 화면에서의 마지막 페이지가 실제 마지막 페이지보다 크다면,
		//실제 마지막 페이지를 endPage에 담아준다.
		//endPage는 항상 10단위로 끝나기 때문에, 14페이지가 마지막 페이지일 경우
		//14페이지를 endPage에 담아준다. 
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		//DB에서 필요한 데이터를 Map에 담는다.
		courseMap.put("startRow", startRow);
		courseMap.put("rowCount", rowCount);
		
		req.setAttribute("courseList", courseDAO.selectCourses(courseMap));
		req.setAttribute("imageList", courseDAO.selectImage(courseMap));
		req.setAttribute("page", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("total", total);	
//		req.setAttribute("memberName", memberVO.getMemberName());
//		req.setAttribute("CourseName", courseVO.getCourseName());
//		req.setAttribute("coursefileList", fileDAO.select(courseVO.getCourseNumber()));
		System.out.println(courseDAO.selectCourses(courseMap).get(0).getCourseNumber());
//		System.out.println(fileDAO.select(courseDAO.getCourseNumber()).get(0).getFileName());
		actionInfo.setRedirect(false);
		actionInfo.setPath("/courseMain.jsp");
//		actionInfo.setPath(req.getContextPath() + "/CourseMainInfo.cs");
		
		return actionInfo;
	}
}
