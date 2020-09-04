package br.com.softplan.component.user.validator;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.enums.RoleUser;
import br.com.softplan.utils.GetUserService;
import br.com.softplan.utils.ValidateEmail;
import org.springframework.stereotype.Service;

@Service
public class UserServiceValidator {

    private final UserRepository userRepository;
    private final GetUserService getUserService;

    public UserServiceValidator(UserRepository userRepository, GetUserService getUserService) {
        this.userRepository = userRepository;
        this.getUserService = getUserService;
    }

    public void isValid(UserInputDto inputDto, Long id) throws Exception {

        User userPrincipal = getUserService.user();

        RoleUser role = userPrincipal.getRole().getName();

        if (!ValidateEmail.isValidEmailAddressRegex(inputDto.getEmail()))
            throw new Exception(ErrorMessage.USER_INVALID_EMAIL.getDescription());

        validateUserToBeSaved(inputDto, id, userPrincipal, role);
    }

    private void validateUserToBeSaved(UserInputDto inputDto, Long id, User userPrincipal, RoleUser isAdmin) throws Exception {
        User user = userRepository.findByUsername(inputDto.getEmail());

        if (id == null && user != null)
            throw new Exception(ErrorMessage.USER_EMAIL_ALREADY_IN_USE.getDescription());

        switch (isAdmin) {
            case ROLE_ADMIN:
                if (user != null && user.getId() != id)
                    throw new Exception(ErrorMessage.USER_EMAIL_UNAVAILABLE.getDescription());
        }
    }
}
