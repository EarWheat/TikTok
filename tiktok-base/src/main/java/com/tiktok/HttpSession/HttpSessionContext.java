package com.tiktok.HttpSession;

import com.tiktok.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 下午6:16
 * @desc httpSession上下文
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class HttpSessionContext {
    private static Map<String, HttpSession> sessionContext = new HashMap<>();

    /**
     * 设置Session
     * @param session
     */
    public static void setHttpSession(HttpSession session){
        if(!sessionContext.containsKey(session.getId())){
            session.setAttribute(Constants.SESSION_CONNECT_TIMES,1);    // 第一次链接
            sessionContext.put(session.getId(),session);
        } else {
            HttpSession s = sessionContext.get(session.getId());
            int connectTimes = (int)s.getAttribute(Constants.SESSION_CONNECT_TIMES) + 1;    // 链接次数+1
            s.setAttribute(Constants.SESSION_CONNECT_TIMES,connectTimes);
            sessionContext.put(session.getId(),s);
        }
    }

    public static HttpSession getHttpSession(String sessionId){
        return sessionContext.get(sessionId);
    }

    static void destroyedHttpSession(String sessionId){
        sessionContext.remove(sessionId);
    }

    public static Map<String, HttpSession> getSessionContext(){
        return sessionContext;
    }

    /**
     * 是否已经
     * @param sessionId
     * @return
     */
    public static Boolean containsSession(String sessionId){
        return sessionContext.containsKey(sessionId);
    }


    /**
     * 定时清理过期Session
     */
    @Scheduled(fixedRate = 600)
    private void checkExpireSession(){
        long now = new Date().getTime();
        sessionContext.forEach((key, value) -> checkExpire(value, now));
    }

    private void checkExpire(HttpSession session, long now){
        long updateTime = (Long) session.getAttribute(Constants.SESSION_UPDATE_TIME);
        if(now - updateTime > Constants.SESSION_EXPIRE_TIME){
            destroyedHttpSession(session.getId());
        }
    }
}
