package com.pangu.Util;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 17:35
 * @desc 配置读取辅助类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class PropertiesUtil implements EmbeddedValueResolverAware {
    private StringValueResolver stringValueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }

    /**
     * 获取属性，直接传入属性名称即可
     * @param key
     * @return
     */
    public String getPropertiesValue(String key) {
        StringBuilder name = new StringBuilder("${").append(key).append("}");
        return stringValueResolver.resolveStringValue(name.toString());
    }
}
