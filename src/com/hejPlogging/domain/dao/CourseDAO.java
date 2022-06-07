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

   //ÄÚ½º db Ãß°¡
   public void join(CourseVO courseVO) {
   sqlSession.insert("Course.join", courseVO);
   }

<<<<<<< HEAD
   //ì½”ìŠ¤ ì „ì²´ ëª©ë¡
   public List<CourseDTO> selectCourses(Map<String, Integer> courseMap){
	    return sqlSession.selectList("Course.selectCourses",courseMap);
	}
   //ìµœê·¼ ê²Œì‹œê¸€ ë²ˆí˜¸
=======
   //ÄÚ½º ÀüÃ¼ ¸ñ·Ï
   public List<CourseDTO> selectCourses(Map<String, Integer> courseMap){
       return sqlSession.selectList("Course.selectCourses",courseMap);
   }
   //ÃÖ±Ù °Ô½Ã±Û ¹øÈ£
>>>>>>> 9175b143820bdb422a4782f59adad45fce3810ab
   public int getSeq() {
   return sqlSession.selectOne("Course.getSeq");
   }

<<<<<<< HEAD
 //ê²Œì‹œê¸€ ì „ì²´ ê°œìˆ˜
   public int getTotal() {
       return sqlSession.selectOne("Course.getTotal");
   }
//ê²Œì‹œê¸€ ì •ë³´ ì¡°íšŒ
   public CourseVO selectDetail(int courseNumber) {
       return sqlSession.selectOne("Course.selectDetail", courseNumber);
    }    
=======
 //°Ô½Ã±Û ÀüÃ¼ °³¼ö
   public int getTotal() {
       return sqlSession.selectOne("Course.getTotal");
   }
//°Ô½Ã±Û Á¤º¸ Á¶È¸
   public CourseVO selectDetail(int courseNumber) {
       return sqlSession.selectOne("Course.selectDetail", courseNumber);
       }    

>>>>>>> 9175b143820bdb422a4782f59adad45fce3810ab
}

