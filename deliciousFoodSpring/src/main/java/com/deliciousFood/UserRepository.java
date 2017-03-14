package com.deliciousFood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	User findById(long id);

	User findByName(String username);
}
