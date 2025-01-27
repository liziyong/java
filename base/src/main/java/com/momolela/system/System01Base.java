package com.momolela.system;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class System01Base {

    public static void main(String[] args) {
        System.out.println("标准输出\n");


        System.setProperty("sunzj", "hufy");


        // 以此 os.name 来做跨平台处理的操作
        System.out.println(System.getProperty("os.name")); // Windows 10


        // Properties 是 HashTable 的子类，也就是 Map 接口的子类，所以能用 Map 接口公共的方法
        Properties properties = System.getProperties();
        for (Object obj : properties.keySet()) {
            Object value = properties.get(obj);
            System.out.println(obj + " === " + value);
        }


        // Properties 是 HashTable 的子类，是与流相结合的集合，下面也可以输出到控制台
        properties.list(System.out);


        // 在 jvm 启动的时候 setProperty，可以用 java -D<key>=<value> 程序字节码


        // 打印当前时间的毫秒数
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTimeInMillis());


        // 打印本机默认编码
        System.out.println("本机的默认编码 ===== " + System.getProperty("file.encoding"));
        System.out.println("本机的默认编码 ===== " + Charset.defaultCharset().name());


        // 直接输出对象，和输出对象的 toString 的区别
        Object o = new Object();
        System.out.println(o); // 用了 String.valueOf 可以避免空指针的问题
        System.out.println(o.toString()); // o 可能空指针


        // System.out 是标准输出流；
        // 不是直接输出，会将输出信息先缓存，然后按顺序输出
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        // System.err 是标准错误输出流；
        // 只要执行立即输出，不会缓存，所以 5 可能混在 1 2 3 4 里面
        // 在调试程序的时候可以用，有红色提示
        System.err.println(5);


        // 毫秒值
        System.out.println(System.currentTimeMillis());
        // 纳秒值
        System.out.println(System.nanoTime());
    }

}
