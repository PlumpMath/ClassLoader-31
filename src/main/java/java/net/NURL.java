package java.net;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-29
 * Time : 15:53
 * Version :1.0
 */
public class NURL {
    private String path;

    public NURL(String path) {
        this.path = path;
    }

    public String toString() {
        return this.path + " new Path";
    }
}