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

		Long id = (Long) sessionFactory.getCurrentSession().save(new Note(ufo, note));

//		Query query = sessionFactory.getCurrentSession().createQuery("Select 1 from Note where id=NOTE_ENTRY('TBL_NOTES')");
//		
//		List result = query.getResultList();
//		
//		System.out.println(result);
//		System.out.println("----\n" + result.toString());

		TypedQuery<Note> query = sessionFactory.getCurrentSession().createQuery("SELECT entry FROM Note");

		List<Note> users = query.getResultList();
		System.out.println(users);

		if (id != null) {
			return true;
		}

		return false;
	}

}
