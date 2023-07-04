package uz.sirius.springjparelationships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sirius.springjparelationships.dto.GroupDto;
import uz.sirius.springjparelationships.entity.Faculty;
import uz.sirius.springjparelationships.entity.Group;
import uz.sirius.springjparelationships.repository.FacultyRepository;
import uz.sirius.springjparelationships.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public String createGroup(GroupDto groupDto) {
        boolean b = groupRepository.existsByNameAndFaculty_Id(groupDto.getName(), groupDto.getFacultyId());
        if (b) {
            return "Already exist";
        } else {
            Group group = new Group();
            group.setName(groupDto.getName());
            Optional<Faculty> byId = facultyRepository.findById(groupDto.getFacultyId());
            if (byId.isPresent()) {
                Faculty faculty = byId.get();
                group.setFaculty(faculty);
                groupRepository.save(group);
                return "Group added";
            } else {
                return "Faculty not found";
            }
        }
    }

    public List<Group> getGroups() {
        List<Group> all = groupRepository.findAll();
        if (all.isEmpty()) {
            return null;
        } else {
            return all;
        }
    }

    public List<Group> getGroupsByUniversity(Integer universityId) {
        List<Group> groups = groupRepository.findAllByFaculty_University_Id(universityId);
        if (groups.isEmpty()) {
            return null;
        } else {
            return groups;
        }
    }

    public String editGroup(Integer id, GroupDto groupDto) {
        Optional<Group> byId = groupRepository.findById(id);
        if (byId.isPresent()) {
            Group editedGroup = byId.get();
            editedGroup.setName(groupDto.getName());
            Faculty faculty = editedGroup.getFaculty();
            editedGroup.setFaculty(faculty);
            groupRepository.save(editedGroup);
            return "Edited";
        } else {
            return "not found";
        }
    }
}
