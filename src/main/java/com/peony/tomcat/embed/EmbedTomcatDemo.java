package com.peony.tomcat.embed;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmbedTomcatDemo {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(7777);
        tomcat.setBaseDir("D:\\tmp\\tomcat");
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "/book";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet", new HomeServlet());
        context.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }

    public static class HomeServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("request scheme: " + req.getScheme());
            resp.getWriter().print("hello tomcat");
        }
    }
}
