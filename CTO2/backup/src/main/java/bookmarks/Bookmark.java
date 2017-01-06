package bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mzwart on 5-1-2017.
 */
@Entity
//@Table(name = "bookmark", schema="cto")
public class Bookmark {

	@JsonIgnore
	@ManyToOne
	private Account account;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public String uri;
	public String description;

	Bookmark(){}

	public Bookmark(Account account, String uri, String description){
		this.uri = uri;
		this.description = description;
		this.account = account;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
