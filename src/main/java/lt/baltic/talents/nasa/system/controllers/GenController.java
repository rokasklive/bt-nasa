package lt.baltic.talents.nasa.system.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lt.baltic.talents.nasa.system.models.Grid;
import lt.baltic.talents.nasa.system.models.Ufo;

@Controller
@RequestMapping("/gen")
public class GenController {
			
	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model,
			@RequestParam(value = "seed", required = true) String genSeed,
			@RequestParam(value = "objs", required = true) int genObjs,
			@RequestParam(value = "axisx", required = true) int genAxisx,
			@RequestParam(value = "axisy", required = true) int genAxisy) {
		
		
		Grid grid = new Grid(genSeed, genObjs, genAxisx, genAxisy);
		
		Grid.setGrid(grid);

		String gridSeed = grid.getSeed();
		model.addAttribute("gridSeed", gridSeed);
		
		int gridAxisx = grid.getxAxis();
		model.addAttribute("gridAxisx", gridAxisx);
		
		int gridAxisy = grid.getyAxis();
		model.addAttribute("gridAxisy", gridAxisy);
		
		List<Ufo> list = grid.getUfo();
		
		for(Ufo u: list) {
			System.out.println(u.getxCoord() + " " + u.getyCoord());
		}
		
		return "centre/scanner";
	}

}