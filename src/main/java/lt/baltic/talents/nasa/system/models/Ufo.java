package lt.baltic.talents.nasa.system.models;

public class Ufo {

	private int xCoord;
	private int yCoord;
	private boolean discovered;

	public Ufo(int x, int y, boolean disc) {
		this.xCoord = x;
		this.yCoord = y;
		this.discovered = disc;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public boolean equals(Ufo obj) {
		if( xCoord == obj.getxCoord() && yCoord == obj.getyCoord() ) {
			return true;
		} else {
			return false;
		}
	}

}
