package uz.sirius.springjparelationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sirius.springjparelationships.entity.Subject;
import uz.sirius.springjparelationships.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public String createSubject(Subject subject) {
        boolean b = subjectRepository.existsByName(subject.getName());
        if (b) {
            return " This subject already exist";
        }
        subjectRepository.save(subject);
        return "Subject added";
    }

    public List<Subject> getSubjects() {
        List<Subject> allSubject = subjectRepository.findAll();
        if (!allSubject.isEmpty()) {
            return allSubject;
        }
        return null;
    }

    public Subject getSubjectById(Integer id) {
        Optional<Subject> byId = subjectRepository.findById(id);
        return byId.orElseGet(Subject::new);
    }

    public void editSubject(Integer id, Subject subject) {
        Optional<Subject> byId = subjectRepository.findById(id);
        if (byId.isPresent()) {
            Subject editedSubject = byId.get();
            editedSubject.setName(subject.getName());
            subjectRepository.save(editedSubject);
        }
    }

    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}
