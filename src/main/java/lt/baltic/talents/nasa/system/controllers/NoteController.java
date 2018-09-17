package lt.baltic.talents.nasa.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import lt.baltic.talents.nasa.system.services.UfoService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private UfoService ufoService;
	
	@GetMapping()
	public String start(@ModelAttribute("note") String note, Model model) {
		System.out.println(note);
		
		return "index/index";
		
	}

}
