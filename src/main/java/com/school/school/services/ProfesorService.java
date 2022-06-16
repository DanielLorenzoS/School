package com.school.school.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.school.entities.Profesor;
import com.school.school.exception.ResourceNotFoundException;
import com.school.school.repositories.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	public ResponseEntity<Profesor> saveProfesor(@RequestBody Profesor profesor){
		return ResponseEntity.ok(profesorRepository.save(profesor));
	}
	
	public List<Profesor> findProfesores(){
		return profesorRepository.findAll();
	}
	
	public ResponseEntity<Profesor> findProfesorById(@PathVariable Long id, @RequestBody  Profesor pivProfesor){
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));
		profesor.setNombre(pivProfesor.getNombre());
		Profesor savedProfesor = profesorRepository.save(profesor);
		return ResponseEntity.ok(savedProfesor);
	}
	
	public Map<String, Boolean> deleteProfesor(@PathVariable Long id){
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró al profesor seleccionado"));
		profesorRepository.delete(profesor);
		Map<String, Boolean>response = new HashMap<>();
		response.put("Profesor eliminado", true);
		return response;
	}
	
}




