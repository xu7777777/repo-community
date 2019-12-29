package com.xqy.cool.cool.dto;

import lombok.Data;

//@Data
//public class AccessTokenDTO {
//    private String client_id;
//    private String client_secret;
//    private String code;
//    private String redirect_uri;
//    private String state;
//}

@Data
public class AccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;
}
