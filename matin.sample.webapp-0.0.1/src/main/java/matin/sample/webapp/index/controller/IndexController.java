package matin.sample.webapp.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 메인 화면 view Controller
 *
 * @author matin
 */
@Controller
public class IndexController {

	/**
	 * index page view controller
	 *
	 * @return hello message
	 */
	@ResponseBody
	@RequestMapping(value = "")
	public String index() {

		System.out.println("????????????????");
		return "Hello";
	}

}
