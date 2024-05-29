package com.jedi.jedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.LightSaber;

@Repository
public interface LightSaberRepository extends CrudRepository<LightSaber, Long>{
	
	@Query (value = "Select l from LightSaber l where l.color = :color and l.size = :size")
	List<LightSaber> isDuplicated (@Param("color") String color, @Param("size") Double size);
}
