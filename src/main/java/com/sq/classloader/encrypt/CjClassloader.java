package com.sq.classloader.encrypt;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-09-05
 * Time : 15:54
 * Version :1.0
 */
public class CjClassloader extends ClassLoader {

    String classpath;

    Map<String, Class> loadedClassPool = new HashMap<String, Class>();

    public CjClassloader(String classpath) {
        this.classpath = classpath;
    }


    @SuppressWarnings("unchecked")
    @Override
    public synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class claz = null;
        if (loadedClassPool.containsKey(name)) {
            claz = this.loadedClassPool.get(name);
        } else {

            try {
                if (claz == null) {
                    claz = super.loadClass(name, false);
                    if (claz != null) {
                        System.out.println("系统加载成功：" + name);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("系统无法加载：" + name);
            }

            try {
                if (claz == null) {
                    claz = loadByCjClassLoader(name);
                    if (claz != null) {
                        System.out.println("自定义加载成功：" + name);
                    }
                }
            } catch (Exception e) {
                System.out.println("自定义无法加载：" + name);
            }

            if (claz != null) {
                this.loadedClassPool.put(name, claz);
            }

        }
        if (resolve) {
            resolveClass(claz);
        }
        return claz;
    }

    /**
     *
     * 解密加载
     *
     *
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    private Class loadByCjClassLoader(String name) {
        Class claz = null;
        try {
//            byte[] rawData = loadClassData(name);
//            if (rawData != null) {
//                byte[] classData = decrypt(getReverseCypher(this.cjcipher.getKeycode()), rawData);
//                classData = CipherUtil.filter(classData, this.cjcipher);
//
//                claz = defineClass(name, classData, 0, classData.length);
//            }
        } catch (Exception e) {
            claz = null;
        }
        return claz;
    }

}