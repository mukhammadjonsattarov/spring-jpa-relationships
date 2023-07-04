package uz.sirius.springjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.sirius.springjparelationships.dto.FacultyDto;
import uz.sirius.springjparelationships.entity.Faculty;
import uz.sirius.springjparelationships.repository.FacultyRepository;
import uz.sirius.springjparelationships.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping
    public List<Faculty> getAllFaculties(){
        return facultyService.getFaculties();
    }
    @PostMapping
    public String createFaculty(@RequestBody FacultyDto facultyDto) {
        return facultyService.createFaculty(facultyDto);
    }

    @GetMapping("/{byUniversityId}/{universityId}")
    public List<Faculty> getFacultiesByUniversity(@PathVariable Integer universityId) {
        return facultyService.getFacultiesByUniversity(universityId);
    }
    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Integer id){
        return facultyService.deleteFaculty(id);
    }
    @PutMapping("{/id}")
    public String editFaculty(@PathVariable Integer id,@RequestBody FacultyDto facultyDto){
        return facultyService.editFaculty(id,facultyDto);
    }
}
