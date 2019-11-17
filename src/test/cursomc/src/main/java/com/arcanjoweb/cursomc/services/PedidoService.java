package com.arcanjoweb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcanjoweb.cursomc.domain.Pedido;
import com.arcanjoweb.cursomc.repositories.PedidoRepository;
import com.arcanjoweb.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id 
					+ ", Tipo: " + Pedido.class.getName());
			
		}
		return obj.orElse(null);

		
	}

}