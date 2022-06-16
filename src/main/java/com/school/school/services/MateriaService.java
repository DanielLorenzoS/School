package com.school.school.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.school.entities.Materia;
import com.school.school.entities.Profesor;
import com.school.school.exception.ResourceNotFoundException;
import com.school.school.repositories.MateriaRepository;
import com.school.school.repositories.ProfesorRepository;

@Service
public class MateriaService {
	
	@Autowired
	MateriaRepository materiaRepository;
	
	public ResponseEntity<Materia> saveMateria(@RequestBody Materia materia){
		return ResponseEntity.ok(materiaRepository.save(materia));
	}
	
	public List<Materia> findMaterias(){
		return materiaRepository.findAll();
	}
	
	public ResponseEntity<Materia> findMateriaById(@PathVariable Long id, @RequestBody  Materia pivMateria){
		Materia materia = materiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
		materia.setNombre(pivMateria.getNombre());
		Materia savedMateria = materiaRepository.save(materia);
		return ResponseEntity.ok(savedMateria);
	}
	
	public Map<String, Boolean> deleteMateria(@PathVariable Long id){
		Materia materia = materiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró la materia seleccionada"));
		materiaRepository.delete(materia);
		Map<String, Boolean>response = new HashMap<>();
		response.put("Materia eliminada", true);
		return response;
	}
	
}





