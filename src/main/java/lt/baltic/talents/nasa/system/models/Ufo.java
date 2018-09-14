package lt.baltic.talents.nasa.system.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_UFOS")
public class Ufo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UFO_ID")
	private Long id;

	@Column(name = "UFO_XCOORD")
	private int xCoord;

	@Column(name = "UFO_YCOORD")
	private int yCoord;

	@Column(name = "UFO_DISC")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public boolean equals(Ufo obj) {
		if (xCoord == obj.getxCoord() && yCoord == obj.getyCoord()) {
			return true;
		} else {
			return false;
		}
	}

}
