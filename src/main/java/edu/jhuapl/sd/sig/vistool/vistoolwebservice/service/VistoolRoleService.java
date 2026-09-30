package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VistoolRoleService {
    @Autowired
    private VistoolRoleRepository vistoolRoleRepository;

    public List<String> findAllRoleNames() {
        return vistoolRoleRepository.findAll()
            .stream()
            .map(VistoolRole::getRole)
            .sorted()
            .collect(Collectors.toList());
    }
}