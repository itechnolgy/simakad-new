package com.simakad.cms.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by HighDream on 9/11/2016.
 */
public class ServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.simakad.cms");
        context.scan("com.simakad.service");

        sc.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic registration = sc.addServlet("dispatcher", new DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}