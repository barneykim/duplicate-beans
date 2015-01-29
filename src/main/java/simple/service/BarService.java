/**
 *
 */
package simple.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.xml.internal.ws.developer.Serialization;

/**
 * @author barney
 *
 */
@Serialization
public class BarService {

	private final Log logger = LogFactory.getLog(getClass());

	public String getBar() {
		logger.debug("Called");
		return "Hello Bar";
	}
}
