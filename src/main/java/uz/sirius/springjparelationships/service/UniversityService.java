package uz.sirius.springjparelationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sirius.springjparelationships.dto.UniversityDto;
import uz.sirius.springjparelationships.entity.Address;
import uz.sirius.springjparelationships.entity.University;
import uz.sirius.springjparelationships.repository.AddressRepository;
import uz.sirius.springjparelationships.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    public void saveUniversity(UniversityDto universityDto) {
        Address address = new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        University university = new University();
        university.setName(universityDto.getName());
        university.setAddress(savedAddress);
        universityRepository.save(university);
    }

    public void editUniversity(Integer id, UniversityDto universityDto) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isPresent()) {
            University editedUnive = optionalUniversity.get();
            editedUnive.setName(universityDto.getName());
            Address address = editedUnive.getAddress();
            address.setCity(universityDto.getCity());
            address.setDistrict(universityDto.getDistrict());
            address.setStreet(universityDto.getStreet());
            addressRepository.save(address);
            universityRepository.save(editedUnive);
        }
    }

    public void deleteUniversity(Integer id) {
        universityRepository.deleteById(id);
    }
}
