package com.deliciousFood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long>{

	Request findById(long id);

}
