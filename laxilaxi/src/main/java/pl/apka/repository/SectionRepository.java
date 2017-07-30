package pl.apka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.apka.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
