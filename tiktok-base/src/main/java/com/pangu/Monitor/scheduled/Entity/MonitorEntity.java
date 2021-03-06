package com.pangu.Monitor.scheduled.Entity;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-23 20:03
 * @desc:
 */
public class MonitorEntity {
    // 文件路径
    private String filePath;
    // 正则表达式
    private String expression;
    // String
    private String info;
    // level 报警等级
    private String level;
    // 是否报警
    private boolean isWarn;
    // 报警标题
    private String title;
    // 报警内容
    private String content;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isWarn() {
        return isWarn;
    }

    public void setWarn(boolean warn) {
        isWarn = warn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
