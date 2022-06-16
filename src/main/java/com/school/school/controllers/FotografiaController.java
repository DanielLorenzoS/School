package com.school.school.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.school.school.entities.Fotografia;
import com.school.school.message.ResponseFile;
import com.school.school.message.ResponseMessage;
import com.school.school.services.FotografiaService;

@Controller
@RequestMapping("/foto")
public class FotografiaController {

	@Autowired
	FotografiaService fotografiaService;

	@PostMapping("")
	public ResponseEntity<ResponseMessage> uploadFotografias(@RequestParam("file") MultipartFile file) {
		String res = "";
		try {
			fotografiaService.getFotografias(file);
			res = "Fotografía subida correctamente";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(res));
		} catch (Exception e) {
			res = "No se pudo subir la fotografía";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(res));
		}
	}

	@GetMapping("")
	public ResponseEntity<List<ResponseFile>> getFotografias() {
		List<ResponseFile> files = fotografiaService.getAllFotos().map(foto -> {
			String fotoUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/foto/").path(foto.getId())
					.toUriString();
			return new ResponseFile(foto.getId(), foto.getName(), fotoUri, foto.getType(), foto.getData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> downloadFotografia(@PathVariable String id){
		Fotografia fotografia = fotografiaService.getFotos(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fotografia.getName() + "\"")
				.body(fotografia.getData());
	}
}





