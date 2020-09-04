package br.com.softplan.component.user.repositories;

import br.com.softplan.domain.Role;
import br.com.softplan.enums.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    Role findByName(RoleUser name);
}
