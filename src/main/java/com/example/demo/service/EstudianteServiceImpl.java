package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub

		Estudiante estu = convertir1(estudiante);
		this.estudianteRepository.insertar(estu);
	}

	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estTo = new EstudianteTO();
		estTo.setApellido(est.getApellido());
		estTo.setId(est.getId());
		estTo.setNombre(est.getNombre());
		estTo.setCedula(est.getCedula());

		return estTo;
	}

	private Estudiante convertir1(EstudianteTO est) {
		Estudiante estTo = new Estudiante();
		estTo.setApellido(est.getApellido());
		estTo.setId(est.getId());
		estTo.setNombre(est.getNombre());
		estTo.setCedula(est.getCedula());

		return estTo;
	}

	@Override
	public List<EstudianteTO> buscartodos() {
		// TODO Auto-generated method stub
		List<Estudiante> list = this.estudianteRepository.seleccionartodos();
		List<EstudianteTO> listafinal = new ArrayList<>();
		for (Estudiante est : list) {
			listafinal.add(this.convertir(est));
		}
		return listafinal;
	}

}
