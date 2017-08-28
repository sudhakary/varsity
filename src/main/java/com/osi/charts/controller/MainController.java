package com.osi.charts.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.charts.domain.Student;
import com.osi.charts.service.IStudentService;


@RestController
@RequestMapping("/student")
public class MainController {
	
	@Autowired
	IStudentService iStudentService;
	
   @PostMapping
	public ResponseEntity<String> createStudentDetails(@RequestBody Student student){
		iStudentService.createStudent(student);
		return new ResponseEntity<String>("Student details saved successfully",HttpStatus.CREATED);
	}

	public ResponseEntity<String> getStudentByCampus(@PathVariable List<String> campus){
		iStudentService.geStudentByCampus(campus);
		return new ResponseEntity<String>("Student details saved successfully",HttpStatus.CREATED);
	}
}
