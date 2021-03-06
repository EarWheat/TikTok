package com.pangu.Groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.util.DigestUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-09 18:01
 * @desc Groovy测试辅助类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class GroovyUtil {
    // groovy每执行一次脚本，都会生成一个脚本的class对象,缓存groovyClass 对象减少内存空间
    private static ConcurrentHashMap<String, Class> scriptClassMap = new ConcurrentHashMap<>();


    /**
     * 返回groovy脚本类
     * @param scriptText
     * @return
     * @throws CompilationFailedException
     */
    public static Class parseClass(String scriptText) throws CompilationFailedException {
        String key = DigestUtils.md5DigestAsHex(scriptText.getBytes());
        Class value = scriptClassMap.get(key);
        if (value != null) {
            return value;
        }
        // 每个key唯一锁,不同key不竞争
        synchronized (scriptText.intern()) {
            if (scriptClassMap.get(key) == null) {
                // 里面有个恶心的锁,还是每次new一个比较好
                GroovyClassLoader groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
                Class scriptClass = groovyClassLoader.parseClass(scriptText);
                scriptClassMap.put(key, scriptClass);
                return scriptClass;
            }
        }
        return scriptClassMap.get(key);
    }

    public static Object runGroovyClass(String expr, Map params){
        if (StringUtils.isBlank(expr)) {
            return null;
        }
        try {
            Class exprClass = parseClass(expr);
            return InvokerHelper.createScript(exprClass, new Binding(params)).run();
        } catch (Exception e) {
            return null;
        }
    }
}
