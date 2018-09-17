package lt.baltic.talents.nasa.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import lt.baltic.talents.nasa.system.models.Ufo;
import lt.baltic.talents.nasa.system.services.UfoService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private UfoService ufoService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseStatus(value = HttpStatus.OK)
//	public void start(Model model,
//			@RequestParam(value = "notes", required = true) String note) {
//		System.out.println(note);
//		
//
//	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String noteRequest(Model model, 
			@RequestParam(value = "text", required = true) String text,
			@RequestParam(value = "coord", required = true) String coord) {
		
		Gson gson = new Gson();
		
		String note = gson.fromJson(text, String.class);
		String cord = gson.fromJson(coord, String.class);
		System.out.println("ajax-" + note + "  " + cord);
		
		ufoService.note(new Ufo(Integer.parseInt(cord.split("_")[0]), Integer.parseInt(cord.split("_")[1]), true), note);
		
		return "success";
	}
	
}
