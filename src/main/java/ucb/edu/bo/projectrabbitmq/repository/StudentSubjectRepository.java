package ucb.edu.bo.projectrabbitmq.repository;


import ucb.edu.bo.projectrabbitmq.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
}