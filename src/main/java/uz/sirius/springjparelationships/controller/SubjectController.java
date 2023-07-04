package uz.sirius.springjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.sirius.springjparelationships.entity.Subject;
import uz.sirius.springjparelationships.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public String createSubject(@RequestBody Subject subject) {
      return   subjectService.createSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = subjectService.getSubjects();
        return subjects;
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id) {
        Subject subjectById = subjectService.getSubjectById(id);
        return subjectById;
    }

    @PutMapping("/{id}")
    public void editSubject(@PathVariable Integer id, @RequestBody Subject subject) {
        subjectService.editSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
    }
}
