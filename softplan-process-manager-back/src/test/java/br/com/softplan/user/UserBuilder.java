package br.com.softplan.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.domain.Role;
import br.com.softplan.domain.User;
import br.com.softplan.enums.RoleUser;

import java.util.Optional;

public class UserBuilder {

    private UserInputDto userInputDto;

    public static UserBuilder oneUser() {
        UserBuilder builder = new UserBuilder();
        initializeDefaultInputDtoData(builder);
        return builder;
    }

    public UserInputDto build() {
        return userInputDto;
    }

    public UserBuilder invalidEmail(String email) {
        userInputDto.setEmail(email);
        return this;
    }

    public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("André");
        user.setLastName("Masiero");
        user.setUsername("andre@andre.com");
        user.setPassword("123456");
        user.setRole(getRole());

        return user;
    }

    public static Optional<User> getUserByIdOptional() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("André");
        user.setLastName("Masiero");
        user.setUsername("andre@andre.com");
        user.setPassword("123456");
        user.setRole(getRole());
        return Optional.of(user);
    }

    private static Role getRole() {
        Role role = new Role();
        role.setName(RoleUser.ROLE_ADMIN);
        return role;
    }

    public static void initializeDefaultInputDtoData(UserBuilder builder) {
        builder.userInputDto = new UserInputDto();
        UserInputDto element = builder.userInputDto;

        element.setFirstName("André");
        element.setLastName("Masiero");
        element.setEmail("andre@andre.com");
        element.setPassword("123456");
        element.setRole(RoleUser.ROLE_ADMIN);
    }
}
