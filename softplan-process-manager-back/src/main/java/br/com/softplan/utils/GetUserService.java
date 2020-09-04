package br.com.softplan.utils;

import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.config.security.UserSS;
import br.com.softplan.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserService {

    private UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User user() {
        UserSS userSS = (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userSS.getUsername());
    }

}

