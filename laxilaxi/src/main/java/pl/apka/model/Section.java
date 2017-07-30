package pl.apka.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Section extends AbstractPersistable<Long> {
	private static final long serialVersionUID = -3608251687225514699L;
	private transient Long id;
	private transient Long userName;
	private String sectionId;
	
	@OneToMany(targetEntity = User.class, mappedBy="section", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<User> users;
	private User user;

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserName() {
		return userName;
	}

	public void setUserName(Long userName) {
		this.userName = userName;
	}
	
}