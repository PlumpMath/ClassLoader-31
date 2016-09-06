package com.sq.classloader;

import java.util.Date;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-25
 * Time : 19:34
 * Version :1.0
 */
public class NewworkClassLoaderTest {

    public static void main(String[] args) {
        try {
            //测试加载网络中的class文件
            String rootUrl = "D:/IdeaProjects/ClassLoader/target/classes/";
            String className = "com.sq.classloader.NetClassLoaderSimple";
            NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
            NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
            Class<?> clazz1 = ncl1.loadClass(className);
            Class<?> clazz2 = ncl2.loadClass(className);
            Object obj1 = clazz1.newInstance();
            Object obj2 = clazz2.newInstance();
            Date date1=new Date();
            Date date2=new Date();
            //比较他们是否是同一个Class类的实例
            System.out.println(date1.getClass().equals(date2.getClass()));
            System.out.println(obj1.getClass().equals(obj2.getClass()));
//            clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}