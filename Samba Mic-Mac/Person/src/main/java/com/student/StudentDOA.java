package com.student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class StudentDOA {

	@Autowired
	StudentRepository studentRepository;
	
	//save the new records
	public Student save(Student std) {
		return studentRepository.save(std);
	}
	
	// find all student in database
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	// find student base on is id
	public Student findOne(Integer id) {
		return studentRepository.findOne(id);
	}
	
	// delete student on database
	public void delete(Student std) {
		studentRepository.delete(std);
	}
	
}
