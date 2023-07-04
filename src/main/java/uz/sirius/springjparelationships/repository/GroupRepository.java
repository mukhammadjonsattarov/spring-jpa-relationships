package uz.sirius.springjparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sirius.springjparelationships.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    boolean existsByNameAndFaculty_Id(String name, Integer faculty_id);
    List<Group> findAllByFaculty_University_Id(Integer faculty_id);
}
