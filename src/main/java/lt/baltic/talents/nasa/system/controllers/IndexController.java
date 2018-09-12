package lt.baltic.talents.nasa.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lt.baltic.talents.nasa.system.models.Grid;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(Model model)  {
		model.addAttribute("ufo", new Grid());
		return "index/index";
	}
	
	@RequestMapping("create")
	public String ufoStart(@ModelAttribute("ufo") Grid grid ) {
		
		return "index/nasa";
	}

}
