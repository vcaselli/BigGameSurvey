package com.victorcaselli.gse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorcaselli.gse.dto.GameDTO;
import com.victorcaselli.gse.services.GameService;

@RestController
@RequestMapping("/games")
public class GameResource {
	
	@Autowired
	GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){ 
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
