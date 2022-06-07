package com.hejPlogging.domain.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hejPlogging.domain.vo.CourseDTO;
import com.hejPlogging.domain.vo.CourseVO;
import com.mybatis.config.MyBatisConfig;

public class CourseDAO {
   SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
   SqlSession sqlSession;
   
   public CourseDAO() {
      sqlSession = sqlSessionFactory.openSession(true);
   }

   //코스 db 추가
   public void join(CourseVO courseVO) {
	sqlSession.insert("Course.join", courseVO);
   }

   //코스 전체 목록
   public List<CourseDTO> selectCourses(Map<String, Integer> courseMap){
	    return sqlSession.selectList("Course.selectCourses",courseMap);
	}
   //최근 게시글 번호
   public int getSeq() {
	return sqlSession.selectOne("Course.getSeq");
   }

 //게시글 전체 개수
   public int getTotal() {
       return sqlSession.selectOne("Course.getTotal");
   }
//게시글 정보 조회
   public CourseVO selectDetail(int courseNumber) {
       return sqlSession.selectOne("Course.selectDetail", courseNumber);
    }    
}

