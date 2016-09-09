package com.sq.classloader.Howswap;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-30
 * Time : 15:35
 * Version :1.0
 */
//public class GetPrint
public class GetPrint implements IGetPrint
{
    // 本热部署实验中，上面的Darts函数没有用到，请忽略
    public  void Output() {
        System.out.println("implements:"+this.getClass().getClassLoader().toString());
        System.out.println("Output");
    }
}