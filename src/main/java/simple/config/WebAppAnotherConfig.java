package simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import simple.service.BarService;
import simple.service.FooService;

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
public class WebAppAnotherConfig  {

	@Bean
	public BarService getBarService() {
		return new BarService();
	}

	@Bean
	public FooService getSimpleService() {
		return new FooService();
	}
}
