package com.xqy.cool.cool.service;

import com.xqy.cool.cool.Mapper.QuestionMapper;
import com.xqy.cool.cool.Mapper.UserMapper;
import com.xqy.cool.cool.Model.Question;
import com.xqy.cool.cool.Model.User;
import com.xqy.cool.cool.dto.QuestionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 返回所有QuestionDTO
     *
     * @return
     */
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User usr = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(usr);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
