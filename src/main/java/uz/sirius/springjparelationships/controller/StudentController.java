package uz.sirius.springjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import uz.sirius.springjparelationships.entity.Student;
import uz.sirius.springjparelationships.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/forMinistry")
    public Page<Student> getStudentsForMinistry(@RequestParam int page) {
        return studentService.getStudentsForMinistry(page);
    }

    @GetMapping("/forUniversity/{universityId}")
    public Page<Student> getStudentsForUniversity(@PathVariable Integer universityId, @RequestParam int page) {
        return studentService.getStudentsForUniversity(universityId, page);
    }

    @GetMapping("/forUniversity/{facultyId}")
    public Page<Student> getStudentsForFaculty(@PathVariable Integer facultyId, @RequestParam int page) {
        return studentService.getStudentsForUniversity(facultyId, page);
    }

    @GetMapping("/forGroup/{groupId}")
    public List<Student> getStudentsForGroup(@PathVariable Integer groupId) {
        return studentService.getStudentsForGroup(groupId);
    }
}
