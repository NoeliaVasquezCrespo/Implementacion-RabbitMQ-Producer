package ucb.edu.bo.projectrabbitmq.repository;

import ucb.edu.bo.projectrabbitmq.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}