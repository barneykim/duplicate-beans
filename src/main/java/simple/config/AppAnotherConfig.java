package simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import simple.service.FooService;

/**
 *
 * @author barney
 */
@Configuration
@ComponentScan(basePackages = { "simple" }, excludeFilters = {
		@ComponentScan.Filter(Configuration.class),
		@ComponentScan.Filter(Controller.class)
})
public class AppAnotherConfig {

	@Bean
	public FooService getSimpleService() {
		return new FooService();
	}
}
