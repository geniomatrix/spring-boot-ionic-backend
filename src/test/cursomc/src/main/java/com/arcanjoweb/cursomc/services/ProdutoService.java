package com.arcanjoweb.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.arcanjoweb.cursomc.domain.Categoria;
import com.arcanjoweb.cursomc.domain.Produto;
import com.arcanjoweb.cursomc.repositories.CategoriaRepository;
import com.arcanjoweb.cursomc.repositories.ProdutoRepository;
import com.arcanjoweb.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id 
					+ ", Tipo: " + Produto.class.getName());
			
		}
		return obj.orElse(null);

		
	}
	public Page<Produto> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage,String orderBy,String direction ) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		
	}
}