package lt.baltic.talents.nasa.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.baltic.talents.nasa.system.daos.UfoDao;
import lt.baltic.talents.nasa.system.models.Ufo;

@Service
public class UfoServiceImpl implements UfoService {
	
	@Autowired
	private UfoDao ufoDao;

	@Transactional
	@Override
	public boolean note(Ufo ufo, String note) {
		if(ufo != null && note != null) {
			return ufoDao.note(ufo, note);
		} else {
			return false;			
		}
	}

}
