package com.xqy.cool.cool.dto;

import com.xqy.cool.cool.Model.User;
import lombok.Data;

/**
 * 由于Question对象中不存在图片链接，因此数据传递过程中在service层组装QuestionDTO对象，提供Model。
 */
@Data
public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private String tag;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Long gmtCreate;
    private Long gmtModify;
    private User user;
}
