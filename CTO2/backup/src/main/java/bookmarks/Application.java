package bookmarks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by mzwart on 5-1-2017.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
		return (evt) -> Arrays.asList(
			"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
			.forEach(
				a -> {
					Account account = accountRepository.save(new Account(a, "password"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
				});
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/CTO2");
		dataSource.setUsername("cto");
		dataSource.setPassword("cto");
		return dataSource;
	}
}
