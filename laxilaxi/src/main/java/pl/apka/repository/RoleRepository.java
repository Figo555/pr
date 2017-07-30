package pl.apka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.apka.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

}
