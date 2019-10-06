package com.arcanjoweb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcanjoweb.cursomc.domain.Cliente;
import com.arcanjoweb.cursomc.repositories.ClienteRepository;
import com.arcanjoweb.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id 
					+ ", Tipo: " + Cliente.class.getName());
			
		}
		return obj.orElse(null);

		
	}

}