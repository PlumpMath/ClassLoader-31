package com.sq.classloader;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-24
 * Time : 15:58
 * Version :1.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

//eg.1委托机制
//        ClassLoader loader = ClassLoaderTest.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器
//        while(loader != null) {
//            System.out.println(loader);
//            loader = loader.getParent();    //获得父类加载器的引用
//        }
//        System.out.println(loader);

//
//        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }
//

//Java class loader 树
        System.out.println("sun.boot.class.path:" + System.getProperty("sun.boot.class.path"));

        System.out.println("java.ext.dirs:" + System.getProperty("java.ext.dirs"));

        System.out.println("java.class.path:" +System.getProperty("java.class.path"));
//线程上下文加载器
//        String rootUrl = "D:/IdeaProjects/ClassLoader/target/classes/";
//        String className = "com.sq.classloader.NetClassLoaderSimple";
//        NetworkClassLoader ncl = new NetworkClassLoader(rootUrl);
//        Thread.currentThread().setContextClassLoader(ncl);
//        ClassLoader cl = Thread.currentThread().getContextClassLoader();//ClassLoader.getSystemClassLoader()
//
//        System.out.println("getContextClassLoader:" +cl.toString());
//
//        System.out.println("getContextClassLoader.parent:" +cl.getParent().toString());
//
//        System.out.println("getContextClassLoader.parent2:" +cl.getParent().getParent());



//jvm识别一个类
//        Class clazz1=new TestClassLoader().loadClass("com.tao.test.ClassTest");
//        Class clazz2=new TestClassLoader().loadClass("com.tao.test.ClassTest");
//        //这是由不同的类加载器加载的类生成的对象
//        InterfaceTest classTest1=(InterfaceTest) clazz1.newInstance();
//        InterfaceTest classTest2=(InterfaceTest) clazz2.newInstance();
//        //这是Date对象，是由同一个类加载器加载的
//        Date date1=new Date();
//        Date date2=new Date();
//        //比较他们是否是同一个Class类的实例
//        System.out.println(date1.getClass().equals(date2.getClass()));
//        System.out.println(classTest1.getClass().equals(classTest2.getClass()));

//Java核心库的保护
//        NURL url = new NURL("http://www.baidu.com");
//        System.out.println(url.toString());

    }
}
