package com.victorcaselli.gse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorcaselli.gse.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
