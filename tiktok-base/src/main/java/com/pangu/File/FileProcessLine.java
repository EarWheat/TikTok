package com.pangu.File;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 上午10:53
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public abstract class FileProcessLine {
    public abstract void readLine(String line);
    public abstract Object process();
}
