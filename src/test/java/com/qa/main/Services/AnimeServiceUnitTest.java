package com.qa.main.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Anime;
import com.qa.main.repos.AnimeRepo;

@SpringBootTest
public class AnimeServiceUnitTest {

	@Autowired
	private AnimeService service;
	
	@MockBean
	private AnimeRepo repo;
	
	@Test
	public void testCreate() {
		
		//Create objects of Anime
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		//result object including "id" after mock processed through the service (JSON)
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
	
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		
		assertEquals(result, service.create(entry));
	}
	
	@Test
	public void testGetAll() {
		
		//Create objects of Anime
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
			
		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
	
	
	
	
}
