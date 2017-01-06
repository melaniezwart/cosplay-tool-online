package bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by mzwart on 5-1-2017.
 */
public interface AccountRepository extends JpaRepository<Account, Long>{
	Optional<Account> findByUsername(String username);
}
