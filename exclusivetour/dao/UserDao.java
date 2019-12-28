package exclusivetour.dao;

import java.util.List;

import exclusivetour.models.UserData;

public interface UserDao {
	UserData getUserById(int id);
	
	List<UserData> getAllUsers();
	List<UserData> getClient();
	
	boolean updateUser(int id, String login, String password, String firstName, 
			String lastName, int age, String email, long phone, int roleId);
	
	boolean setUser(String login,  String password, String firstName, 
			String lastName, int age, String email, long phone);		
	
}
