package exclusivetour.testjdbc;

import exclusivetour.dao.impl.DefaultUserDao;
import exclusivetour.models.UserData;
import exclusivetour.dao.UserDao;

import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDao userDao = DefaultUserDao.getInstance();
		UserData users = userDao.getUserById(2);
		System.out.println(users);		

	}
}
