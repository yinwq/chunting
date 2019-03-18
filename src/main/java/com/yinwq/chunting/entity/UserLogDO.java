package com.yinwq.chunting.entity;

import lombok.Data;

import java.util.Map;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/3/15 13:56
 */
@Data
public class UserLogDO {


    private Long userId;
    private String userName;
    private String ip;
    private String operationUrl;
    private String operationContent;
    private Map<String, Object> paramsMap;
}
