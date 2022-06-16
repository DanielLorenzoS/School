package com.school.school.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.entities.Alumno;
import com.school.school.entities.Profesor;
import com.school.school.repositories.ProfesorRepository;
import com.school.school.services.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	ProfesorService profesorService;
	
	@Autowired
	ProfesorRepository profesorRepository;

	@PostMapping
	public ResponseEntity<Profesor> saveProfesor(@RequestBody Profesor profesor) {
		return profesorService.saveProfesor(profesor);
	}

	@GetMapping
	public List<Profesor> listProfesores() {
		return profesorService.findProfesores();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
		return profesorService.findProfesorById(id, profesor);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteProfesor(@PathVariable Long id) {
		return profesorService.deleteProfesor(id);
	}
	
	@GetMapping("/{id}/alumnos")
	public ResponseEntity<Collection<Alumno>> getProfesores(@PathVariable Long id) {
		Profesor profesor = profesorRepository.findById(id).orElseThrow(); 
		
		if (profesor!= null) {
			return new ResponseEntity<>(profesor.getAlumnos(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
