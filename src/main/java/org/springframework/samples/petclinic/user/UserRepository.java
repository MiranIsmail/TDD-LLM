package org.springframework.samples.petclinic.user;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	@Query("""
			SELECT u
			FROM User u
			LEFT JOIN Owner o ON u.id = o.id
			WHERE o.id IS NULL
			""")
	List<User> findAllExceptOwners();

	@Query("SELECT u FROM User u WHERE u.role <> 'OWNER'")
	List<User> findAllExceptOwnersv2();

}
