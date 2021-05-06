package business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		
		String invalidEmail="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern=Pattern.compile(invalidEmail);
		Matcher matcher=pattern.matcher(user.getEmail());
		if (matcher.matches()) {
			System.out.println("Ge�erli bir email adresi giriniz");
		}
		
		if(user.getPassword().length()>6) {
			System.out.println("En az 6 karakterli bir �ifre olu�turunuz.");
		}
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2) {
			System.out.println("En az 2 karakterli bir isim ve soyisim girmeniz gerekmektedir.");
		}
		
		if (user.getEmail()==null && user.getPassword()==null && user.getFirstName()==null & user.getLastName()==null) {
			System.out.println("Ad, soyad, email ve parola bo� b�rak�lamamaktad�r.");
		}
		
		if(userDao.getByEmail(user.getEmail())!=null) {
			System.out.println("Bu eposta adresi kay�tl�d�r.");
		}

		Scanner scanner=new Scanner(System.in);
		System.out.println("Epostay� 9 tu�una basarak onaylay�n�z.");
		int confirm=scanner.nextInt();
		if (confirm!=9) {
			System.out.println("Do�rulama ba�ar�s�z");
			return;
		}
		
		userDao.register(user);
		
	}

	@Override
	public void login(User user) {
		if (user.getEmail()==null && user.getPassword()==null ) {
			System.out.println("Email ve �ifreyi giriniz");
			return;
		}
		System.out.println("Ba�ar�yla giri� yapt�n�z");
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	

}
