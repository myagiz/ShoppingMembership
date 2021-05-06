package googleAuth;

import entities.concretes.User;

public class GoogleAuthManager {
	public void login (User user) {
		System.out.println("Google üyeliðiniz ile giriþ yapýldý.");
	}
	
	public void register(User user) {
		System.out.println("Google üyeliðiniz ile kayýt baþarýyla tamamlandý.");
	}

}
