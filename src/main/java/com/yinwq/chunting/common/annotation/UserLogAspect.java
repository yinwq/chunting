package com.yinwq.chunting.common.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yinwq.chunting.entity.Admin;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yinwq.chunting.entity.User;
import com.yinwq.chunting.entity.UserLogDO;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/3/15 13:51
 */
@Log4j
@Component
@Aspect
public class UserLogAspect {


    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.yinwq.chunting.common.annotation.UserLog)")
    public void controllerAspect() {}

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @SuppressWarnings("rawtypes")
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        //读取session中的用户
        Admin admin = (Admin) session.getAttribute("user");

        if(null != admin){
            //获取请求ip
            String ip = request.getRemoteAddr();

            try{
                String targetName = joinPoint.getTarget().getClass().getName();
                String methodName = joinPoint.getSignature().getName();
                Object[] arguments = joinPoint.getArgs();
                Class targetClass = Class.forName(targetName);
                Method[] methods = targetClass.getMethods();
                String operationUrl = request.getServletPath();
                String operationContent = "";

                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        Class[] clazzs = method.getParameterTypes();

                        if (clazzs.length == arguments.length) {
                            //凡是加了UserLog注解的方法都记录日志
                            if(null != method.getAnnotation(UserLog.class)){
                                operationContent = method.getAnnotation(UserLog.class).operationContent();

                                //获取用户请求方法的参数并序列化为JSON格式字符串
                                Map<String,Object> nameAndArgs = null;

                                if(null != joinPoint.getArgs() && joinPoint.getArgs().length > 0) {
                                    //获取参数名称和值
                                    nameAndArgs = getParameMap(joinPoint);
                                }

                                UserLogDO log = new UserLogDO();
                                log.setUserId(admin.getAdminid().longValue());
                                log.setUserName(admin.getName());
                                log.setIp(ip);
                                log.setOperationUrl(operationUrl);
                                log.setOperationContent(operationContent);
                                log.setParamsMap(nameAndArgs);

                                //TODO 存储日志
                                //logSysUserService.saveSysUserLog(log);

                                break;
                            }
                        }
                    }
                }
            }catch(Exception e) {
                log.error("记录用户操作日志失败！", e);
            }
        }
    }

    /**
     * @Title: getParameMap
     * @Description: 获取参数的名称和值
     * @author: 施勇
     * @date: 2018年10月3日 下午3:12:26
     * @param: @param joinPoint
     * @param: @return
     * @return: Map<String,Object>
     * @throws
     */
    public Map<String,Object> getParameMap(JoinPoint joinPoint){
        Map<String, Object> map = new HashMap<>();

        // 参数值
        Object[] args = joinPoint.getArgs();
        // 参数名
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();

        for(int i=0;i<argNames.length;i++){
            if("response".equals(argNames[i]) || "request".equals(argNames[i]) || "pwd".equals(argNames[i])){
                continue;
            }else{
                map.put(argNames[i], args[i]);
            }
        }

        return map;
    }

}
