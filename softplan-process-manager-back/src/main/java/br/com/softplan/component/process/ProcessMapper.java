package br.com.softplan.component.process;

import br.com.softplan.component.process.dto.*;
import br.com.softplan.component.user.UserMapper;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.domain.CollaboratorsProcess;
import br.com.softplan.domain.Process;
import br.com.softplan.domain.ProcessFeedback;
import br.com.softplan.domain.User;
import br.com.softplan.enums.ProcessStatus;

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
            process.setStatus(ProcessStatus.PENDING);
            process.setInsertDate(new Date());
            process.setUser(user);
        } else {
            process.setName(inputDto.getName());
            process.setDescription(inputDto.getDescription());
            process.setUpdateDate(new Date());
        }

        return process;
    }

    public static ProcessFeedback processFeedbackDtoToEntity(User user, Process process, ProcessFeedbackInputDto inputDto) {
        ProcessFeedback feedback = new ProcessFeedback();
        feedback.setFeedback(inputDto.getFeedback());
        feedback.setProcess(process);
        feedback.setUser(user);
        feedback.setInsertDate(new Date());

        return feedback;
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
            outputDto.setProcessStatus(process.getStatus());

            outputDtos.add(outputDto);
        });

        return outputDtos;
    }

    public static ProcessDetailOutputDto getProcessDetail(Process process) {
        ProcessDetailOutputDto outputDto = new ProcessDetailOutputDto();

        outputDto.setName(process.getName());
        outputDto.setDescription(process.getDescription());
        outputDto.setCollaborators(getCollaborators(process));
        outputDto.setInsertDate(process.getInsertDate());
        outputDto.setStatus(process.getStatus());
        outputDto.setFeedbacks(getFeedbacks(process));

        return outputDto;
    }

    public static List<ProcessFeedbackOutputDto> getFeedbacks(Process process) {
        List<ProcessFeedbackOutputDto> processFeedbackOutputDtos = new ArrayList<>();
        for (ProcessFeedback processFeedback : process.getProcessFeedbacks()) {
            ProcessFeedbackOutputDto processFeedbackOutputDto = new ProcessFeedbackOutputDto();
            processFeedbackOutputDto.setFeedback(processFeedback.getFeedback());
            processFeedbackOutputDto.setInsertDate(processFeedback.getInsertDate());
            processFeedbackOutputDto.setUser(processFeedback.getUser().getFirstName() + " " + processFeedback.getUser().getLastName());

            processFeedbackOutputDtos.add(processFeedbackOutputDto);
        }

        return processFeedbackOutputDtos;
    }

    private static List<UserOutputDto> getCollaborators(Process process) {
        List<User> users = new ArrayList<>();
        for (CollaboratorsProcess collaboratorsProcess : process.getCollaborators()) {
            users.add(collaboratorsProcess.getUser());
        }
        return UserMapper.entityToOutputDtoList(users);
    }

}
