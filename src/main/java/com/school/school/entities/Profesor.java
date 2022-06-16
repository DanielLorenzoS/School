package com.school.school.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "profesores")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profesor_id")
	private Long id;

	private String nombre;

	@OneToMany(mappedBy = "profesor")
	private Set<Materia> materias = new HashSet<>();

	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "alumnos_profesores", joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id"))
	private Set<Alumno> alumnos = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
