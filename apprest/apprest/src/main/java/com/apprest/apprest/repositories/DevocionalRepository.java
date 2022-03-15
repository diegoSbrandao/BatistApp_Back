package com.apprest.apprest.repositories;

import com.apprest.apprest.entities.Devocional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevocionalRepository extends JpaRepository<Devocional, Long> {


}
