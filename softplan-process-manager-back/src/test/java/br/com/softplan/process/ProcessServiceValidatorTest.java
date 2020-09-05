package br.com.softplan.process;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.repositories.ProcessRepository;
import br.com.softplan.component.process.validator.ProcessServiceValidator;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.user.UserBuilder;
import br.com.softplan.utils.GetUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;

public class ProcessServiceValidatorTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private GetUserService getUserService;

    @Mock
    private ProcessRepository processRepository;

    @InjectMocks
    private ProcessServiceValidator processServiceValidator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mustNotRegisterWithoutAssociatedCollaborators() throws Exception {
        ProcessInputDto inputDto = ProcessBuilder.oneProcess().withoutUserId().build();

        try {
            processServiceValidator.isValid(inputDto, null);
            fail("Deveria ter lançado excessão");
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.PROCESS_UNINFORMED_COLLABORATORS.getDescription()));
        }

    }

    @Test
    public void mustNotRegisterWithIdOfTheInvalidCollaborator_create() {
        ProcessInputDto inputDto = ProcessBuilder.oneProcess().invalidUserId().build();

        doReturn(UserBuilder.getUserByIdOptional()).when(userRepository).findById(2L);

        try {
            processServiceValidator.isValid(inputDto, null);
            fail("Deveria ter lançado excessão");
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.PROCESS_INVALIDE_COLABORATOR_ID.getDescription()));
        }

    }

    @Test
    public void mustNotRegisterWithIdOfTheInvalidCollaborator_update() {
        ProcessInputDto inputDto = ProcessBuilder.oneProcess().invalidUserId().build();

        doReturn(UserBuilder.getUserByIdOptional()).when(userRepository).findById(2L);

        try {
            processServiceValidator.isValid(inputDto, null);
            fail("Deveria ter lançado excessão");
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.PROCESS_INVALIDE_COLABORATOR_ID.getDescription()));
        }

    }

    @Test
    public void throwProcessIdErrorDoesNotExistForUpdate (){
        ProcessInputDto inputDto = ProcessBuilder.oneProcess().build();

        doReturn(ProcessBuilder.getProcessByIdOptional()).when(processRepository).findById(10L);

        try {
            processServiceValidator.isValid(inputDto, 1L);
            fail("Deveria ter lançado excessão");
        } catch (Exception e) {
            assertThat(e.getMessage(), is(ErrorMessage.PROCESS_NOT_FOUND.getDescription()));
        }
    }
}
