package com.zsw.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/***
 * 封装bean属性拷贝方法
 */
public class BeanCopyUtils {

    private BeanCopyUtils() {
    }

    public static <T> T BeanCopy(Object obj,Class<T> clazz){
        //创建目标对象
        T result = null;
        try {
            //实现属性拷贝
            result = clazz.newInstance();
            BeanUtils.copyProperties(obj,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    public static <T> List<T> BeanCopyList(List<?> obj,Class<T> clazz){
        return obj.stream().map(O -> BeanCopy(O, clazz)).collect(Collectors.toList());
    }
}
