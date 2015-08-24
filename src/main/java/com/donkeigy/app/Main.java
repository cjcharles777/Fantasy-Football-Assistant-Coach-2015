package com.donkeigy.app;

/**
 * Created by cedric on 8/24/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.donkeigy.servers.ActualEmbeddedRunner;
import com.donkeigy.servers.JettyEmbeddedRunner;
import com.donkeigy.servers.TomcatEmbeddedRunner;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;


public class Main {
    public static void main(final String[] args) throws IOException,
            LifecycleException, ServletException {
        System.out
                .println("### STARTING EMBEDDED WEB CONTAINER\nPlease select your container...\n1) Jetty\n2) Tomcat\n");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
                System.in));
        String input = bufferRead.readLine();
        if ("1".equals(input)) {
            System.out.println("Starting Jetty ..");
            new JettyEmbeddedRunner().startServer();
        } else if ("2".equals(input)) {
            System.out.println("Starting Tomcat ..");
            new TomcatEmbeddedRunner().startServer();
        }
            else if ("3".equals(input)) {
                System.out.println("Starting Tomcat ..");
                new ActualEmbeddedRunner().startServer();
        } else {
            System.out.println("Nothing selected .. quitting application...");
        }

    }
}

