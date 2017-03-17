package com.deliciousFood;

import java.awt.print.Pageable;

import org.h2.mvstore.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long>{

	Request findById(long id);

}
