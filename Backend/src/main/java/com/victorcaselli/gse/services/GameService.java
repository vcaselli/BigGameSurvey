package com.victorcaselli.gse.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victorcaselli.gse.dto.GameDTO;
import com.victorcaselli.gse.entities.Game;
import com.victorcaselli.gse.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository repo;

	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){ 
		List<Game> list = repo.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
}
