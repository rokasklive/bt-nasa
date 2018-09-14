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
	private Ufo ufo;
	
	@Column(name = "NOTE_NOTE")
	private String note;
	
	public Note(Ufo ufo, String note) {
		this.ufo = ufo;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ufo getUfo() {
		return ufo;
	}

	public void setUfo(Ufo ufo) {
		this.ufo = ufo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
