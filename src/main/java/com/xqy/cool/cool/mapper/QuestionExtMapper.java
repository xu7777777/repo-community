package com.xqy.cool.cool.mapper;

import com.xqy.cool.cool.model.Question;

/**
 * 为保证并发浏览时计数器累加的原子性。
 */
public interface QuestionExtMapper {
    int incView(Question record);
}