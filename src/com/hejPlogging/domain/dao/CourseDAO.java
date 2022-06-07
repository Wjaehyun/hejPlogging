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

   //�ڽ� db �߰�
   public void join(CourseVO courseVO) {
   sqlSession.insert("Course.join", courseVO);
   }

<<<<<<< HEAD
   //코스 전체 목록
   public List<CourseDTO> selectCourses(Map<String, Integer> courseMap){
	    return sqlSession.selectList("Course.selectCourses",courseMap);
	}
   //최근 게시글 번호
=======
   //�ڽ� ��ü ���
   public List<CourseDTO> selectCourses(Map<String, Integer> courseMap){
       return sqlSession.selectList("Course.selectCourses",courseMap);
   }
   //�ֱ� �Խñ� ��ȣ
>>>>>>> 9175b143820bdb422a4782f59adad45fce3810ab
   public int getSeq() {
   return sqlSession.selectOne("Course.getSeq");
   }

<<<<<<< HEAD
 //게시글 전체 개수
   public int getTotal() {
       return sqlSession.selectOne("Course.getTotal");
   }
//게시글 정보 조회
   public CourseVO selectDetail(int courseNumber) {
       return sqlSession.selectOne("Course.selectDetail", courseNumber);
    }    
=======
 //�Խñ� ��ü ����
   public int getTotal() {
       return sqlSession.selectOne("Course.getTotal");
   }
//�Խñ� ���� ��ȸ
   public CourseVO selectDetail(int courseNumber) {
       return sqlSession.selectOne("Course.selectDetail", courseNumber);
       }    

>>>>>>> 9175b143820bdb422a4782f59adad45fce3810ab
}

