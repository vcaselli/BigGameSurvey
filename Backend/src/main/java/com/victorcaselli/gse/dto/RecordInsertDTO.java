package com.victorcaselli.gse.dto;

import java.io.Serializable;

public class RecordInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private Long gameId;
	

	
	public RecordInsertDTO() { 
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Long getGameId() {
		return gameId;
	}



	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	
	
	
	
}
