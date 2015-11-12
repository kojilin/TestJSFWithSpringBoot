package com.example;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class JSFInit implements ServletContextAware, ServletContextInitializer {
    @Bean
    public ServletRegistrationBean facesServlet() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "*.jsf");
        registration.setName("FacesServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
    }
}
