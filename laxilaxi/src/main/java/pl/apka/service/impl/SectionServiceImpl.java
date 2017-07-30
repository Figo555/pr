package pl.apka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.apka.model.Section;
import pl.apka.repository.SectionRepository;
import pl.apka.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	
	private SectionRepository sectionRepository;
	
	@Autowired
	public SectionServiceImpl(SectionRepository sectionRepository) {
		this.sectionRepository = sectionRepository;
	}

	@Override
	public List<Section> sectionList() {
		return sectionRepository.findAll();
	}

	@Override
	public Section findOne(Long id) {
		return sectionRepository.findOne(id);
	}

	@Override
	public Section addSection(Section section) {
		return sectionRepository.save(section);
	}

	@Override
	public String deleteSection(Long id) {
		sectionRepository.delete(id);
		return "section deleted successfully";
	}


}
