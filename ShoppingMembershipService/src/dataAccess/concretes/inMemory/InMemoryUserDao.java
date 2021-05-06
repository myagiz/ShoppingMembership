package dataAccess.concretes.inMemory;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private ArrayList<User> users;
	
	public InMemoryUserDao(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public void register(User user) {
		users.add(user);
		System.out.println("Kullan�c� eklendi : " + user.getEmail());
		
	}

	@Override
	public void login(User user) {
		System.out.println("Giri� ba�ar�l� : " + user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Kullan�c� silindi : " + user.getEmail());
		
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}
	
}

	
	

