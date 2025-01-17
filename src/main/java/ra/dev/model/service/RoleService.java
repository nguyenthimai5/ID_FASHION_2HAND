package ra.dev.model.service;

import ra.dev.model.entity.ERole;
import ra.dev.model.entity.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRoleName(ERole roleName);
}
