package uz.sirius.springjparelationships.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.sirius.springjparelationships.entity.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

}
