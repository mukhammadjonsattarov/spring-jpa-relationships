package uz.sirius.springjparelationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import uz.sirius.springjparelationships.dto.FacultyDto;
import uz.sirius.springjparelationships.entity.Faculty;
import uz.sirius.springjparelationships.entity.University;
import uz.sirius.springjparelationships.repository.FacultyRepository;
import uz.sirius.springjparelationships.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    UniversityRepository universityRepository;

    public String createFaculty(FacultyDto facultyDto) {
        boolean b = facultyRepository.existsByNameAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId());
        if (b) {
            return "alredy exist";
        }
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();
            faculty.setUniversity(university);
        } else {
            return "University not found";
        }
        facultyRepository.save(faculty);
        return "Faculty added";
    }


    public List<Faculty> getFacultiesByUniversity(Integer universityId) {
        List<Faculty> allByUniversityId = facultyRepository.findAllByUniversityId(universityId);
        if (allByUniversityId.isEmpty()) {
            return null;
        } else {
            return allByUniversityId;
        }
    }

    public List<Faculty> getFaculties() {
        List<Faculty> allByUniversityId = facultyRepository.findAll();
        if (allByUniversityId.isEmpty()) {
            return null;
        } else {
            return allByUniversityId;
        }
    }

    public String deleteFaculty(Integer id) {
        try {
            facultyRepository.deleteById(id);
            return "Deleted";

        } catch (Exception exception) {
            return "Error in deleting";
        }


    }

    public String editFaculty(Integer id, FacultyDto facultyDto) {
        Optional<Faculty> byId = facultyRepository.findById(id);
        if (byId.isPresent()) {
            Faculty faculty = byId.get();
            faculty.setName(facultyDto.getName());
            Optional<University> byId1 = universityRepository.findById(facultyDto.getUniversityId());
            if (!byId1.isPresent()) {
                return "University not found";
            }
            University university = byId1.get();
            faculty.setUniversity(university);
            facultyRepository.save(faculty);
            return "Edited";

        }
        return "Faculty not found";
    }
}
