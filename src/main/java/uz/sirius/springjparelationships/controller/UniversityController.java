package uz.sirius.springjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.sirius.springjparelationships.dto.UniversityDto;
import uz.sirius.springjparelationships.entity.University;
import uz.sirius.springjparelationships.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping
    public List<University> getUniversities() {
        return universityService.getAllUniversities();
    }

    @PostMapping
    public void createUniversity(@RequestBody UniversityDto universityDto) {
        universityService.saveUniversity(universityDto);
    }

    @PutMapping(value = "/{id}")
    public void updateUniversity(@PathVariable Integer id, @RequestBody UniversityDto universityDto) {
        universityService.editUniversity(id, universityDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUniversity(@PathVariable Integer id) {
        universityService.deleteUniversity(id);
    }
}
