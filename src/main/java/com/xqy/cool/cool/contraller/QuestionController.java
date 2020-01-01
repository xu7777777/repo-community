package com.xqy.cool.cool.contraller;

import com.xqy.cool.cool.dto.QuestionDTO;
import com.xqy.cool.cool.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 问题展示
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id, Model model) {
//        Long questionId = null;
//        try {
//            questionId = Long.parseLong(id);
//        } catch (NumberFormatException e) {
//            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
//        }
        QuestionDTO questionDTO = questionService.getById(id);
//        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
//        List<CommentDTO> comments = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);
//        //累加阅读数
//        questionService.incView(questionId);
        model.addAttribute("question", questionDTO);
//        model.addAttribute("comments", comments);
//        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
