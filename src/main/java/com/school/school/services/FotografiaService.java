package com.school.school.services;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.school.school.entities.Fotografia;
import com.school.school.repositories.FotografiaRepository;

@Service
public class FotografiaService {

	@Autowired
	FotografiaRepository fotografiaRepository;

	public Fotografia getFotografias(MultipartFile file) throws Exception {
		String fotoName = StringUtils.cleanPath(file.getOriginalFilename());
		Fotografia fotografia = new Fotografia(fotoName, file.getContentType(), file.getBytes());
		return fotografiaRepository.save(fotografia);
	}

	public Fotografia getFotos(String id) {
		return fotografiaRepository.findById(id).get();
	}

	public Stream<Fotografia> getAllFotos() {
		return fotografiaRepository.findAll().stream();
	}
}
