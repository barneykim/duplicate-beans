package simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import simple.service.BarService;

/**
 *
 * @author barney
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "simple", useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(Controller.class)
}, excludeFilters = {
		@ComponentScan.Filter(Configuration.class)
})
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BarService getBarService() {
		return new BarService();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
