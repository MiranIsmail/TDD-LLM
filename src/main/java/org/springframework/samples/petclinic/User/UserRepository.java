package org.springframework.samples.petclinic.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	// Needed by Spring Security to find a user by username
	Optional<User> findByUsername(String username);

}
