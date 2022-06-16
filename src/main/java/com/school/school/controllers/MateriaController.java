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

import com.school.school.entities.Materia;
import com.school.school.entities.Profesor;
import com.school.school.services.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	MateriaService materiaService;

	@PostMapping
	public ResponseEntity<Materia> saveMateria(@RequestBody Materia materia) {
		return materiaService.saveMateria(materia);
	}

	@GetMapping
	public List<Materia> listMaterias() {
		return materiaService.findMaterias();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Materia> updaterMateria(@PathVariable Long id, @RequestBody Materia materia){
		return materiaService.findMateriaById(id, materia);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteMateria(@PathVariable Long id){
		return materiaService.deleteMateria(id);
	}
}
