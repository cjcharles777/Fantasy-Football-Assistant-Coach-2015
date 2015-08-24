package com.donkeigy.servers;

/**
 * Created by cedric on 8/24/15.
 */

import com.donkeigy.servlets.DatePrintServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;


public class ActualEmbeddedRunner {
    public void startServer() throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(".");

        Context ctx = tomcat.addWebapp("/examples", "examples");
        Tomcat.addServlet(ctx, "helloWorldServlet", "com.donkeigy.servlets.HelloWorldServlet");

        ctx.addServletMapping("/helloworld", "helloWorldServlet");

        tomcat.start();
        tomcat.getServer().await();
    }}
