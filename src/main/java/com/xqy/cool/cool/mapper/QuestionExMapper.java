package com.xqy.cool.cool.mapper;

import com.xqy.cool.cool.model.Question;

public interface QuestionExMapper {
    int incView(Question record);

    int incCommentCount(Question record);

}