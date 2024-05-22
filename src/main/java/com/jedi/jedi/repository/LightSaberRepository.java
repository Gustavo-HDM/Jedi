package com.jedi.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.LightSaber;

@Repository
public interface LightSaberRepository extends CrudRepository<LightSaber, Long>{}
