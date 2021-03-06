package lt.baltic.talents.nasa.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lt.baltic.talents.nasa.system.models.Grid;

@Controller
@RequestMapping("/findObj")
public class AjaxController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String start(Model model, @RequestParam(value = "coord", required = true) String request) {

		System.out.println("ajax-" + request);
		Grid grid = Grid.getGrid();
		String response = Grid.getNearestUfo(request, grid.getUfo());

		System.out.println(response);
		return response;
	}
	


}
