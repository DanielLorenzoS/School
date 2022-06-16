package com.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.school.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
