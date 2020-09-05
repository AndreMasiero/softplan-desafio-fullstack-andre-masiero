package br.com.softplan.component.process;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.dto.ProcessOutputDto;
import br.com.softplan.component.user.UserMapper;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.domain.CollaboratorsProcess;
import br.com.softplan.domain.Process;
import br.com.softplan.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessMapper {

    public static Process inputDtoToEntity(ProcessInputDto inputDto, Process process, User user, Long id) {

        if (id == null) {
            process = new Process();
            process.setId(id != null ? id : null);
            process.setName(inputDto.getName());
            process.setDescription(inputDto.getDescription());
            process.setFeedback(false);
            process.setInsertDate(new Date());
            process.setUser(user);
        } else {
            process.setName(inputDto.getName());
            process.setDescription(inputDto.getDescription());
            process.setUpdateDate(new Date());
        }

        return process;
    }

    public static List<ProcessOutputDto> entityToOutputDtoList(List<Process> processes) {
        List<ProcessOutputDto> outputDtos = new ArrayList<>();

        processes.forEach(process -> {
            ProcessOutputDto outputDto = new ProcessOutputDto();
            outputDto.setId(process.getId());
            outputDto.setName(process.getName());
            outputDto.setDescription(process.getDescription());
            outputDto.setInsertDate(process.getInsertDate());
            outputDto.setUpdateDate(process.getUpdateDate() != null ? process.getUpdateDate() : null);
            outputDto.setUsers(getCollaborators(process));

            outputDtos.add(outputDto);
        });

        return outputDtos;
    }

    private static List<UserOutputDto> getCollaborators(Process process) {
        List<User> users = new ArrayList<>();
        for (CollaboratorsProcess collaboratorsProcess : process.getCollaborators()) {
            users.add(collaboratorsProcess.getUser());
        }
        return UserMapper.entityToOutputDtoList(users);
    }

}
