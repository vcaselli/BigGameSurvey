package com.victorcaselli.gse.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victorcaselli.gse.dto.RecordDTO;
import com.victorcaselli.gse.dto.RecordInsertDTO;
import com.victorcaselli.gse.entities.Record;
import com.victorcaselli.gse.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	RecordRepository repo;

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) { 
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		entity.setGame(repo.getOne(dto.getGameId()).getGame());
		entity = repo.save(entity);
		return new RecordDTO(entity);
	}

	@Transactional
	public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repo.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}
	
}
