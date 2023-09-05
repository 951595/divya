package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository repository;
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	@GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return repository.findById(id);
	}
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student stu) {
		return repository.save(stu);
		
	}
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student stu) {
		Optional<Student> student = repository.findById(id);
		Student stud = student.get();
		stud.setName(stu.name);
		stud.setBranch(stu.branch);
		return repository.save(stud);
	}
	@DeleteMapping("delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Optional<Student> stu = repository.findById(id);
		Student student = stu.get();
		repository.delete(student);
		}

}
