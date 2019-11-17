package com.arcanjoweb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcanjoweb.cursomc.domain.Categoria;
import com.arcanjoweb.cursomc.repositories.CategoriaRepository;
import com.arcanjoweb.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id 
					+ ", Tipo: " + Categoria.class.getName());
			
		}
		return obj.orElse(null);

		
	}
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
}