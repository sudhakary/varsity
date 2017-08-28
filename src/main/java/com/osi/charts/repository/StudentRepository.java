package com.osi.charts.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.osi.charts.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
	Student findByCampus(String campus);

}
