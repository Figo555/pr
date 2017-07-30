package pl.apka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.apka.model.User;
import pl.apka.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if(error != null) {
			model.addAttribute("error", "Your username and password is invalid");
		}
		if(logout != null) {
			model.addAttribute("message", "You have been logged out");
		}
		return "login";
	}

	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
		model.addAttribute("sections", userService.sectionList());
		return "user/form";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("userForm", userService.findOne(id));
		model.addAttribute("roles", userService.roleList());
		model.addAttribute("sections", userService.sectionList());
		return "user/form";
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addUser(@ModelAttribute User user, Model model) {
		String message = "";
		if(user.getId() == null) {
			message = "added";
		} else {
			message = "update";
		}
		model.addAttribute("message", userService.addUser(user).getFirstName()+ message + " successfully");
		return "message";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable Long id, Model model) {
		model.addAttribute("userForm",  userService.findOne(id));
		model.addAttribute("roles", userService.roleList());
		model.addAttribute("sections", userService.sectionList());
		return userService.deleteUser(id);
}
	
	@GetMapping("/list/{id}")
	public User findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public String userList(Model model) {
		model.addAttribute("users", userService.userList());
		return "/user/list";
	}
	
	
}
