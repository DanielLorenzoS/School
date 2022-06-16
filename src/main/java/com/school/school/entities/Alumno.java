package com.school.school.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alumno_id")
	private Long id;

	private String nombre;
	private int noLista;

	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "alumnos_profesores", joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id"), inverseJoinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id"))
	private Set<Profesor> profesores = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "fotografia_id")
	private Fotografia fotografia;

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

	public int getNoLista() {
		return noLista;
	}

	public void setNoLista(int noLista) {
		this.noLista = noLista;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Fotografia getFotografia() {
		return fotografia;
	}

	public void setFotografia(Fotografia fotografia) {
		this.fotografia = fotografia;
	}

}
