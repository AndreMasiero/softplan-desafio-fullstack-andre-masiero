package br.com.softplan.component.process;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.dto.ProcessOutputDto;
import br.com.softplan.component.process.repositories.CollaboratorsProcessRepository;
import br.com.softplan.component.process.repositories.ProcessRepository;
import br.com.softplan.component.process.validator.ProcessServiceValidator;
import br.com.softplan.component.user.repositories.UserRepository;
import br.com.softplan.domain.CollaboratorsProcess;
import br.com.softplan.domain.Process;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ErrorMessage;
import br.com.softplan.utils.GetUserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;
    private final GetUserService getUserService;
    private final UserRepository userRepository;
    private final ProcessServiceValidator processServiceValidator;
    private final CollaboratorsProcessRepository collaboratorsProcessRepository;

    public ProcessService(ProcessRepository processRepository,
                          GetUserService getUserService,
                          UserRepository userRepository,
                          ProcessServiceValidator processServiceValidator,
                          CollaboratorsProcessRepository collaboratorsProcessRepository) {
        this.processRepository = processRepository;
        this.getUserService = getUserService;
        this.userRepository = userRepository;
        this.processServiceValidator = processServiceValidator;
        this.collaboratorsProcessRepository = collaboratorsProcessRepository;
    }

    public Long create(ProcessInputDto inputDto) throws Exception {

        processServiceValidator.isValid(inputDto, null);

        try {
            Process process = processRepository.save(ProcessMapper.inputDtoToEntity(inputDto, null, getUserService.user(), null));
            saveCollaborators(inputDto, process);
            return process.getId();
        } catch (Exception e) {
            throw new Exception(ErrorMessage.PROCESS_SAVE_ERROR.getDescription());
        }

    }

    public Long update(ProcessInputDto inputDto, Long id) throws Exception {

        processServiceValidator.isValid(inputDto, id);

        try {
            Optional<Process> process = processRepository.findById(id);

            return processRepository.save(ProcessMapper.inputDtoToEntity(inputDto, process.get(), getUserService.user(), id)).getId();
        } catch (Exception e) {
            throw new Exception(ErrorMessage.PROCESS_SAVE_ERROR.getDescription());
        }

    }

    public List<ProcessOutputDto> findAll() {
        return ProcessMapper.entityToOutputDtoList(processRepository.findAll());
    }

    private void saveCollaborators(ProcessInputDto inputDto, Process process) {
        Set<User> collaborators = new HashSet<>();
        inputDto.getUsersId().forEach(userId -> {
            Optional<User> user = userRepository.findById(userId);

            CollaboratorsProcess collaboratorsProcess = new CollaboratorsProcess();
            collaboratorsProcess.setProcess(process);
            collaboratorsProcess.setUser(user.get());
            collaboratorsProcessRepository.save(collaboratorsProcess);
        });
    }
}
