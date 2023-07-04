package uz.sirius.springjparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sirius.springjparelationships.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    boolean existsByName(String name);
}
