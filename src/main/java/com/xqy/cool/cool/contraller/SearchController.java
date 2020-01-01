package com.xqy.cool.cool.contraller;

import com.xqy.cool.cool.dto.PaginationDTO;
import com.xqy.cool.cool.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/search")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "messageName", defaultValue = "Search") String messageName,
                        @RequestParam(name = "size", defaultValue = "8") Integer size) {
        PaginationDTO pagination = questionService.listLikeName(messageName, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("messageName", messageName);
        return "search";
    }
}
