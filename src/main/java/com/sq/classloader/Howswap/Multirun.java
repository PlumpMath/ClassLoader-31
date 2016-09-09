package com.sq.classloader.Howswap;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-30
 * Time : 14:52
 * Version :1.0
 */
/*
 * 每隔500ms运行一次，不断加载class
 */
public class Multirun implements Runnable {
    public void run() {
        try {
            while (true) {
                // 每次都创建出一个新的类加载器
                // class需要放在自己package名字的文件夹下
                String url = System.getProperty("user.dir") + "/target/classes";// "/lib/yerasel/GetPI.jar";

                HowswapCL cl = new HowswapCL(url, new String[]{"com.sq.classloader.Howswap.GetPrint"});
                Class cls = cl.loadClass("com.sq.classloader.Howswap.GetPrint");

//                System.out.println("Runnable" + GetPrint.class.getClassLoader().toString());
//                GetPrint getPrint = (GetPrint) cls.newInstance();
//                getPrint.Output();

                System.out.println("class:" + Multirun.class.getClassLoader());
                System.out.println("Runnable:" + IGetPrint.class.getClassLoader().toString());
//                IGetPrint getPrint = (IGetPrint) cls.newInstance();
                IGetPrint getPrint ;
                getPrint = (IGetPrint) cls.newInstance();
                getPrint.Output();

//
//                Object foo = cls.newInstance();
//                System.out.println(foo.getClass().getClassLoader());
//                // 被调用函数的参数
//                Method m = foo.getClass().getMethod("Output", new Class[] {});
//                m.invoke(foo, new Object[] {});
                Thread.sleep(500);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}