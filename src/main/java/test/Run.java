package test;

public class Run {

	public static void main(String[] args) {
		Grid grid = new Grid("bananas", 4, 2, 2);
		for(Ufo ufo : grid.getUfo()) {
			System.out.println(ufo.getxCoord() + " " + ufo.getyCoord());
		}

	}

}
