package com.jedi.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Padawan;

@Repository
public interface PadawanRepository extends CrudRepository<Padawan, Long>{}