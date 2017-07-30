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

import pl.apka.model.Section;
import pl.apka.service.SectionService;
import pl.apka.service.UserService;

@Controller
@RequestMapping("/section")
public class SectionController {

	private SectionService sectionService;
	private UserService userService;
	
	@Autowired
	public SectionController(SectionService sectionService, UserService userService) {
		this.sectionService = sectionService;
		this.userService = userService;
	}
	
	@GetMapping("/form")
	public String sectionForm(Model model) {
		model.addAttribute("sectionForm", new Section());
		model.addAttribute("users", userService.userList());
		return "section/form";
	}
	
	@GetMapping("/edit/{id}")
	public String editSection(@PathVariable Long id, Model model) {
		model.addAttribute("sectionForm", sectionService.findOne(id));
		model.addAttribute("users", userService.userList());
		return "section/form";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_USER')") 
	public String deleteSection(@PathVariable Long id, Model model) {
		model.addAttribute("message", sectionService.deleteSection(id));
		return "message";
	}
		
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_USER')") 
	public String addSection(@ModelAttribute Section section, Model model) {
		model.addAttribute("message", sectionService.addSection(section).getSectionId() + " section add successfully");
		return "message";
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public String sectionList(Model model) {
		model.addAttribute("sections", sectionService.sectionList());
		return "section/list";
	}
	
	@GetMapping("/list/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
	public Section findOne(@PathVariable Long id) {
		return sectionService.findOne(id);
	}
}
