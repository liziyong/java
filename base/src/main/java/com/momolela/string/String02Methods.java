package com.momolela.string;

import java.io.UnsupportedEncodingException;

public class String02Methods {
    public static void main(String[] args) {

        String str = "abbacsunzj";

        // 获取
        System.out.println(str.length()); // 获取字符串的长度
        System.out.println(str.charAt(5)); // 获取指定位置的char
        System.out.println(str.indexOf("sunzj"));
        System.out.println(str.lastIndexOf("sunzj"));
        System.out.println(str.substring(5, 10)); // 包含头不包含尾
        // 判断
        System.out.println(str.startsWith("sunzj"));
        System.out.println(str.endsWith("sunzj"));
        System.out.println(str.isEmpty());
        System.out.println(str.contains("sunzj"));
        System.out.println(str.equals("sunzj"));
        System.out.println(str.equalsIgnoreCase("abbacSunZj"));
        // 转换
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(new String(arr)); // 字符数组转字符串
        System.out.println(str.copyValueOf(arr)); // 字符数组转字符串
        System.out.println(str.valueOf(arr)); // 字符数组转字符串,valueOf()可以将基本数据类型转字符串
        System.out.println(str.toCharArray()); // 字符串转字符数组
        System.out.println(3 + ""); // 转字符串
        try {
            System.out.println(new String(str.getBytes("UTF-8"))); // 将字节数组转字符串
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 替换
        String replace = str.replace("sunzj", "hufy");
        System.out.println(replace);
        // 切割
        System.out.println(str.split("b"));
        // 转换大小写
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        // 去空格
        System.out.println(str.trim());
        // 比较
        System.out.println(str.compareTo("bbbbbsunzj"));
    }
}