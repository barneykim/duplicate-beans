package simple.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author barney
 */
@Service
public class FooService {

	private final Log logger = LogFactory.getLog(getClass());

	public String getFoo() {
		logger.debug("Called");
		return "Hello Foo";
	}
}
