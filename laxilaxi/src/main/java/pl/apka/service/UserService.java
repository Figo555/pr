package pl.apka.service;

import java.util.List;

import pl.apka.model.Role;
import pl.apka.model.Section;
import pl.apka.model.User;

public interface UserService {

	List<User> userList();
	
	User findOne(Long id);
	
	User addUser(User user);
	
	String deleteUser(Long id);
	
	List<Role> roleList();
	
	List<Section> sectionList();
}
