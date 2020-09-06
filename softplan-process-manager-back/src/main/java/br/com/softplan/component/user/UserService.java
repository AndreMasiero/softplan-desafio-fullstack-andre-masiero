package br.com.softplan.component.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.component.user.repositories.RoleRepository;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.component.user.validator.UserServiceValidator;
import br.com.softplan.domain.Role;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.enums.RoleUser;
import br.com.softplan.utils.GetUserService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserServiceValidator userServiceValidator;
    private final GetUserService getUserService;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       UserServiceValidator userServiceValidator,
                       GetUserService getUserService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userServiceValidator = userServiceValidator;
        this.getUserService = getUserService;
    }

    public Long create(UserInputDto inputDto) throws Exception {

        userServiceValidator.isValid(inputDto, null);

        User user;
        try {
            user = userRepository.save(UserMapper.inputDtoToEntity(inputDto, null, getRole(inputDto), null));
        } catch (Exception e) {
            throw new Exception(ErrorMessage.ERROR_SAVING_USER.getDescription());
        }

        return user.getId();
    }

    public Long update(UserInputDto inputDto, Long id) throws Exception {

        userServiceValidator.isValid(inputDto, id);

        User user;
        try {
            user = userRepository.findById(id).get();
            userRepository.save(UserMapper.inputDtoToEntity(inputDto, user, getRole(inputDto), id));
        } catch (Exception e) {
            throw new Exception(ErrorMessage.ERROR_UPDATE_USER.getDescription());
        }

        return user.getId();
    }

    public UserOutputDto getUser(Long id) {
        return UserMapper.entityToOutputDto(userRepository.findById(id).get());
    }

    public List<UserOutputDto> findAll() {
        Specification<User> filter = UserSpecification.findByFilter(getProfile());

        return UserMapper.entityToOutputDtoList(userRepository.findAll(filter));
    }

    public void delete(Long id) throws Exception {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(ErrorMessage.ERROR_DELETE_USER.getDescription());
        }
    }

    private RoleUser getProfile() {
        User userPrincipal = getUserService.user();
        return userPrincipal.getRole().getName();
    }

    private Role getRole(UserInputDto inputDto) {
        return roleRepository.findByName(inputDto.getRole());
    }
}
