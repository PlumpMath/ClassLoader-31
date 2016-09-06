package com.sq.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-25
 * Time : 18:50
 * Version :1.0
 */
public class NetworkClassLoader extends ClassLoader {

    //定义文件所在目录
    private String rootUrl;

    public NetworkClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }


    public Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] b = null;

        try {

            b = loadClassData(GetClassName(name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return defineClass(name, b, 0, b.length);

    }

    @Override

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if(name.startsWith("java.")){try {

            return super.loadClass(name, false);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        }

        byte[] b = null;

        try {

            b = loadClassData(this.GetClassName(name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return defineClass(name, b, 0, b.length);

    }

    private byte[] loadClassData(String filepath) throws Exception {

        int n =0;

        BufferedInputStream br = new BufferedInputStream(

                new FileInputStream(

                        new File(filepath)));

        ByteArrayOutputStream bos= new ByteArrayOutputStream();

        while((n=br.read())!=-1){

            bos.write(n);

        }

        br.close();

        return bos.toByteArray();

    }

    private  String GetClassName(String name){

        return rootUrl+name.replace('.','/')+".class";

    }

}
