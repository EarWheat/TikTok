package com.pangu.Monitor.Http;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Monitor.mail.MailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 16:34
 * @desc:
 */
@Component
@Aspect
public class HttpMonitorAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpMonitorAspect.class);

    @Resource
    private MailService mailService;
    /**
     * @Pointcut声明了切点（这里的切点是我们自定义的注解类），
     */
    @Pointcut("@annotation(com.pangu.Monitor.Http.HttpMonitor)")
    private void annotationPointcut() {}


    @Before(value = "@annotation(com.pangu.Monitor.Http.HttpMonitor)")
    public void doBefore(JoinPoint joinPoint) {
        //获取到请求的属性
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到请求对象
        HttpServletRequest request = attributes.getRequest();

        //URL：根据请求对象拿到访问的地址
        logger.info("url=" + request.getRequestURL());
        //获取请求的方法，是Get还是Post请求
        logger.info("method=" + request.getMethod());
        //ip：获取到访问
        logger.info("ip=" + request.getRemoteAddr());
        //获取被拦截的类名和方法名
        logger.info("class=" + joinPoint.getSignature().getDeclaringTypeName() +
                "and method name=" + joinPoint.getSignature().getName());
        //参数
        logger.info("参数=" + joinPoint.getArgs().toString());

    }


    @Around("annotationPointcut()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        map.put("requestRemoteAddr",request.getRemoteAddr());
        map.put("requestUrl",request.getRequestURL().toString());
        map.put("requestMethod", request.getMethod());
        map.put("requestParam",Arrays.toString(pjp.getArgs()));
        map.put("requestCostTime", String.valueOf(System.currentTimeMillis() - start));
//        mailService.sendSimpleMail("554725722@qq.com","RestInfoMonitor",map.toString());
        Object result = pjp.proceed();
        logger.info("Http request:{}", JSONObject.toJSONString(map));
        return result;
    }

}
