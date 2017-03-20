package com.deliciousFood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	Restaurant findById(long id);

	Restaurant findByName(String username);
	
	Restaurant findByEmail(String email);
}

