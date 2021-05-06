package core.membershipService;

import entities.concretes.User;
import googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {

	private GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

}
