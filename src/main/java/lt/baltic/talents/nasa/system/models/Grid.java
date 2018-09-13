package lt.baltic.talents.nasa.system.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class Grid {

	private int xAxis;
	private int yAxis;
	private String seed;
	private int ufoCount;
	private List<Ufo> ufo;
	private List<Sattelite> sat;
	private static Grid grid;
	public Grid(String seed, int ufoCount, int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.ufo = generateUfo(seed, ufoCount, xAxis, yAxis);
		this.seed = seed;
		this.ufoCount = ufoCount;
	}
	
	public static String getNearestUfo(String satID, List<Ufo> ufoList) {
		Map<Double, Ufo> calcList = new TreeMap<>();
		String[] satCoord = satID.split("_");
		int xAxis = Integer.parseInt(satCoord[0]);
		int yAxis = Integer.parseInt(satCoord[1]);
		
		System.out.println("AJAX VALUES: " + xAxis + " " + yAxis);
		
		for(Ufo u: ufoList) {
			double distance = 0;
			double xDif = Math.pow((u.getxCoord()-xAxis), 2);
			double yDif = Math.pow((u.getyCoord()-yAxis), 2);
			distance = Math.sqrt(xDif+yDif);
			calcList.put(distance, u);			
		}
		
		Comparator<Double> maxDoubleVal = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				
				return Double.compare(o1, o2);
			}			
		};
		for(Double d: calcList.keySet()) {
			System.out.println(d);
		}
		System.out.println("Min distance: "+Collections.min(calcList.keySet(), maxDoubleVal));
		Ufo nearestUfo = calcList.get(Collections.min(calcList.keySet(), maxDoubleVal));
		String response = "#" + nearestUfo.getxCoord() + "_" + nearestUfo.getyCoord();
		System.out.println(response);
		return response;
	}

	public static void setGrid(Grid genGrid) {
		grid = genGrid;
	}
	
	public static Grid getGrid() {
		return grid;
	}
	
	public List<Sattelite> getSat() {
		return sat;
	}

	public void setSat(List<Sattelite> sat) {
		this.sat = sat;
	}

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public String getSeed() {
		return seed;
	}

	public int getUfoCount() {
		return ufoCount;
	}

	public List<Ufo> getUfo() {
		return ufo;
	}

	private List<Ufo> generateUfo(String seed, int ufoCount, int xAxis, int yAxis) {
		Random r = new Random();
		r.setSeed(seed.chars().asLongStream().reduce(0, (a, b) -> a + b));
		List<Ufo> ufoL = new ArrayList<>();
		for (int i = 0; i < ufoCount; i++) {
			Ufo ufoN = new Ufo(r.nextInt(xAxis), r.nextInt(yAxis), false);
			if ( ufoL.stream().anyMatch(u -> u.equals(ufoN)) ) {
				i--;
			} else {
				ufoL.add(ufoN);
			}
		}
		return ufoL;
	}

}
