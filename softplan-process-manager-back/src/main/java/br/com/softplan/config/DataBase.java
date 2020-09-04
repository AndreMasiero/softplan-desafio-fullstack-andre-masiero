package br.com.softplan.config;

import br.com.softplan.component.user.repositories.RoleRepository;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.domain.Role;
import br.com.softplan.domain.User;
import br.com.softplan.enums.RoleUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DataBase {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public DataBase(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void instantiateDatabase() throws ParseException {

        User user = new User();
        user.setFirstName("André");
        user.setLastName("Masiero");
        user.setUsername("andreboavista@gmail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));

        Role role = new Role();
        role.setName(RoleUser.ROLE_ADMIN);
        Role roleAdmin = roleRepository.save(role);

        role = new Role();
        role.setName(RoleUser.ROLE_TRIATOR);
        roleRepository.save(role);

        role = new Role();
        role.setName(RoleUser.ROLE_FINISHER);
        roleRepository.save(role);

        User userSaved = userRepository.save(user);
        userSaved.setRole(roleAdmin);

        userRepository.save(userSaved);
    }
}