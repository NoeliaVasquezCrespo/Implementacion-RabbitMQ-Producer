package ucb.edu.bo.projectrabbitmq.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ucb.edu.bo.projectrabbitmq.entity.Student;

import java.util.List;


public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

    @Query(value="SELECT * FROM student", nativeQuery = true)
    List<Student> getStudents();

    @Query(value = "SELECT s FROM Student s")
    List<Student> getStudentsJPA();

    @Query(value = "SELECT s FROM Student s WHERE s.studentId = :id")
    Student getStudentByIdJPA(Long id);

    @Query(value = "SELECT * FROM student s WHERE s.student_id = :id", nativeQuery = true)
    Student getStudentById(Long id);
}