package adon.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adon.sample.domain.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student, String>{

}
