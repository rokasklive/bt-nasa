package lt.baltic.talents.nasa.system.controllers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lt.baltic.talents.nasa.system.helpers.MessageHelper;

@Controller
public class BaseController {
	
	@Autowired
	private MessageHelper helper;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String start(@RequestParam(value = "name", required = false) String name, Model model) {
		LocalDateTime date = LocalDateTime.now();
		model.addAttribute("now", Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));

		String operatingSystem = System.getProperty("os.name");
		model.addAttribute("operatingSystem", operatingSystem);
		
		String javaVersion = System.getProperty("java.version");
		model.addAttribute("javaVersion", javaVersion);
		
		System.out.println(helper.getMessage("message.hello"));
		
		return "hello/base";
	}

}
