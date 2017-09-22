package adon.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adon.sample.dto.StudentDto;
import adon.sample.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(final StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/getAll")
	public List<StudentDto> getAllStudents() {
		// TODO: data validator
		return studentService.getAllStudents();
	}
	
	@PostMapping("/create")
	public boolean createStudent(@RequestBody StudentDto studentDto){
		studentService.createStudent(studentDto);
		return true;
	}

}
