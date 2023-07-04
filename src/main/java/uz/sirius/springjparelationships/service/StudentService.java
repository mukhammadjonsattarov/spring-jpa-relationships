package uz.sirius.springjparelationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import uz.sirius.springjparelationships.entity.Student;
import uz.sirius.springjparelationships.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Page<Student> getStudentsForMinistry(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Student> all = studentRepository.findAll(pageable);
        return all;

    }

    public Page<Student> getStudentsForUniversity(Integer universityId, int page) {

        Pageable pageable = PageRequest.of(page, 10);
        Page<Student> all = studentRepository.getStudentsByGroup_Faculty_UniversityId(universityId, pageable);
        return all;

    }

    public Page<Student> getStudentsForFaculty(Integer facultyId, int page) {

        Pageable pageable = PageRequest.of(page, 10);
        Page<Student> all = studentRepository.getStudentsByGroup_FacultyId(facultyId, pageable);
        return all;

    }

    public List<Student> getStudentsForGroup(Integer group_id) {
        List<Student> studentByGroup_id = studentRepository.getStudentByGroup_Id(group_id);
        return studentByGroup_id;
    }
}
