package com.devsuperior.pesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.pesquisa.dto.GameDTO;
import com.devsuperior.pesquisa.entities.Game;
import com.devsuperior.pesquisa.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)  //importante para evitar o looking - readOnly serve para busca
	public List<GameDTO> findAll() {
		List<Game> list = repository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
		//transforma em stream > aplica em cada elemento > transforma denovo para lista
	}
}
