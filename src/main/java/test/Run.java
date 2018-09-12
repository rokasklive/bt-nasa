package test;

import lt.baltic.talents.nasa.system.models.Grid;
import lt.baltic.talents.nasa.system.models.Ufo;

public class Run {

	public static void main(String[] args) {
		Grid grid = new Grid("bananas", 4, 2, 2);
		for(Ufo ufo : grid.getUfo()) {
			System.out.println(ufo.getxCoord() + " " + ufo.getyCoord());
		}

	}

}
