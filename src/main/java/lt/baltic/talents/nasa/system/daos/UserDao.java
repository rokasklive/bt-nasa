package lt.baltic.talents.nasa.system.daos;

import lt.baltic.talents.nasa.system.models.User;

public interface UserDao {
	
	boolean login(User user);
	
	boolean create(User user);

}
