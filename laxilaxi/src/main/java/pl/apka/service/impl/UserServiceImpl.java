package pl.apka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.apka.model.Role;
import pl.apka.model.Section;
import pl.apka.model.User;
import pl.apka.repository.RoleRepository;
import pl.apka.repository.SectionRepository;
import pl.apka.repository.UserRepository;
import pl.apka.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private SectionRepository sectionRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SectionRepository sectionRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.sectionRepository = sectionRepository;
	}


	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User addUser(User user) {
		user.setRole(roleRepository.findOne(user.getRole().getId()));
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.delete(id);
		return "Użytkownik usunięty według woli.";
	}

	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}


	@Override
	public List<Section> sectionList() {
		return sectionRepository.findAll();
	}
	
}
