package br.com.softplan.component.process.validator;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.repositories.ProcessRepository;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.domain.Process;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.enums.RoleUser;
import br.com.softplan.utils.GetUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessServiceValidator {

    private final UserRepository userRepository;
    private final GetUserService getUserService;
    private final ProcessRepository processRepository;

    public ProcessServiceValidator(UserRepository userRepository,
                                   GetUserService getUserService,
                                   ProcessRepository processRepository) {
        this.userRepository = userRepository;
        this.getUserService = getUserService;
        this.processRepository = processRepository;
    }

    public void isValid(ProcessInputDto inputDto, Long id) throws Exception {

        if (id != null) {
            Optional<Process> process = processRepository.findById(id);
            if (process.isEmpty())
                throw new Exception(ErrorMessage.PROCESS_NOT_FOUND.getDescription());
        }

        if (id == null && inputDto.getUsersId().size() == 0)
            throw new Exception(ErrorMessage.PROCESS_UNINFORMED_COLLABORATORS.getDescription());

        if (id == null)
            validateCollaborators(inputDto);
    }

    private void validateCollaborators(ProcessInputDto inputDto) throws Exception {
        for (Long userId : inputDto.getUsersId()) {
            Optional<User> user = userRepository.findById(userId);
            if (user.isEmpty())
                throw new Exception(ErrorMessage.PROCESS_INVALIDE_COLABORATOR_ID.getDescription());

            if (user.get().getRole().getName().equals(RoleUser.ROLE_ADMIN))
                throw new Exception(ErrorMessage.PROCESS_INVALIDE_COLABORATOR_PROFILE.getDescription());
        }
    }
}
