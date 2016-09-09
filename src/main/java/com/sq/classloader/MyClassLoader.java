package com.sq.classloader;

import java.io.*;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-09-09
 * Time : 15:34
 * Version :1.0
 * TODO:
 */
public class MyClassLoader extends ClassLoader {

    /**
     * 因为类加载器是基于委托机制，所以我们只需要重写findClass方法。
     * 它会自动向父类加载器委托，如果父类没有找到，就会再去调用我们重写的findClass方法加载
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //需要加载的.class字节码的位置
            String classPath = "E:/ClassTest.class";

            FileInputStream fis = new FileInputStream(classPath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis, bos);
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private static void cypher(InputStream in, OutputStream out) throws IOException {
        int b = -1;
        while ((b = in.read()) != -1) {
            out.write(b ^ 0xff);
        }
    }
}