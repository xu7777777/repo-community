package com.xqy.cool.cool.service;

import com.xqy.cool.cool.Mapper.QuestionMapper;
import com.xqy.cool.cool.Mapper.UserMapper;
import com.xqy.cool.cool.Model.Question;
import com.xqy.cool.cool.Model.User;
import com.xqy.cool.cool.dto.PaginationDTO;
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
     * @param page
     * @param size
     */
    public PaginationDTO list(Integer page, Integer size) {

        //计算页码
        Integer offset = size*(page - 1);

        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPagination(questionMapper.count(), page, size);

        if (page < 1){
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User usr = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(usr);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
