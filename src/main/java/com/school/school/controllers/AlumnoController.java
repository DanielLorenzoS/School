package com.school.school.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.school.school.services.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@PostMapping
	public ResponseEntity<Alumno> saveAlumno(@RequestBody Alumno alumno){
		return  alumnoService.saveAlumnos(alumno);
	}
	
	@GetMapping
	public List<Alumno> findAlumnos(){
		return alumnoService.findAlumnos();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
		return alumnoService.findAlumnoById(id, alumno);
	}
	
	@DeleteMapping("/alumno/{id}")
	public Map<String, Boolean> deleteAlumno(@PathVariable Long id){
		return alumnoService.deleteAlumno(id);
	}
}









