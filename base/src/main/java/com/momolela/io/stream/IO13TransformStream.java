package com.momolela.io.stream;

import java.io.*;

public class IO13TransformStream {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // System.setIn(new FileInputStream("test.txt")); // 可以通过 System.setIn 改变 System.in 的标准输入对象
            // System.in 的类型是 InputStream ，是一个字节流，通过 InputStreamReader 变成了一个字符流，然后再通过 BufferedReader 的包装，可以使用 readLine() 和 newLine() 的功能
            bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // InputStreamReader 字节流通往字符流的桥梁

            // 将输出从控制台改为文件
            System.setOut(new PrintStream("test-system-out.txt"));
            // System.out 的类型是 PrintStream 最终继承自 OutputStream ，是一个字节流，通过 OutputStreamWriter 变成了一个字符流，然后再通过 BufferedWriter 的包装
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8")); // 在使用转换流的时候，可以指定编码，OutputStreamWriter 字符流通往字节流的桥梁
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if ("over".equals(line)) {
                    break;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush(); // 字符流需要 flush 刷入
            }
        } catch (IOException e) {
            try {
                // 日志异常系统，就可以用这样的方式进行输出
                e.printStackTrace(new PrintStream("test-exception.log"));
            } catch (FileNotFoundException fileNotFoundException) {
                throw new RuntimeException("异常日志文件写出失败");
            }
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
