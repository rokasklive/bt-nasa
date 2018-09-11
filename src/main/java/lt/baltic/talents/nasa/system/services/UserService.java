package lt.baltic.talents.nasa.system.services;

import lt.baltic.talents.nasa.system.models.User;

public interface UserService {

	boolean login(User user);
	
	boolean create(User user);

}
