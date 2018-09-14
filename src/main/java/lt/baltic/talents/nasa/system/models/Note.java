package lt.baltic.talents.nasa.system.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_NOTES")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTE_ID")
	private Long id;

	@Column(name = "NOTE_UFO")
	private Long ufoId;

	@Column(name = "NOTE_ENTRY")
	private String entry;

	public Note(Ufo ufo, String note) {
		this.ufoId = ufo.getId();
		this.entry = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntry() {
		return entry;
	}

	public void setNote(String note) {
		this.entry = note;
	}

	public Long getUfoId() {
		return ufoId;
	}

	public void setUfoId(Long ufoId) {
		this.ufoId = ufoId;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

}
