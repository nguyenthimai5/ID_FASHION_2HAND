package ra.dev.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dev.model.entity.ERole;
import ra.dev.model.entity.Roles;
import ra.dev.model.repository.RoleRepository;
import ra.dev.model.service.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Roles> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
