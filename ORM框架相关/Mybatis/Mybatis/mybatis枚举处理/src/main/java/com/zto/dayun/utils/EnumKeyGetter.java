package com.zto.dayun.utils;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 17:18
 * @Description:
 */
public interface EnumKeyGetter<T extends Enum<T>, K> {
    K getKey(T enumValue);
}
