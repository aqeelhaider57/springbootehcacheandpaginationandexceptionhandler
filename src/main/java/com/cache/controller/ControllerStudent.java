package com.cache.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.dto.DtoSearch;
import com.cache.dto.DtoStudent;
import com.cache.service.ServiceStudent;


@RestController
@RequestMapping("/student")
public class ControllerStudent {
	
	private static final Logger logger = LogManager.getLogger(ControllerStudent.class);
	
	@Autowired
	private ServiceStudent serviceStudent;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DtoStudent>> getAll(){
		ResponseEntity<List<DtoStudent>> responseEntity = null;
		List<DtoStudent> list = serviceStudent.getAll();
		if(list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.FOUND);
		}else {
			responseEntity = new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllf")
	public ResponseEntity<List<DtoStudent>> findAll(){
		ResponseEntity<List<DtoStudent>> responseEntity = null;
		List<DtoStudent> list = serviceStudent.findAll();
		if(list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.FOUND);
		}else {
			responseEntity = new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Boolean> deletEntity(@RequestBody DtoStudent dtoStudent){
		ResponseEntity<Boolean> responseEntity = null;
		boolean result = serviceStudent.delelteStudent(dtoStudent);
		if(result) { 
			responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<>(result, HttpStatus.METHOD_FAILURE);
		}
		return responseEntity;
	} 
	
	//specifice method for pagination
	//pageable query, count query, without pageable query
	@PostMapping(value = "/searchAll")
	public ResponseEntity<DtoSearch> searchAll(@RequestBody DtoSearch dtoSearch) {
		logger.info("Start /student search");
		
		ResponseEntity<DtoSearch> responseEntity = null;

		DtoSearch dtoSearchResult =  serviceStudent.searchAll(dtoSearch);
		
		if (dtoSearchResult != null) {
			responseEntity = new ResponseEntity<>(dtoSearchResult, HttpStatus.FOUND);
			} else {
				responseEntity = new ResponseEntity<>(dtoSearchResult, HttpStatus.NOT_FOUND);
			}

		logger.info("End /student search");
		return responseEntity;
	}
	
	//normal method for pagination
	//simple pageable query
	@PostMapping(value = "/search")
	public ResponseEntity<DtoSearch> search(@RequestBody DtoSearch dtoSearch) {
		logger.info("Start /student search");
		
		ResponseEntity<DtoSearch> responseEntity = null;

		DtoSearch dtoSearchResult =  serviceStudent.search(dtoSearch);
		
		if (dtoSearchResult != null) {
			responseEntity = new ResponseEntity<>(dtoSearchResult, HttpStatus.FOUND);
			} else {
				responseEntity = new ResponseEntity<>(dtoSearchResult, HttpStatus.NOT_FOUND);
			}

		logger.info("End /student search");
		return responseEntity;
	}

}
