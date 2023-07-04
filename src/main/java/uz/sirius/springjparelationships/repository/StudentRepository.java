package uz.sirius.springjparelationships.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.sirius.springjparelationships.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Page<Student> getStudentsByGroup_Faculty_UniversityId(Integer group_faculty_university_id, Pageable pageable);
    Page<Student> getStudentsByGroup_FacultyId(Integer group_faculty_id, Pageable pageable);
    List<Student> getStudentByGroup_Id(Integer group_id);
}
