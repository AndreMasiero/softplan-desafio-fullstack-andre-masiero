package br.com.softplan.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.component.user.validator.UserServiceValidator;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.utils.GetUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class UserServiceValidatorTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private GetUserService getUserService;

    @InjectMocks
    private UserServiceValidator userServiceValidator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mustNotRegisterWithInvalidEmail() {
        UserInputDto inputDto = UserBuilder.oneUser().invalidEmail("email_invalido").build();

        doReturn(UserBuilder.getUser()).when(userRepository).findByUsername(inputDto.getEmail());
        doReturn(getUser()).when(getUserService).user();

        try {
            userServiceValidator.isValid(inputDto, null);
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.USER_INVALID_EMAIL.getDescription()));
        }
    }

    @Test
    public void mustNotRegisterWithExistsEmail_create() {
        UserInputDto inputDto = UserBuilder.oneUser().build();

        doReturn(UserBuilder.getUser()).when(userRepository).findByUsername(inputDto.getEmail());
        doReturn(getUser()).when(getUserService).user();

        try {
            userServiceValidator.isValid(inputDto, null);
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.USER_EMAIL_ALREADY_IN_USE.getDescription()));
        }
    }

    @Test
    public void mustNotUpdateWithAnotherUsersEmail_update() {
        UserInputDto inputDto = UserBuilder.oneUser().build();

        doReturn(UserBuilder.getUser()).when(userRepository).findByUsername(inputDto.getEmail());
        doReturn(getUser()).when(getUserService).user();

        try {
            userServiceValidator.isValid(inputDto, 2L);
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.USER_EMAIL_UNAVAILABLE.getDescription()));
        }
    }

    private User getUser() {
        return UserBuilder.getUser();
    }

}
