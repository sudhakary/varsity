package com.osi.charts.service;

import java.util.List;

import com.osi.charts.domain.Student;

public interface IStudentService {
     Student createStudent(Student student);
     List<Student> geStudentByCampus(List<String> campus);
}
