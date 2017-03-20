package com.deliciousFood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Person findById(long id);
	Person findByName(String username);
	Person findByEmail(String email);
}
