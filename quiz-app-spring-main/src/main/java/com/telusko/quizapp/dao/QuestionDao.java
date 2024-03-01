package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    
   /* //String sql="SELECT * FROM (SELECT * FROM question WHERE category = 'Java' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM <= 5;";

    //@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    //List<Question> findRandomQuestionsByCategory(String category, int numQ);

	//List<Question> findByCategoryOrderByRandom(String string);
    
    //List<Question> findRandomQuestionsByCategory(String category,String sql);
    
    
    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :count", nativeQuery = true)
    //@Query(value = "SELECT * FROM (SELECT * FROM question WHERE category = 'Java' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM <= 5;", nativeQuery = true)
    
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("count") int count);

    //List<Question> findRandomQuestionsByCategory();
*/
    
    //@Query(value ="SELECT * FROM (SELECT * FROM question WHERE category = :category ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM <= :numQ" , nativeQuery = true)

    //@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    //@Query(value = "SELECT * FROM (SELECT * FROM question Where category=:category ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM<=:numQ", nativeQuery = true)
    
    @Query(value = "SELECT q FROM Question q where q.category= :category ORDER BY FUNCTION('DBMS_RANDOM.VALUE') FETCH FIRST :numQ ROWS ONLY")

    List<Question> findRandomQuestionsByCategory(@Param("category")String category, @Param("numQ")int numQ);

    
    
    
}

