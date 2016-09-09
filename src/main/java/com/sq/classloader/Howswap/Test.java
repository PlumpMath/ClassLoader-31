package com.sq.classloader.Howswap;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-30
 * Time : 14:49
 * Version :1.0
 */
public class Test {

    public static void main(String[] args) {

        // 热部署测试代码
        Thread t = new Thread(new Multirun());
        t.start();
    }
}
