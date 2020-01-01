package com.xqy.cool.cool.contraller;

import com.xqy.cool.cool.model.Question;
import com.xqy.cool.cool.model.User;
import com.xqy.cool.cool.dto.QuestionDTO;
import com.xqy.cool.cool.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Integer id,
            HttpServletRequest request,
            Model model
    ) {
        //发布失败，回写用户填入的信息
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        //差错检测
        if (title == null || title == ""){
            model.addAttribute("error","标题不能为空。");
            return "publish";
        }
        if (description == null || description == ""){
            model.addAttribute("error","留言内容不能为空。");
            return "publish";
        }
        if (tag == null || tag == ""){
            model.addAttribute("error","标签不能为空。");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");

        if (user == null){
            model.addAttribute("error","用户未登录。");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);

        return "redirect:/";
    }

    @GetMapping("/publish/{operate}/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       @PathVariable(name = "operate") String operate,
                       Model model){
        if ("edit".equals(operate)){
            QuestionDTO question = questionService.getById(id);
            model.addAttribute("title", question.getTitle());
            model.addAttribute("description", question.getDescription());
            model.addAttribute("tag", question.getTag());
            model.addAttribute("id", question.getId());
            return "publish";
        }else if ("del".equals(operate)){
            questionService.delete(id);
            return "redirect:/profile/questions";
        }

        return null;
    }
}
