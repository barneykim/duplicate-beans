package simple.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.Log4jWebConfigurer;

/**
 * @author barney
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		rootContext.register(AppAnotherConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.addListener(Log4jConfigListener.class);
		servletContext.setInitParameter(Log4jWebConfigurer.CONFIG_LOCATION_PARAM, "classpath:log4j.xml");

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(WebAppConfig.class);
		dispatcherContext.register(WebAppAnotherConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
