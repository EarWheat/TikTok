package com.pangu.HttpSession;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 下午6:39
 * @desc Session监听
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  {
        HttpSessionContext.setHttpSession(event.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent event)  {
        HttpSessionContext.destroyedHttpSession(event.getSession().getId());
    }


}
