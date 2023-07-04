package uz.sirius.springjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.sirius.springjparelationships.dto.GroupDto;
import uz.sirius.springjparelationships.entity.Group;
import uz.sirius.springjparelationships.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public String createGroup(@RequestBody GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }
    @GetMapping("/{byUniversity}/{universityId}")
    public List<Group> getGroupsByUniversity(@PathVariable Integer universityId) {
        return groupService.getGroupsByUniversity(universityId);
    }

    @PutMapping("/{id}")
    public String editGroup(@PathVariable Integer id, @RequestBody GroupDto groupDto) {
        return groupService.editGroup(id, groupDto);
    }
}
