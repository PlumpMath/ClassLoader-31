package com.sq.classloader.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright© JD.COM All Right Reserved
 * Created by IntelliJ IDEA
 * Author : SongQian
 * Date : 2016-08-26
 * Time : 14:56
 * Version :1.0
 */
public class ClassLoaderServletTest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ClassLoader loader = this.getClass().getClassLoader();
        while(loader != null) {
            out.write(loader.getClass().getCanonicalName()+"<br/>");
            loader = loader.getParent();
        }
        out.write(String.valueOf(loader));
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}