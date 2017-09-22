package adon.sample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import adon.sample.domain.Student;
import adon.sample.dto.StudentDto;
import adon.sample.repository.StudentRespository;

@Service
public class StudentService {

	private final StudentRespository studentRespository;

	public StudentService(final StudentRespository studentRespository) {
		this.studentRespository = studentRespository;
	}

	public List<StudentDto> getAllStudents() {
		List<Student> students = studentRespository.findAll();
		return students.stream().map(student -> {
			return new StudentDto(student);
		}).collect(Collectors.toList());
	}

	@Transactional
	public void createStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setAddress(studentDto.getAddress());
		student.setAge(studentDto.getAge());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student = studentRespository.save(student);
	}
	
}
