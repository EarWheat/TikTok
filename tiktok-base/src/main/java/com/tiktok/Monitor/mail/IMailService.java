package com.tiktok.Monitor.mail;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-11 20:46
 * @desc:
 */
public interface IMailService {
    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

}
