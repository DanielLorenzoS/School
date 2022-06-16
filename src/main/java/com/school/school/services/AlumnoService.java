package com.school.school.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.school.entities.Alumno;
import com.school.school.exception.ResourceNotFoundException;
import com.school.school.repositories.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public ResponseEntity<Alumno> saveAlumnos(@RequestBody Alumno alumno){
		return ResponseEntity.ok(alumnoRepository.save(alumno));
	}
	
	public List<Alumno> findAlumnos(){
		return alumnoRepository.findAll();
	}
	
	public ResponseEntity<Alumno> findAlumnoById(@PathVariable Long id, @RequestBody Alumno alumno2){
		Alumno alumno = alumnoRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("El alumno con el id ${id} no encontrado"));
		alumno.setNombre(alumno2.getNombre());
		Alumno alumnoUpdated = alumnoRepository.save(alumno);
		return ResponseEntity.ok(alumnoUpdated);
	}
	
	public Map<String, Boolean> deleteAlumno(@PathVariable Long id){
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno con el ID: " + id + "no encontrado"));
		alumnoRepository.delete(alumno);
		Map<String, Boolean> res = new HashMap<>();
		res.put("Alumno eliminado", Boolean.TRUE);
		return res;
	}

}
