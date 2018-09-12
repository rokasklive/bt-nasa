package lt.baltic.talents.nasa.system.models;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.Entity;

@Entity
public class Grid {

	private int xAxis;
	private int yAxis;
	private String seed;
	private int ufoCount;
	private List<Ufo> ufo;
	private List<Sattelite> sat;

	public Grid(String seed, int ufoCount, int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.ufo = generateUfo(seed, ufoCount, xAxis, yAxis);
		this.seed = seed;
		this.ufoCount = ufoCount;
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
