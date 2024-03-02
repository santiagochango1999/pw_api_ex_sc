package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscar() {
		List<EstudianteTO> estu = this.estudianteService.buscartodos();
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

	// http://localhost:8080/API/v1.0/Inscripcion/estudiantes

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	// http://localhost:8080/API/v1.0/Inscripcion/estudiantes

}
