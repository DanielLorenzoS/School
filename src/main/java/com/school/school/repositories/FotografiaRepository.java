package com.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.school.entities.Fotografia;

@Repository
public interface FotografiaRepository extends JpaRepository<Fotografia, String>{

}
