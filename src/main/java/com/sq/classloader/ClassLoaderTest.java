package com.sq.classloader;

import java.util.Date;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-24
 * Time : 15:58
 * Version :1.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//e.g.1委托机制
//        ClassLoader loader = ClassLoaderTest.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器
//        while(loader != null) {
//            System.out.println(loader);
//            loader = loader.getParent();    //获得父类加载器的引用
//        }
//        System.out.println(loader);

//        数组的类加载器
//        String [] str= new String[3];
//        ClassLoaderTest [] test = new ClassLoaderTest[2];
//        System.out.println( "Str-------:"+str.getClass().getClassLoader());
//        System.out.println( "test-------:"+test.getClass().getClassLoader());

//
//        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }
//


//e.g.2 Java class loader 树
//        System.out.println("sun.boot.class.path:" + System.getProperty("sun.boot.class.path"));
//
//        System.out.println("java.ext.dirs:" + System.getProperty("java.ext.dirs"));
//
//        System.out.println("java.class.path:" +System.getProperty("java.class.path"));


//e.g.3 线程上下文加载器
//        String rootUrl = "D:/IdeaProjects/ClassLoader/target/classes/";
//        String className = "com.sq.classloader.NetClassLoaderSimple";
//        NetworkClassLoader ncl = new NetworkClassLoader(rootUrl);
//
//        Thread.currentThread().setContextClassLoader(ncl);
////
//        System.out.println("oClassLoader:" +ClassLoaderTest.class.getClassLoader().toString());
////
//        ClassLoader cl = Thread.currentThread().getContextClassLoader();//ClassLoader.getSystemClassLoader()
//
//        System.out.println("getContextClassLoader:" +cl.toString());
//
//        System.out.println("getContextClassLoader.parent:" +cl.getParent().toString());
//
//        System.out.println("getContextClassLoader.parent2:" +cl.getParent().getParent());
////
////
//        System.out.println("getSystemClassLoader:" +ClassLoader.getSystemClassLoader().toString());


//e.g.4 jvm识别一个类

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

//e.g.5 Java核心库的保护
//        NURL url;
//        url = new NURL("http://www.baidu.com");
//        System.out.println(url.toString());

    }
}
