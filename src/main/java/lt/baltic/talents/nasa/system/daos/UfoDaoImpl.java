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
		TypedQuery<Note> query = sessionFactory.getCurrentSession()
				.createQuery("from User where ufo = ?1 and note = ?2");

		query.setParameter(1, ufo);
		query.setParameter(2, note);

		List<Note> notes = query.getResultList();

		if (notes != null && notes.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

}
