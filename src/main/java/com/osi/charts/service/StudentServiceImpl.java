package com.osi.charts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osi.charts.domain.Student;
import com.osi.charts.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService
{
	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> geStudentByCampus(List<String> campus) {
		List<Student> listOfStudents = new ArrayList<Student>();
		for(String stdCampus : campus){
			Student student = studentRepository.findByCampus(stdCampus);
			listOfStudents.add(student);
		}
		return listOfStudents;
	}

}
