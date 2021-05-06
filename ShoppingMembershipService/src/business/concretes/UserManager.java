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
			System.out.println("Geçerli bir email adresi giriniz");
		}
		
		if(user.getPassword().length()>6) {
			System.out.println("En az 6 karakterli bir þifre oluþturunuz.");
		}
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2) {
			System.out.println("En az 2 karakterli bir isim ve soyisim girmeniz gerekmektedir.");
		}
		
		if (user.getEmail()==null && user.getPassword()==null && user.getFirstName()==null & user.getLastName()==null) {
			System.out.println("Ad, soyad, email ve parola boþ býrakýlamamaktadýr.");
		}
		
		if(userDao.getByEmail(user.getEmail())!=null) {
			System.out.println("Bu eposta adresi kayýtlýdýr.");
		}

		Scanner scanner=new Scanner(System.in);
		System.out.println("Epostayý 9 tuþuna basarak onaylayýnýz.");
		int confirm=scanner.nextInt();
		if (confirm!=9) {
			System.out.println("Doðrulama baþarýsýz");
			return;
		}
		
		userDao.register(user);
		
	}

	@Override
	public void login(User user) {
		if (user.getEmail()==null && user.getPassword()==null ) {
			System.out.println("Email ve þifreyi giriniz");
			return;
		}
		System.out.println("Baþarýyla giriþ yaptýnýz");
		
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
