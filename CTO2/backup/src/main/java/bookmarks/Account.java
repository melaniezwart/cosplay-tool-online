package bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mzwart on 5-1-2017.
 */
@Entity
public class Account {

	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmarks = new HashSet<>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public String password;
	public String username;

	public Account(String username, String password){
		this.username = username;
		this.password = password;
	}

	Account(){}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
