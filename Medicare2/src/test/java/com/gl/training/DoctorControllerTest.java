package com.gl.training;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import controller.DoctorController;
import service.DoctorService;
import model.*;
import net.minidev.json.JSONArray;

public class DoctorControllerTest {

	@Mock
	static private DoctorService docService;
	
	@InjectMocks
	static private DoctorController docController;
	
	private MockMvc mockMvc ;
	
	
	@Before 
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(docController).build();
		
	}
	
	@Test
	public void getAllDoctorsTest() throws Exception{
		
		JSONArray docs= new JSONArray();
		docs.add(new Doctor());
		docs.add(new Doctor());
		
		when(docService.getAllDoctors()).thenReturn(docs);
		
		mockMvc.perform(get("/doctors"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("Doctor",instanceOf(Doctor.class)));
	}
	
	
}
