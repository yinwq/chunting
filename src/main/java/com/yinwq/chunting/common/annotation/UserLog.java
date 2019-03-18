package com.yinwq.chunting.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/3/15 13:43
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserLog {
    /** 要执行的操作内容比如：用户：XXX登录成功 **/
    public String operationContent() default "";
}
