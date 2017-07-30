package pl.apka.service;

import java.util.List;

import pl.apka.model.Section;

public interface SectionService {
	List<Section> sectionList();
	
	Section findOne(Long id);
	
	Section addSection(Section section);
	
	String deleteSection(Long id);
}
