package it.testweb;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestWebApplication extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
	SpringApplication.run(TestWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
	return application.sources(TestWebApplication.class);
    }

    @Bean
    public FacesServlet facesServlet()
    {
	return new FacesServlet();
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration()
    {
	ServletRegistrationBean registration = new ServletRegistrationBean(facesServlet(), "*.xhtml");
	return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer()
    {
	return servletContext -> {
	    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.THEME", "bootstrap");
	    servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
	    servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.UPLOADER", "commons");
	    servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");

	};
    }

}
