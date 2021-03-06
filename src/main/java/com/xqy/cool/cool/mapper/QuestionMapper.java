package com.xqy.cool.cool.mapper;

import com.xqy.cool.cool.model.Question;
import com.xqy.cool.cool.model.QuestionExtample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    long countByExample(QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int deleteByExample(QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int insertSelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    List<Question> selectByExampleWithBLOBsWithRowbounds(QuestionExtample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    List<Question> selectByExampleWithBLOBs(QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    List<Question> selectByExampleWithRowbounds(QuestionExtample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    List<Question> selectByExample(QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    Question selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Question record, @Param("example") QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByExample(@Param("record") Question record, @Param("example") QuestionExtample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByPrimaryKeySelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Tue Dec 31 22:00:06 CST 2019
     */
    int updateByPrimaryKey(Question record);
}