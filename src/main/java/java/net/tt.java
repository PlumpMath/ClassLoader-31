package java.net;

import java.io.*;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-09-05
 * Time : 16:07
 * Version :1.0

 */
public class tt {


public  void formi() throws IOException {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(""));
    byte[] data = new byte[bis.available()];
    bis.read(data);
    bis.close();
    for(int i = 0; i < data.length; i++){
        data[i] =(byte)( data[i] + 1);
    }
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(""));
    bos.write(data);
    bos.close();
}
}
