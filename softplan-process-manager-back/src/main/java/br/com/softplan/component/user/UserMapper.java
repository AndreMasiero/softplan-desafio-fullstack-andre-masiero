package br.com.softplan.component.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.domain.Role;
import br.com.softplan.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User inputDtoToEntity(UserInputDto inputDto, User user, Role role, Long id) {

        if (user == null) {
            user = new User();
        }

        user.setId(id != null ? id : null);
        user.setFirstName(inputDto.getFirstName());
        user.setLastName(inputDto.getLastName());
        user.setUsername(inputDto.getEmail());
        user.setId(user.getId());
        if (inputDto.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(inputDto.getPassword()));
        }
        user.setRole(role);

        return user;
    }

    public static List<UserOutputDto> entityToOutputDtoList(List<User> users) {
        List<UserOutputDto> userOutputDto = new ArrayList<>();

        users.forEach(user -> {
            UserOutputDto outputDto = new UserOutputDto();
            outputDto.setId(user.getId());
            outputDto.setFirstName(user.getFirstName());
            outputDto.setLastName(user.getLastName());
            outputDto.setEmail(user.getUsername());

            userOutputDto.add(outputDto);
        });

        return userOutputDto;
    }

    public static UserOutputDto entityToOutputDto(User user) {
        UserOutputDto outputDto = new UserOutputDto();
        outputDto.setId(user.getId());
        outputDto.setFirstName(user.getFirstName());
        outputDto.setLastName(user.getLastName());
        outputDto.setEmail(user.getUsername());
        outputDto.setRole(user.getRole().getName());

        return outputDto;
    }

}
