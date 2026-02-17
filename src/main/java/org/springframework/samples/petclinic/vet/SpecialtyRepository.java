package org.springframework.samples.petclinic.vet;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SpecialtyRepository extends CrudRepository<Specialty, Integer> {

	// This gives you the findAll() method automatically
	List<Specialty> findAll();

}
