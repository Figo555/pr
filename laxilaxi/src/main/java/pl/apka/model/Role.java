package pl.apka.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Role extends AbstractPersistable<Long>{
	private static final long serialVersionUID = -8428405820038117540L;
	private transient Long id;
	private String name;
	
	@OneToMany(targetEntity = User.class, mappedBy="role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
