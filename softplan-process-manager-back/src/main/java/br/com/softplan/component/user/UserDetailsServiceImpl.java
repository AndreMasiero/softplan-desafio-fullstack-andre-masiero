package br.com.softplan.component.user;

import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.config.security.UserSS;
import br.com.softplan.domain.Role;
import br.com.softplan.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl  implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        Role role = user.getRole();
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        return new UserSS(user.getId(), user.getUsername(), user.getPassword(), roles);
    }
}
