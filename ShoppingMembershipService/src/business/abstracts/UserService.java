package business.abstracts;

import entities.concretes.User;

public interface UserService {
	public void register(User user);
	public void login(User user);
	public void delete(User user);
	User getByEmail(String email);

}
