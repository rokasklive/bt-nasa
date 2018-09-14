package lt.baltic.talents.nasa.system.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.baltic.talents.nasa.system.models.Note;
import lt.baltic.talents.nasa.system.models.Ufo;

@Repository
public class UfoDaoImpl implements UfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean note(Ufo ufo, String note) {
		
		sessionFactory.getCurrentSession().save(new Note(ufo, note));
		
		return true;
	}

}
