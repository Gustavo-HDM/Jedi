package com.jedi.jedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Padawan;

@Repository
public interface PadawanRepository extends CrudRepository<Padawan, Long>{

	@Query (value = "SELECT p FROM Padawan p WHERE p.userId = :userId")
	List<Padawan> getAllPadawan(@Param("userId") Long userId);
}