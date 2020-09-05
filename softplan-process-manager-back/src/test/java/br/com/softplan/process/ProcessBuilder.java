package br.com.softplan.process;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.domain.Process;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ProcessBuilder {

    private ProcessInputDto processInputDto;

    public static ProcessBuilder oneProcess() {
        ProcessBuilder builder = new ProcessBuilder();
        initializeDefaultInputDtoData(builder);
        return builder;
    }

    public ProcessInputDto build() {
        return processInputDto;
    }

    public ProcessBuilder withoutUserId() {
        processInputDto.setUsersId(new HashSet<>());
        return this;
    }

    public ProcessBuilder invalidUserId() {
        Set<Long> usersId = new HashSet<>();
        usersId.addAll(Arrays.asList(10L, 20L));
        processInputDto.setUsersId(usersId);
        return this;
    }

    public static void initializeDefaultInputDtoData(ProcessBuilder builder) {
        builder.processInputDto = new ProcessInputDto();
        ProcessInputDto element = builder.processInputDto;

        element.setName("Processo de Contratação André Masiero");
        element.setDescription("Devemos contratar o André, pois ele tem muito a agregar a Softplan");

        Set<Long> usersId = new HashSet<>();
        usersId.addAll(Arrays.asList(1L, 2L));
        element.setUsersId(usersId);
    }

    public static Optional<Process> getProcessByIdOptional() {
        Process process = new Process();
        process.setId(1L);
        process.setName("Processo de Contratação André Masiero");
        return Optional.of(process);
    }
}
