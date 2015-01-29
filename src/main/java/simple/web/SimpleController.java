package simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import simple.service.BarService;
import simple.service.FooService;

/**
 *
 * @author barney
 */
@Controller
public class SimpleController {

	@Autowired
	private FooService fooService;

	@Autowired
	private BarService barService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String home() {
		StringBuilder sb = new StringBuilder();
		sb.append(fooService.getFoo()).append(",").append(barService.getBar());
		return sb.toString();
	}
}
